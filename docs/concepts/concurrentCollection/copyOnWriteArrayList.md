# CopyOnWriteArrayList

> Package: `java.util.concurrent` · Related: [fail-fast vs fail-safe iterators](concurrentCollections.md#fail-fast-vs-fail-safe-iterators-with-examples) · Hub: [concurrentCollections.md](concurrentCollections.md)

`CopyOnWriteArrayList` is a **thread-safe** `List` backed by an array. On **writes**, it **copies** the underlying array and swaps the reference so **readers** keep using the old snapshot without locking the whole list for every `get`.

---

## Guide map

| Section                                                  | Content                                        |
| -------------------------------------------------------- | ---------------------------------------------- |
| [Class hierarchy](#class-hierarchy)                      | `Collection` → `List` → `CopyOnWriteArrayList` |
| [Copy-on-write mechanism](#copy-on-write-mechanism)      | Clone on update; reads unaffected              |
| [Slide properties](#properties-from-classroom-notes)     | Ordering, nulls, interfaces, cost              |
| [Fail-safe iteration](#fail-safe-iteration-vs-arraylist) | No CME; iterator cannot remove                 |
| [When to use](#when-to-use-copyonwritearraylist)         | Read-heavy / write-rare pie chart              |
| [Runnable example](#runnable-example)                    | Snapshot vs live list                          |

---

## Class hierarchy

```mermaid
flowchart BT
  Coll["Collection (interface)"]
  List["List (interface)"]
  COW["CopyOnWriteArrayList (class)"]

  Coll --> List
  List -. implements .-> COW
```

<p align="center">
  <img src="images/copyOnWriteArrayList-hierarchy.png" alt="CopyOnWriteArrayList class — Collection, List hierarchy and thread-safe ArrayList copy-on-write summary" width="780" />
</p>

*Figure: classroom slide — thread-safe `ArrayList` style list; each update works on a **cloned** copy; JVM coordinates visibility of the new array reference.*

| Piece                      | Role                                                                      |
| -------------------------- | ------------------------------------------------------------------------- |
| **`List`**                 | Contract: ordered, indexed, allows duplicates                             |
| **`CopyOnWriteArrayList`** | **Thread-safe** implementation: **copy-on-write** for mutating operations |
| vs **`ArrayList`**         | **Not** thread-safe; fail-fast iterator; no copy on `add`                 |

---

## Copy-on-write mechanism

**Idea:** Readers traverse the **current array reference**. Writers **clone** the array, apply the change on the copy, then **publish** the new reference (safe publication so other threads see the new array).

```mermaid
flowchart TD
  subgraph readers ["Read threads"]
    R1["get(i) / iterator"]
    R2["get(j)"]
  end

  subgraph memory ["Backing array references"]
    OLD["array v1 — [A, B]"]
    NEW["array v2 — [A, B, C]"]
  end

  W["Write thread: add(C)"] --> CLONE["Clone v1 → work on copy"]
  CLONE --> MUT["add C on copy"]
  MUT --> PUB["Publish v2 as new reference"]
  R1 --> OLD
  R2 --> OLD
  Note1["Reads during write may still see v1 — no effect on them"]
  PUB --> NEW
```

```text
Before add("C")          During write                    After publish
─────────────────        ─────────────                   ───────────────
 readers ──► [A,B]      writer clones [A,B]             readers ──► [A,B,C]
                          writes [A,B,C]
                          then swaps ref ───────────────►  (new readers see new array)
```

> **Slide point:** Because the update runs on a **cloned copy**, threads doing **read** operations are **not disturbed** by the in-progress write on the new copy until the reference is switched.

```mermaid
sequenceDiagram
  participant R as Reader
  participant COW as CopyOnWriteArrayList
  participant W as Writer

  R->>COW: iterator() on array v1
  W->>COW: add(element)
  Note over COW: clone v1 → v2, mutate v2
  W->>COW: volatile publish v2
  R->>COW: next() still on snapshot v1
  Note over R: no ConcurrentModificationException
```

### Read vs write cost

```mermaid
pie showData
    title Ideal workload for CopyOnWriteArrayList
    "Read operations (fast, no copy)" : 75
    "Write operations (clone whole array)" : 25
```

```mermaid
pie showData
    title Cost model per operation (conceptual)
    "Read — index into current array" : 40
    "Write — O(n) array copy + publish" : 45
    "Iterator — snapshot, no lock on read path" : 15
```

**Slide takeaway:** **Costly for frequent writes** (every update may copy the full backing array). **Best choice** when there are **many reads** and **few writes** (listener lists, snapshot configs, read-mostly caches).

---

## Properties (from classroom notes)

<p align="center">
  <img src="images/copyOnWriteArrayList-properties.png" alt="CopyOnWriteArrayList properties — read/write isolation, insertion order, duplicates, null, Serializable, fail-safe iterator, no iterator remove" width="820" />
</p>

| Property                   | Behavior                                                                                    |
| -------------------------- | ------------------------------------------------------------------------------------------- |
| **Update vs read**         | Update on **clone** → **no effect** on threads reading the **previous** array               |
| **Cost**                   | **High** for writes (copy per mutation) → use when **reads ≫ writes**                       |
| **Insertion order**        | **Preserved**                                                                               |
| **Duplicates**             | **Allowed**                                                                                 |
| **Heterogeneous elements** | **Allowed** (raw / `CopyOnWriteArrayList<Object>`)                                          |
| **`null`**                 | **Allowed**                                                                                 |
| **Extra interfaces**       | `Serializable`, `Cloneable`, `RandomAccess`                                                 |
| **Iterate + modify**       | Other threads may modify; **no** `ConcurrentModificationException` — **fail-safe** iterator |
| **Iterator `remove`**      | **Not supported** — `UnsupportedOperationException` (unlike `ArrayList`)                    |

```mermaid
flowchart LR
  subgraph allowed ["Allowed on COW list"]
    O["insertion order"]
    D["duplicates"]
    H["heterogeneous types"]
    N["null elements"]
  end

  subgraph iterator ["Iterator rules"]
    FS["fail-safe — no CME"]
    NR["no remove / set / add on iterator"]
  end
```

---

## Fail-safe iteration vs `ArrayList`

|                                              | `ArrayList`                                       | `CopyOnWriteArrayList`                                                        |
| -------------------------------------------- | ------------------------------------------------- | ----------------------------------------------------------------------------- |
| Concurrent structural change while iterating | **`ConcurrentModificationException`** (fail-fast) | **Continues** (fail-safe / snapshot)                                          |
| `iterator.remove()`                          | **Supported**                                     | **`UnsupportedOperationException`**                                           |
| What iterator sees                           | Live list until CME                               | **Snapshot** at iterator creation (won’t see later adds on **that** iterator) |

```mermaid
flowchart TD
  Start["Thread 1: iterating"]

  Start --> AL["ArrayList"]
  AL --> Mod["Thread 2: add"]
  Mod --> CME["Fail-fast → CME"]

  Start --> COW["CopyOnWriteArrayList"]
  COW --> Mod2["Thread 2: add (new array)"]
  Mod2 --> OK["Thread 1: next() — still on old snapshot, no CME"]
```

Deep dive with more examples: [Fail-fast vs fail-safe iterators](concurrentCollections.md#fail-fast-vs-fail-safe-iterators-with-examples) (Example 5 uses `CopyOnWriteArrayList`).

---

## When to use `CopyOnWriteArrayList`

```mermaid
flowchart TD
  Q["Need a shared List?"]
  Q --> W{"Writes frequent?"}
  W -- Yes --> Other["Consider synchronized list,<br/>ConcurrentLinkedQueue, or lock"]
  W -- No --> R{"Reads dominate?"}
  R -- Yes --> COW["CopyOnWriteArrayList"]
  R -- No --> HM["Re-evaluate: CHM / sync / single-thread"]

  COW --> Ex["Examples: event listeners,<br/>read-mostly config snapshots"]
```

| Use COW                                            | Avoid COW                                           |
| -------------------------------------------------- | --------------------------------------------------- |
| Many **get** / iterate, rare **add** / **remove**  | Large list + **heavy** add/remove traffic           |
| Tolerance for **stale** iterator view              | Need iterator to see **every** live add immediately |
| Need **fail-safe** iteration without external sync | Need **`iterator.remove()`** during traversal       |

```mermaid
pie showData
    title Typical fit score
    "Great — read-heavy listener list" : 50
    "OK — occasional config refresh" : 30
    "Poor — high churn write workload" : 20
```

---

## Runnable example

Shows **snapshot** behavior: iterator does not see `"Cherry"` added by another thread during the loop, but the **live** list does.

```java
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");

        Thread t = new Thread(() -> {
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            list.add("Cherry");
        });
        t.start();

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
            Thread.sleep(200);
        }
        t.join();
        System.out.println("Live list: " + list); // [Apple, Banana, Cherry]
    }
}
```

```bash
cd /tmp && javac CopyOnWriteDemo.java && java CopyOnWriteDemo
```

**Expected pattern:** iterator prints **Apple**, **Banana** only; final line includes **Cherry**.

```mermaid
pie showData
    title What the iterator saw vs live list
    "Snapshot at iterator create (Apple, Banana)" : 67
    "Added after snapshot (Cherry) — live list only" : 33
```

### Iterator `remove` — not allowed

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
list.add("x");
var it = list.iterator();
it.next();
it.remove(); // UnsupportedOperationException
```

---

## Compare with related types

| Type                             | Iterator                          | Write cost      | Best for                     |
| -------------------------------- | --------------------------------- | --------------- | ---------------------------- |
| **`ArrayList`**                  | Fail-fast                         | Low             | Single-threaded              |
| **`Vector` / synchronized list** | Fail-fast                         | Whole-list lock | Legacy                       |
| **`CopyOnWriteArrayList`**       | Fail-safe snapshot                | Copy array      | **Read-mostly** shared lists |
| **`ConcurrentHashMap`**          | Weakly consistent (map, not list) | Bin-level       | Shared maps                  |

---

## See also

- [concurrentCollections.md](concurrentCollections.md) — hub, `threadDemo`, iterator examples
- [concurrentHashMap.md](concurrentHashMap.md) — concurrent maps and fail-safe map iteration
# Flow Analysis: Fixing Race Conditions in copyOnWriteAlDemo

When running `copyOnWriteAlDemo`, if the child thread sleeps for 3 seconds (`3000ms`) while the main thread's loop only takes 2 seconds (`2000ms`), the program will exit before the child thread ever adds the element. Adding **`childThread.join()`** forces the main thread to wait for the background update to complete.

---

## 1. Complete Source Code

### Class 1: `childThreadBase.java`
```java
import java.util.concurrent.CopyOnWriteArrayList;

public class childThreadBase extends Thread {

    // Keeping your exact static collection object variable
    public static CopyOnWriteArrayList<String> coal = new CopyOnWriteArrayList<String>();

    @Override
    public void run() {
        try {
            // Keeps your exact 3-second processing delay simulation
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted.");
        }

        System.out.println("\n[Child Thread] Waking up and executing -> coal.add(\"Kunti\")");
        coal.add("Kunti");
    }
}
```

### Class 2: `copyOnWriteAlDemo.java`
```java
import java.util.Iterator;

public class copyOnWriteAlDemo {
    public static void main(String[] args) throws InterruptedException {

        // 1. Adding initial entries directly to your static 'coal' object
        childThreadBase.coal.add("panduraju");
        childThreadBase.coal.add("Maadhri");

        System.out.println("Main thread is running.");

        // 2. Initializing and starting your custom thread
        childThreadBase childThread = new childThreadBase();
        childThread.start();

        // 3. Capturing your Iterator from the 'coal' list instance
        Iterator<String> itr = childThreadBase.coal.iterator();

        // 4. Looping through the captured snapshot (Takes exactly 2 seconds)
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println("Main Thread is iterating List: " + element);
            Thread.sleep(1000); 
        }
        System.out.println("Main Thread has finished iterating the List.");

        // =====================================================================
        // THE FIX FOR THE FLAKY BEHAVIOR:
        // Forces the main thread to stop here and wait for the childThread 
        // to complete its 3-second sleep and execute its add() operation.
        // =====================================================================
        System.out.println("Main Thread waiting for Child Thread to add its element...");
        childThread.join(); 

        // 5. Printing the final collection showing your updated elements
        System.out.println("\nFinal state of coal: " + childThreadBase.coal);
    }
}
```

---

## 2. Program Execution Flowchart

This flowchart outlines the chronological execution blocks of your code, showing how `childThread.join()` holds the main thread execution line.

```mermaid
graph TD
    Start([Start copyOnWriteAlDemo main]) --> SeedData[Add 'panduraju' & 'Maadhri' to coal]
    SeedData --> SpawnThread[childThread.start]
    
    subgraph childThreadBase Thread Execution
        SpawnThread -->|Asynchronous| ChildSleep[Sleeps for 3000ms]
        ChildSleep --> ChildAdd[coal.add 'Kunti']
        ChildAdd --> ChildEnd([Child Thread Terminates])
    end

    subgraph main Thread Loop Execution
        SpawnThread --> GetItr[itr = coal.iterator]
        GetItr --> LoopCondition{itr.hasNext?}
        LoopCondition -->|Yes| PrintItem[Print element & Sleep 1000ms]
        PrintItem --> LoopCondition
        LoopCondition -->|No| JoinBarrier{childThread.join}
        JoinBarrier -->|Blocks Main until finish| ChildEnd
        ChildEnd --> PrintFinal[Print final contents of coal]
        PrintFinal --> End([End Main Method])
    end
```

---

## 3. Simultaneous Timeline Interaction

This map plots why `"Kunti"` is hidden inside the iterator loop but visible inside the final string output representation.

```mermaid
sequenceDiagram
    autonumber
    actor Main as Main Thread (copyOnWriteAlDemo)
    actor Child as Child Thread (childThreadBase)
    participant List as CopyOnWriteArrayList (coal)

    Main->>List: Add initial values: "panduraju", "Maadhri"
    Main->>Child: start()
    Note over Child: enters run(), begins 3000ms sleep
    Main->>List: itr = coal.iterator() (Clones snapshot pointer)
    
    Note over Main: Loop index 1: Prints "panduraju" (Timeline: 1000ms passed)
    Note over Main: Loop index 2: Prints "Maadhri" (Timeline: 2000ms passed)
    Note over Main: Iterator loop closes successfully.
    
    Note over Main: Enters join() barrier. Main pauses here.
    Note over Child: 3000ms expires. Child Thread wakes up.
    
    Child->>List: coal.add("Kunti") (Generates a clean array copy in memory)
    Note over Child: childThreadBase completes execution.
    
    Main->>Main: join() unblocks. Main thread resumes.
    Main->>List: Prints final collection output
    Note over Main: Displays current modified array state: [panduraju, Maadhri, Kunti]
```

