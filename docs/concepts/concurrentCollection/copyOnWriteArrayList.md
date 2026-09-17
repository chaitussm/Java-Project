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
| [Classroom execution (A,B,C + D)](#classroom-execution-add-after-iterator) | Slide program — full flow, output **A B C** |
| [`unsupportedOperationexception.java`](#unsupportedoperationexception-demo) | Why `iterator.remove()` throws               |
| [Multi-thread demo](#multi-thread-execution-copyonwritealdemo) | `copyOnWriteAlDemo` + timeline                 |
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

## Classroom execution: add after `iterator()`

Classic slide program: build list **A, B, C**, create **`iterator`**, then **`l.add("D")`**, then loop. Output is **A**, **B**, **C** only — **not D**.

<p align="center">
  <img src="images/copyOnWriteArrayList-iterator-snapshot-slide.png" alt="CopyOnWriteArrayList classroom example — add D after iterator, output A B C, reason snapshot vs ArrayList CME" width="820" />
</p>

### Source (slide)

```java
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class Test {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
        l.add("A");
        l.add("B");
        l.add("C");

        Iterator<String> itr = l.iterator();
        l.add("D"); // modification after iterator created

        while (itr.hasNext()) {
            String s = itr.next();
            System.out.println(s);
        }
    }
}
```

### Verified output

```text
A
B
C
```

### Execution summary (step by step)

| Step | What runs | Backing array / iterator |
| ---- | --------- | ------------------------- |
| 1 | `add("A")`, `add("B")`, `add("C")` | Live list → `[A, B, C]` |
| 2 | `itr = l.iterator()` | **`COWIterator` holds snapshot reference** to array `[A, B, C]` |
| 3 | `l.add("D")` | **Copy-on-write:** new array `[A, B, C, D]`; list ref updated; **iterator still points at old array** |
| 4 | `while (itr.hasNext())` / `next()` | Walks **snapshot** only → prints **A, B, C** |
| 5 | (after loop) | Live list is `[A, B, C, D]`; iterator never saw **D** |

### Reason (from slide)

1. Every **update** works on a **separate copy** of the array. After the iterator is created, later **`add`** changes the **live** list but **does not change the iterator’s snapshot**.
2. If you use **`ArrayList`** instead and call `add("D")` after `iterator()`, the next `next()` typically throws **`ConcurrentModificationException`** (fail-fast).

```mermaid
flowchart TD
  S1["add A, B, C"] --> S2["iterator() — snapshot [A,B,C]"]
  S2 --> S3["add D on list"]
  S3 --> S4["new live array [A,B,C,D]"]
  S2 --> S5["iterator still uses [A,B,C]"]
  S5 --> S6["next() × 3 → print A, B, C"]
  S4 --> S7["D visible only to new iterators / list.toString()"]
```

```mermaid
sequenceDiagram
  participant Main as main
  participant COW as CopyOnWriteArrayList
  participant It as COWIterator (snapshot)

  Main->>COW: add A, B, C
  Main->>It: iterator() binds to array v1 [A,B,C]
  Main->>COW: add(D) — clones v1 → v2 [A,B,C,D]
  Note over COW: live ref = v2
  loop hasNext / next
    Main->>It: next()
    It-->>Main: A, then B, then C
  end
  Note over It: never reads v2 — no D, no CME
```

```mermaid
flowchart LR
  subgraph cow ["CopyOnWriteArrayList"]
    A1["iterator created"] --> A2["add D"]
    A2 --> A3["print A B C — OK"]
  end

  subgraph al ["ArrayList (contrast)"]
    B1["iterator created"] --> B2["add D"]
    B2 --> B3["next() → ConcurrentModificationException"]
  end
```

```mermaid
pie showData
    title Elements seen by iterator after add(D)
    "Snapshot A, B, C" : 75
    "Live-only D (not on this iterator)" : 25
```

---

## `UnsupportedOperationException` demo

Runnable class: [`unsupportedOperationexception.java`](../../../demo/src/main/java/com/concurrentCollection/copyOnWriteArrayListClass/unsupportedOperationexception.java)

The list is **modifiable** via `coal.add(...)`, but **`Iterator.remove()`** is **not** supported on `CopyOnWriteArrayList` (snapshot iterator).

```mermaid
flowchart TD
  A["iterator() on COW list"] --> B["next() until element equals yashoda"]
  B --> C["iterator.remove()"]
  C --> D["CopyOnWriteArrayList$COWIterator.remove()"]
  D --> E["throw UnsupportedOperationException"]
```

| | `ArrayList` iterator | `CopyOnWriteArrayList` iterator |
| --- | ---------------------- | ------------------------------- |
| `remove()` | Updates backing list (with fail-fast rules) | **Always unsupported** — would break snapshot semantics |
| Fix | Use `list.remove(...)` or iterator.remove on `ArrayList` | Remove via **`list.remove(element)`**, not `iterator.remove()` |

Full walkthrough: [unsupportedOperationException.md](unsupportedOperationException.md).

---

## Multi-thread execution: `copyOnWriteAlDemo`

Demo: [`copyOnWriteAlDemo.java`](../../../demo/src/main/java/com/concurrentCollection/copyOnWriteArrayListClass/updationByoneThreadwhileOtherThreadExceution/copyOnWriteAlDemo.java) · child thread: [`childThreadBase.java`](../../../demo/src/main/java/com/concurrentCollection/copyOnWriteArrayListClass/updationByoneThreadwhileOtherThreadExceution/childThreadBase.java)

| Phase | Main thread | Child thread | `coal` (live) | Iterator snapshot |
| ----- | ----------- | ------------ | ------------- | ----------------- |
| Start | `add` panduraju, Maadhri | — | `[panduraju, Maadhri]` | — |
| T0 | `start()` child | sleeps 3000 ms | unchanged | — |
| T0 | `iterator()` | sleeping | unchanged | **`[panduraju, Maadhri]`** |
| T0–2s | loop + sleep 1s × 2 | sleeping | unchanged | prints both names |
| ~3s | may finish loop | `add("Kunti")` | **`[..., Kunti]`** | still old snapshot |
| End | prints `coal` | done | shows **Kunti** if child finished | loop never saw **Kunti** |

Without **`childThread.join()`**, main can print the final list **before** the child adds **Kunti** (race). Use **`join()`** when you need the final print to include the child’s update.

```mermaid
sequenceDiagram
  participant Main
  participant Child as childThreadBase
  participant coal as CopyOnWriteArrayList

  Main->>coal: add panduraju, Maadhri
  Main->>Child: start()
  Main->>coal: iterator() snapshot
  par main loop ~2s
    Main->>Main: print each element
  and child ~3s
    Child->>Child: sleep 3000
    Child->>coal: add Kunti (new array)
  end
  Main->>Main: println final coal (may need join() first)
```

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

- [unsupportedOperationException.md](unsupportedOperationException.md) — `iterator.remove()` internal flow
- [concurrentCollections.md](concurrentCollections.md) — hub, `threadDemo`, iterator examples
- [concurrentHashMap.md](concurrentHashMap.md) — concurrent maps and fail-safe map iteration

