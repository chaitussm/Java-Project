# Concurrent collections hub

| Guide | Topics |
| ----- | ------ |
| **This file** | **Fail-fast vs fail-safe iterators**, `ConcurrentModificationException`, comparisons |
| **[concurrentHashMap.md](concurrentHashMap.md)** | **`HashMap` vs `ConcurrentHashMap`**; **CHM vs `synchronizedMap` vs `Hashtable`**; iterators |
| **[concurrentMap.md](concurrentMap.md)** | `concurrentMap` / `concurrentHashMap` demos, `ConcurrentMap` API, **ConcurrentHashMap buckets & internals** |

> Fail-fast demo: [`threadDemo.java`](../../../demo/src/main/java/com/concurrentCollection/ConcurrentModificationException/threadDemo.java) · Concurrent maps: [`concurrentMap.java`](../../../demo/src/main/java/com/concurrentCollection/concurrentMap/concurrentMap.java) · [`concurrentHashMap.java`](../../../demo/src/main/java/com/concurrentCollection/concurrentMap/concurrentHashMap.java)

---

## Why concurrent collections matter

| Issue                   | Non-concurrent collections                                              | `java.util.concurrent` collections                             |
| ----------------------- | ----------------------------------------------------------------------- | -------------------------------------------------------------- |
| Thread safety           | Most structures are **not** safe for unsynchronized multi-thread access | Designed for **concurrent** read/write                         |
| Legacy sync wrappers    | `Collections.synchronized*` locks the **whole** collection — see [bucket vs whole-map lock](concurrentMap.md#bucket-level-lock-vs-whole-collection-lock) | Per-bin locks / CAS (e.g. `ConcurrentHashMap`) — [same section](concurrentMap.md#bucket-level-lock-vs-whole-collection-lock) |
| Iterator + modification | **Fail-fast** `Iterator` → `ConcurrentModificationException`            | Iterators designed for weak consistency / no CME in many cases |

Point **3** is exactly what `threadDemo` demonstrates on a plain **`ArrayList`**.

---

## `threadDemo.java` — complete execution flow

### Source (reference)

```java
public class threadDemo extends Thread {
    static ArrayList<String> arraylist = new ArrayList<>();

    @Override
    public void run() {
        Thread.sleep(1000);
        arraylist.add("apple");  // structural modification from child thread
    }

    public static void main(String[] args) throws InterruptedException {
        arraylist.add("banana");
        arraylist.add("pomegranate");

        threadDemo t = new threadDemo();
        t.start();

        Iterator<String> iterator = arraylist.iterator();
        while (iterator.hasNext()) {
            String data = iterator.next();
            System.out.println(data);
            Thread.sleep(500);
        }
        System.out.println("Final array list: " + arraylist);
    }
}
```

### Roles

| Piece                                    | Role                                                           |
| ---------------------------------------- | -------------------------------------------------------------- |
| **`static ArrayList<String> arraylist`** | Shared list — **not** thread-safe                              |
| **`main`**                               | Fills list, starts child, iterates with **`Iterator`**         |
| **`threadDemo` (child `Thread`)**        | After 1s, **`add("apple")`** while main may still be iterating |
| **`Iterator`**                           | Fail-fast view; tracks **`expectedModCount`** at creation time |

### Timeline (two threads)

```mermaid
sequenceDiagram
  participant Main as main thread
  participant List as ArrayList
  participant Child as threadDemo (child)
  participant It as Iterator

  Main->>List: add banana, pomegranate
  Main->>Child: start()
  Main->>It: iterator()
  Main->>It: next() → banana
  Note over Main: sleep 500ms
  Main->>It: next() → pomegranate
  Note over Main: sleep 500ms
  Child->>List: add apple (modCount++)
  Main->>It: hasNext() / next()
  It-->>Main: ConcurrentModificationException
```

```mermaid
gantt
    title threadDemo timing (approximate)
    dateFormat X
    axisFormat %Ls

    section main
    add banana & pomegranate :0, 1
    iterator + next banana   :1, 500
    sleep                    :500, 500
    next pomegranate         :1000, 500
    sleep                    :1500, 500
    next (fails)             :2000, 1

    section child
    sleep 1000ms             :0, 1000
    add apple                :1000, 1
```

### Program phases

```mermaid
pie showData
    title Share of work in threadDemo.main + run()
    "main: populate list" : 15
    "main: iterator loop + sleep" : 55
    "child: sleep then add" : 20
    "JVM: modCount / fail-fast check" : 10
```

---

## How `ConcurrentModificationException` occurs (fail-fast)

`ArrayList` (and most `java.util` collections) use a **`modCount`** field: incremented on every **structural** change (`add`, `remove`, `clear`, …).

When you call **`iterator()`**, the iterator stores **`expectedModCount = modCount`**.

On each **`iterator.next()`** (and related operations), **`checkForComodification()`** runs:

```text
if (modCount != expectedModCount) → throw ConcurrentModificationException
```

```mermaid
flowchart TD
  A["main: arraylist.iterator()"] --> B["expectedModCount = modCount (e.g. 2)"]
  B --> C["next() → banana OK"]
  C --> D["next() → pomegranate OK"]
  D --> E["child: arraylist.add(apple)"]
  E --> F["modCount becomes 3"]
  F --> G["main: iterator.next() again"]
  G --> H{"modCount == expectedModCount?"}
  H -- No --> I["ConcurrentModificationException"]
  H -- Yes --> J["return next element"]
```

| Event                    | `modCount` | Iterator `expectedModCount` | Result                         |
| ------------------------ | ---------- | --------------------------- | ------------------------------ |
| After 2 `add`s in `main` | 2          | —                           | —                              |
| `iterator()` created     | 2          | **2**                       | OK                             |
| `next()` × 2             | 2          | 2                           | Prints `banana`, `pomegranate` |
| Child `add("apple")`     | **3**      | 2 (stale)                   | List now has 3 elements        |
| Next `next()`            | 3 ≠ 2      | —                           | **Exception**                  |

> **Important:** The exception is thrown in the **thread that uses the iterator** (`main`), even though the **other thread** (`child`) performed the `add`. Any structural change—same thread or another—invalidates a fail-fast iterator unless you use **`iterator.remove()`** on that iterator.

```mermaid
flowchart LR
  subgraph wrong ["Unsafe while iterating"]
    W1["list.add() from another thread"]
    W2["list.remove() in main without Iterator"]
  end
  subgraph ok ["Safe patterns"]
    O1["iterator.remove()"]
    O2["CopyOnWriteArrayList / concurrent collections"]
    O3["Synchronize access + no concurrent iterator"]
  end
```

---

## Verified output

```text
banana
pomegranate
Child thread is updating the list : 
Exception in thread "main" java.util.ConcurrentModificationException
    at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    at com.concurrentCollection.ConcurrentModificationException.threadDemo.main(threadDemo.java:35)
```

`Final array list:` is **not** printed — the loop never completes.

---

## Run the demo

```bash
cd demo
javac -d /tmp/thdemo src/main/java/com/concurrentCollection/ConcurrentModificationException/threadDemo.java
java -cp /tmp/thdemo com.concurrentCollection.ConcurrentModificationException.threadDemo
```

Or with Maven:

```bash
cd demo
mvn -q exec:java -Dexec.mainClass=com.concurrentCollection.ConcurrentModificationException.threadDemo
```

---

## Fail-fast vs fail-safe iterators (with examples)

| Term | What it means | Typical types |
| ---- | ------------- | ------------- |
| **Fail-fast** | If the collection is **structurally modified** while you iterate (add/remove, not `iterator.remove()`), the **next** iterator step throws **`ConcurrentModificationException`**. | `ArrayList`, `HashMap`, `HashSet`, most `java.util` collections |
| **Fail-safe** (classroom name) | Iterator keeps going; **no CME**. You may see a **snapshot** or **weak** view — not guaranteed to include every change made while you iterate. JDK docs often say **weakly consistent**. | `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue`, … |

```mermaid
pie showData
    title Iterator families in typical Java apps
    "Fail-fast (java.util)" : 55
    "Fail-safe / weakly consistent (java.util.concurrent)" : 35
    "Manual sync + external rules" : 10
```

### Master flow: what happens on `iterator.next()` after a structural change?

```mermaid
flowchart TD
  Start["Iterator created"] --> Next["call next()"]
  Next --> Mod{"Structural change since<br/>iterator was created?"}
  Mod -- No --> OK["Return next element"]
  Mod -- Yes --> Kind{"Collection type?"}
  Kind --> FF["Fail-fast<br/>ArrayList, HashMap, …"]
  FF --> CME["ConcurrentModificationException"]
  Kind --> FS["Fail-safe / weakly consistent<br/>CHM, COW list, …"]
  FS --> Cont["Return next element<br/>(may skip or include concurrent adds)"]
```

```mermaid
pie showData
    title Outcome when another thread adds during iteration
    "Fail-fast: stop with CME" : 50
    "Fail-safe: iteration continues" : 50
```

---

### Example 1 — Fail-fast (`ArrayList`, same thread)

Structural change **in the same thread** still triggers fail-fast if you do not use **`iterator.remove()`**.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");

        Iterator<String> it = list.iterator();
        System.out.println(it.next()); // alpha

        list.add("gamma");           // structural change outside iterator

        System.out.println(it.next()); // ConcurrentModificationException on beta step
    }
}
```

```mermaid
sequenceDiagram
  participant Main as main thread
  participant List as ArrayList
  participant It as Iterator

  Main->>List: add alpha, beta
  Main->>It: iterator() — expectedModCount = 2
  Main->>It: next() → alpha
  Main->>List: add gamma — modCount = 3
  Main->>It: next()
  It-->>Main: ConcurrentModificationException
```

---

### Example 2 — Fail-fast (`ArrayList`, another thread) — repo demo

[`threadDemo.java`](../../../demo/src/main/java/com/concurrentCollection/ConcurrentModificationException/threadDemo.java) is the **two-thread** version: main iterates while the child calls `arraylist.add("apple")`. Same fail-fast rule; the exception appears on **main** at `iterator.next()`.

---

### Example 3 — Fail-fast (`HashMap`)

Maps use the same **`modCount`** idea on the entry set iterator.

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        System.out.println(it.next());

        map.put(3, "three");           // structural change

        System.out.println(it.next()); // ConcurrentModificationException
    }
}
```

```mermaid
flowchart LR
  A["HashMap iterator"] --> B["put / remove on map"]
  B --> C["modCount changed"]
  C --> D["next() → CME"]
```

---

### Example 4 — Fail-safe (`ConcurrentHashMap`)

Another thread (or the same thread) may **`put`** while you iterate. The iterator **does not** throw CME; it may or may not show entries added mid-loop.

```java
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeMapExample {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        System.out.println(it.next());

        map.put("c", "3");             // allowed during iteration

        while (it.hasNext()) {
            System.out.println(it.next()); // no CME; may or may not print c=3
        }
        System.out.println("Done: " + map);
    }
}
```

```mermaid
sequenceDiagram
  participant T1 as iterating thread
  participant CHM as ConcurrentHashMap
  participant T2 as other thread

  T1->>CHM: entrySet().iterator()
  T1->>CHM: next()
  T2->>CHM: put(c, 3)
  T1->>CHM: next() / hasNext()
  Note over T1,CHM: No ConcurrentModificationException
```

More map-focused diagrams: [concurrentHashMap.md — iteration](concurrentHashMap.md#iteration-while-another-thread-modifies).

---

### Example 5 — Fail-safe (`CopyOnWriteArrayList`)

On **write**, the list copies its backing array; the iterator keeps a **snapshot** from creation time.

```java
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("x");
        list.add("y");

        Iterator<String> it = list.iterator();
        System.out.println(it.next());

        list.add("z");                 // copy-on-write; iterator unchanged

        System.out.println(it.next()); // still y — snapshot did not include z
        System.out.println("Full list: " + list);
    }
}
```

```mermaid
flowchart TD
  subgraph cow ["CopyOnWriteArrayList"]
    Snap["Iterator holds snapshot array"]
    Write["add(z) → new array copy"]
  end
  Snap --> R["next() reads old snapshot — no CME"]
  Write --> Live["Live list has z"]
```

```mermaid
pie showData
    title Fail-safe strategies (conceptual)
    "Weakly consistent view (ConcurrentHashMap)" : 45
    "Snapshot at iterator creation (CopyOnWriteArrayList)" : 40
    "Other concurrent queues / sets" : 15
```

---

### Quick comparison

| Question | Fail-fast | Fail-safe / weakly consistent |
| -------- | --------- | ------------------------------ |
| Throws CME on concurrent structural change? | **Yes** | **No** |
| Safe to share map/list unsynchronized? | **No** (for writers) | **Yes** (for designed concurrent types) |
| Iterator sees all concurrent adds? | N/A (fails first) | **Not guaranteed** |
| Fix for `ArrayList` / `HashMap` | Do not modify while iterating; sync externally | Use `java.util.concurrent` type |

---

## Relation to concurrent collections

| Approach                       | CME on concurrent modification?                                              | Typical use                                  |
| ------------------------------ | ---------------------------------------------------------------------------- | -------------------------------------------- |
| `ArrayList` + `Iterator`       | **Yes** (fail-fast)                                                          | Single-threaded or fully synchronized access |
| `Collections.synchronizedList` | Still fail-fast iterator; **must sync** on list during iteration             | Legacy                                       |
| `CopyOnWriteArrayList`         | Iterator sees **snapshot**; no CME from adds                                 | Read-heavy, rare writes                      |
| `ConcurrentHashMap`            | **No** `ConcurrentModificationException` on iterator; weakly consistent view | Shared maps                                  |

This demo intentionally uses a **non-concurrent** `ArrayList` and two threads so the fail-fast rule is easy to see. For production multi-threaded code, prefer types from **`java.util.concurrent`** or explicit synchronization—not shared mutation during iteration.

---

## Why `java.util.concurrent` collections exist

1. **Traditional** structures (`ArrayList`, `HashMap`, …) are not safe for unsynchronized multi-thread access — you risk torn reads and corrupted internal state.
2. **Legacy thread-safe** types (`Vector`, `Hashtable`, `Collections.synchronized*`) lock the **whole** collection for many operations, so throughput drops when many threads compete.
3. **Fail-fast iterators** on ordinary collections throw **`ConcurrentModificationException`** when another thread (or the same thread) structurally modifies the collection during iteration — exactly what [`threadDemo`](../../../demo/src/main/java/com/concurrentCollection/ConcurrentModificationException/threadDemo.java) shows.
4. **`java.util.concurrent`** adds collections designed for **parallel** access (finer locking, CAS, or copy-on-write snapshots).

---

## Traditional vs concurrent collections

| Feature                       | Traditional Collections (e.g., `ArrayList`, `HashMap`)                                                                             | Concurrent Collections (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`)                                             |
| :---------------------------- | :--------------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------- |
| **Thread Safety**             | **Not Thread-Safe**. Multiple threads modifying the collection simultaneously will cause data corruption or crashes.               | **Thread-Safe**. Built from the ground up to handle simultaneous reads and writes from multiple threads safely.        |
| **Iterator Behavior**         | **Fail-Fast**. Throws a `ConcurrentModificationException` immediately if the collection is structurally modified during iteration. | **Weakly Consistent / Fail-Safe**. Allows safe modification during iteration without throwing any exceptions.          |
| **Locking Mechanism**         | No internal locking mechanisms. (Legacy synchronized wrappers lock the **entire** collection).                                     | Uses **fine-grained locking** (like lock striping) or **lock-free algorithms** (like Compare-And-Swap/CAS).            |
| **Performance & Scalability** | High performance in single-threaded environments, but slows down completely if wrapped in manual synchronization locks.            | High performance and scalability in multi-threaded environments because threads rarely have to wait in line.           |
| **Memory Overhead**           | Low memory footprint. Only stores the actual data elements.                                                                        | Higher memory footprint (e.g., `CopyOnWriteArrayList` creates a brand new copy of the array on every write operation). |
| **Package Location**          | Found in the standard `java.util` package.                                                                                         | Found in the specialized `java.util.concurrent` package.                                                               |
| **Best Used For**             | Local variables, single-threaded applications, or data that never changes after initialization.                                    | Shared caches, producer-consumer queues, and high-throughput multi-threaded background workers.                        |

## Common concurrent collection types

| Type | Package role |
| ---- | ------------ |
| **`ConcurrentHashMap`** | Shared maps; bin-level locking / CAS — see **[concurrentMap.md](concurrentMap.md)** (constructors, `putIfAbsent`, **bucket internals**) |
| **`CopyOnWriteArrayList`** | Snapshot iterators; copy backing array on write |
| **`CopyOnWriteArraySet`** | Set view over copy-on-write list |
| **`ConcurrentSkipListMap` / `ConcurrentSkipListSet`** | Sorted concurrent navigable structures (also covered in [concurrentMap.md](concurrentMap.md) constructors) |
