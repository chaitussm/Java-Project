# Map (`map` package)

> Map hierarchy, views, **NavigableMap** / `navigableMap.java`, and `mapDemo` launchers.
>
> [← Back to Java Collections Guide](collections.md)

---

### `map` folder launchers (all extend `mapDemo`)

| File | `main` runs |
| ---- | ----------- |
| [`hashMap.java`](../../../demo/src/main/java/com/collections/map/hashMap.java) | `demonstrateMap("HashMap")` |
| [`linkedHashMap.java`](../../../demo/src/main/java/com/collections/map/linkedHashMap.java) | `demonstrateMap("LinkedHashMap")` |
| [`treeMap.java`](../../../demo/src/main/java/com/collections/map/treeMap.java) | `demonstrateMap("TreeMap")` |
| [`sortedMap.java`](../../../demo/src/main/java/com/collections/map/sortedMap.java) | `demonstrateMap("SortedMap")` |
| [`navigableMap.java`](../../../demo/src/main/java/com/collections/map/navigableMap.java) | `demonstrateMap("NavigableMap")` — **full walkthrough below** |
| [`hashTable.java`](../../../demo/src/main/java/com/collections/map/hashTable.java) | Hashtable via `mapDemo` (see also [Hashtable bucket demo](hashTable.md)) |

Shared implementation: [`mapDemo.java`](../../../demo/src/main/java/com/collections/map/mapDemo.java) (`mapCollectionType`, `mapConstructors`, …).

## Map constructor examples

```java
new HashMap<>();
new HashMap<>(20);
new HashMap<>(20, 0.80f);
new HashMap<>(map);

new LinkedHashMap<>();
new LinkedHashMap<>(20);
new LinkedHashMap<>(20, 0.80f);
new LinkedHashMap<>(20, 0.80f, true); // access-order mode
new LinkedHashMap<>(map);

new TreeMap<>();
new TreeMap<>(Comparator.reverseOrder());
new TreeMap<>(map);
new TreeMap<>(sortedMap);

new Hashtable<>();
new Hashtable<>(20);
new Hashtable<>(20, 0.80f);
new Hashtable<>(map);
```

The integer argument controls initial capacity, the `float` argument controls load factor, and the collection/map argument copies entries from an existing object.

---

---

## Map (I)

Map is not child interface of Collection (I) , if we want to represent a group objects as Key Value pairs 
then we should go for map.Duplicate Keys are not allowed but Values can be duplicated.

## Map Interface Hierarchy


- [Map constructors — `mapConstructors(String)`](../../../demo/src/main/java/com/collections/map/mapDemo.java)
- 
`Map` is separate from `Collection`: it stores a mapping from each unique key to one value. A solid arrow means **extends** and a dashed arrow means **implements**.

```mermaid
classDiagram
  direction TB

  class Map~K,V~ {
    <<interface>>
    +put(K key, V value) V
    +get(Object key) V
    +remove(Object key) V
    +containsKey(Object key) boolean
    +keySet() Set~K~
    +values() Collection~V~
    +entrySet() Set~Entry~K,V~~
  }

  class Map_Entry~K,V~ {
    <<nested interface>>
    +getKey() K
    +getValue() V
    +setValue(V value) V
  }

  class SortedMap~K,V~ {
    <<interface>>
  }

  class NavigableMap~K,V~ {
    <<interface>>
    +lowerEntry(K key) Entry~K,V~
    +floorEntry(K key) Entry~K,V~
    +ceilingEntry(K key) Entry~K,V~
    +higherEntry(K key) Entry~K,V~
  }

  class ConcurrentMap~K,V~ {
    <<interface>>
    +putIfAbsent(K key, V value) V
  }

  class ConcurrentNavigableMap~K,V~ {
    <<interface>>
  }

  class AbstractMap~K,V~ {
    <<abstract>>
  }

  class Dictionary~K,V~ {
    <<abstract, legacy>>
  }

  class HashMap~K,V~ {
    Hash table
  }

  class LinkedHashMap~K,V~ {
    Insertion/access order
  }

  class TreeMap~K,V~ {
    Sorted red-black tree
  }

  class EnumMap~K,V~ {
    Enum keys only
  }

  class WeakHashMap~K,V~ {
    Weak keys
  }

  class IdentityHashMap~K,V~ {
    Identity (==) keys
  }

  class ConcurrentHashMap~K,V~ {
    Concurrent hash table
  }

  class ConcurrentSkipListMap~K,V~ {
    Concurrent sorted map
  }

  class Hashtable~K,V~ {
    <<legacy>>
    Synchronized hash table
  }

  class Properties {
    <<legacy>>
    Configuration properties
  }

  Map~K,V~ <|-- SortedMap~K,V~
  SortedMap~K,V~ <|-- NavigableMap~K,V~
  Map~K,V~ <|-- ConcurrentMap~K,V~
  NavigableMap~K,V~ <|-- ConcurrentNavigableMap~K,V~
  ConcurrentMap~K,V~ <|-- ConcurrentNavigableMap~K,V~
  Map~K,V~ *-- Map_Entry~K,V~ : nested Entry

  Map~K,V~ <|.. AbstractMap~K,V~
  AbstractMap~K,V~ <|-- HashMap~K,V~
  HashMap~K,V~ <|-- LinkedHashMap~K,V~
  AbstractMap~K,V~ <|-- TreeMap~K,V~
  AbstractMap~K,V~ <|-- EnumMap~K,V~
  AbstractMap~K,V~ <|-- WeakHashMap~K,V~
  AbstractMap~K,V~ <|-- IdentityHashMap~K,V~
  AbstractMap~K,V~ <|-- ConcurrentHashMap~K,V~
  AbstractMap~K,V~ <|-- ConcurrentSkipListMap~K,V~
  Dictionary~K,V~ <|-- Hashtable~K,V~
  Hashtable~K,V~ <|-- Properties

  NavigableMap~K,V~ <|.. TreeMap~K,V~
  ConcurrentMap~K,V~ <|.. ConcurrentHashMap~K,V~
  ConcurrentNavigableMap~K,V~ <|.. ConcurrentSkipListMap~K,V~
  Map~K,V~ <|.. Hashtable~K,V~
```

### Interfaces

- **`Map<K, V>`**: base key-value interface.
- **`Map.Entry<K, V>`**: nested interface representing one key-value pair, normally accessed through `entrySet()`.
- **`SortedMap<K, V>`**: map whose keys remain sorted.
- It is the child interface of Map interface if we want to represent a group of Key value pairs according to some        - sorting of Keys then we should go for SortedMap
- In SortedMap the sorting should be based on Key but not based on Value.
- **`NavigableMap<K, V>`**: sorted map with closest-match operations such as `lowerEntry()` and `ceilingEntry()`.
- It is the child interface of SortedMap it defines several methods for navigation purposes its implementation class is 
- TreeMap
- **`ConcurrentMap<K, V>`**: map with atomic concurrent operations such as `putIfAbsent()`.
- **`ConcurrentNavigableMap<K, V>`**: concurrent map with sorted-key navigation.

### Classes

- **`AbstractMap`**: skeletal base class that reduces work when creating a custom map.
- **`HashMap`**: usual general-purpose map; does not guarantee key iteration order and permits one `null` key.
- **`LinkedHashMap`**: preserves insertion order by default; access order can support LRU-style caches.
- **`TreeMap`**: keeps keys sorted by natural order or a `Comparator`.
- **`EnumMap`**: compact, efficient map when every key belongs to one enum type.
- **`WeakHashMap`**: removes an entry after its key is no longer strongly referenced; useful for metadata caches.
- **`IdentityHashMap`**: compares keys using `==`, not `equals()`; use only when identity comparison is required.
- **`ConcurrentHashMap`**: high-concurrency hash map; does not permit `null` keys or values.
- **`ConcurrentSkipListMap`**: concurrent, sorted `NavigableMap`; does not permit `null` keys or values.
- **`Dictionary`**: legacy abstract predecessor of `Map`.
- **`Hashtable`**: synchronized legacy map. Prefer `ConcurrentHashMap` in new concurrent code.
- **`Properties`**: legacy `Hashtable` subclass for configuration properties; use `getProperty()` and `setProperty()` for string properties.

## Map Collection Views

`Map` itself is not a `Collection`, but it exposes three backed collection views. Changes made through these views update the original map.

```mermaid
flowchart TD
  M["Map&lt;K, V&gt;"] --> K["keySet() → Set&lt;K&gt;\nunique keys"]
  M --> V["values() → Collection&lt;V&gt;\nvalues may repeat"]
  M --> E["entrySet() → Set&lt;Map.Entry&lt;K, V&gt;&gt;\nkey-value pairs"]
  K --> KR["remove(key) removes its entry"]
  V --> VR["remove(value) removes one matching entry"]
  E --> ER["entry.setValue(value) updates the map"]
```

> Adding directly to these views is unsupported because a map needs both a key and a value. Use `map.put(key, value)` to add an entry.

## Choosing a Map Implementation

```mermaid
flowchart TD
  A["Need a key-value map"] --> B{"Need sorted keys?"}
  B -- Yes --> C{"Need concurrent access?"}
  C -- Yes --> D["ConcurrentSkipListMap"]
  C -- No --> E["TreeMap"]
  B -- No --> F{"Need predictable order?"}
  F -- Yes --> G["LinkedHashMap"]
  F -- No --> H{"Are all keys enum constants?"}
  H -- Yes --> I["EnumMap"]
  H -- No --> J{"Need concurrent access?"}
  J -- Yes --> K["ConcurrentHashMap"]
  J -- No --> L["HashMap"]
```

---

## NavigableMap — complete execution flow (`navigableMap.java`)

`NavigableMap<K, V>` extends `SortedMap<K, V>` with **nearest-key navigation** on entries (`lowerEntry`, `floorEntry`, `ceilingEntry`, `higherEntry`), **descending views**, and **inclusive range** `subMap` / `headMap` / `tailMap` overloads. The usual implementation is **`TreeMap`** (red-black tree, $O(\log n)$ per operation).

[`navigableMap.java`](../../../demo/src/main/java/com/collections/map/navigableMap.java) extends [`mapDemo`](../../../demo/src/main/java/com/collections/map/mapDemo.java) and runs the NavigableMap demo from `main`.

### Source files

| File | Role |
| ---- | ---- |
| [navigableMap.java](../../../demo/src/main/java/com/collections/map/navigableMap.java) | `main`: `demonstrateMap("NavigableMap")` + map capacity summaries |
| [mapDemo.java](../../../demo/src/main/java/com/collections/map/mapDemo.java) | **`demonstrateNavigableMap()`** and other map demos |
| [treeMap.java](../../../demo/src/main/java/com/collections/map/treeMap.java) | Optional entry point for `TreeMap` only |
| [sortedMap.java](../../../demo/src/main/java/com/collections/map/sortedMap.java) | `SortedMap` demo (`demonstrateSortedMap`) — overlap with range views |

### End-to-end execution flow

```mermaid
flowchart TD
  A["main() in navigableMap"] --> B["demonstrateMap(\"NavigableMap\")"]
  B --> C["mapCollectionType → demonstrateNavigableMap()"]
  B --> D["mapConstructors → see note below"]
  A --> E["printDefaultCapacitySummary(HashMap, LinkedHashMap, TreeMap, Hashtable)"]
  C --> F["new TreeMap; put Ram, Shyam, Geeta"]
  F --> G["get, firstKey, lastKey, remove Geeta"]
  G --> H["ceilingEntry/lowerEntry, subMap, floorKey, floorEntry"]
  H --> I["pollFirstEntry, pollLastEntry, comparator, iterator"]
```

```mermaid
sequenceDiagram
  participant NM as navigableMap.main()
  participant MD as mapDemo
  participant TM as TreeMap
  participant CTI as CollectionTypeInspector

  NM->>MD: demonstrateMap("NavigableMap")
  MD->>MD: mapCollectionType → demonstrateNavigableMap()
  MD->>CTI: printTypeInfo(TreeMap, NavigableMap, SortedMap, Map)
  MD->>TM: put × 3; get; firstKey/lastKey; remove
  MD->>TM: navigation + poll methods
  MD->>MD: mapConstructors("NavigableMap")
  NM->>CTI: printDefaultCapacitySummary (4 map types)
```

Reference — full `demonstrateNavigableMap()` body ([`mapDemo.java`](../../../demo/src/main/java/com/collections/map/mapDemo.java)):

```java
private static void demonstrateNavigableMap() {
    System.out.println("===== NavigableMap (TreeMap) =====");
    CollectionTypeInspector.printTypeInfo(TreeMap.class, NavigableMap.class, SortedMap.class, Map.class);
    CollectionTypeInspector.printDefaultInitialCapacity("TreeMap");
    NavigableMap<String, Integer> map = new TreeMap<>();

    map.put("Ram", 25);
    map.put("Shyam", 30);
    map.put("Geeta", 28);
    System.out.println("After put() (stored in sorted key order): " + map);

    System.out.println("get(\"Shyam\"): " + map.get("Shyam"));
    System.out.println("firstKey(): " + map.firstKey());
    System.out.println("lastKey(): " + map.lastKey());

    map.remove("Geeta");
    System.out.println("After remove(\"Geeta\"): " + map);

    System.out.println("subMap(\"Ram\", \"Shyam\") [to exclusive]: "
            + map.ceilingEntry("Ram").getKey() + " to " + map.lowerEntry("Shyam").getKey());
    System.out.println("subMap(\"Ram\", true, \"Shyam\", true) [both inclusive]: "
            + map.subMap("Ram", true, "Shyam", true));
    System.out.println("headMap(\"Shyam\") [keys < Shyam]: " + map.floorKey("Shyam"));
    System.out.println("tailMap(\"Ram\") [keys >= Ram]: " + map.floorEntry("Ram").getKey());
    System.out.println("floorEntry(\"Ram\"): " + map.pollFirstEntry().getKey());
    System.out.println("ceilingEntry(\"Ram\"): " + map.pollLastEntry().getKey());
    System.out.println("comparator(): " + map.comparator());

    System.out.println("Iterator over entrySet() (sorted order):");
    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, Integer> entry = iterator.next();
        System.out.println("  " + entry.getKey() + " = " + entry.getValue());
    }
    // ... closing println ...
}
```

---

### `navigableMap.java` — launcher methods

```mermaid
flowchart TD
  M["main(args)"] --> D["demonstrateMap(\"NavigableMap\")"]
  M --> S["printDefaultCapacitySummary(4 map types)"]
  D --> T1["mapCollectionType → demonstrateNavigableMap()"]
  D --> T2["mapConstructors(\"NavigableMap\")"]
```

```mermaid
pie showData
    title Calls from navigableMap.main()
    "demonstrateMap (2 mapDemo phases)" : 2
    "printDefaultCapacitySummary (4 structures)" : 4
```

| Method in `navigableMap.java` | What it does |
| ----------------------------- | ------------ |
| **`demonstrateMap(String collectionType)`** | `mapCollectionType` + `mapConstructors`; calls `mapLoadFactor` only for HashMap / LinkedHashMap / Hashtable |
| **`main(String[] args)`** | `demonstrateMap("NavigableMap")` then inspector summaries for **HashMap, LinkedHashMap, TreeMap, Hashtable** |

---

### `demonstrateNavigableMap()` — every statement explained

```mermaid
pie showData
    title Statements in demonstrateNavigableMap() by purpose
    "Inspector (type + TreeMap capacity)" : 2
    "TreeMap + put × 3" : 4
    "SortedMap basics (get, first/last key, remove)" : 4
    "NavigableMap navigation & polls" : 7
    "comparator + iterator + banners" : 3
```

#### Execution order (numbered)

```mermaid
flowchart TD
  S1["① banner"] --> S2["② printTypeInfo"]
  S2 --> S3["③ printDefaultInitialCapacity(TreeMap)"]
  S3 --> S4["④ new TreeMap"]
  S4 --> S5["⑤–⑦ put Ram, Shyam, Geeta"]
  S5 --> S6["⑧ println map"]
  S6 --> S7["⑨ get / firstKey / lastKey"]
  S7 --> S8["⑩ remove Geeta"]
  S8 --> S9["⑪ ceilingEntry + lowerEntry (demo println)"]
  S9 --> S10["⑫ inclusive subMap"]
  S10 --> S11["⑬ floorKey"]
  S11 --> S12["⑭ floorEntry key"]
  S12 --> S13["⑮ pollFirstEntry"]
  S13 --> S14["⑯ pollLastEntry"]
  S14 --> S15["⑰ comparator + iterator"]
```

Sorted key order after three `put` calls: **`Geeta` → `Ram` → `Shyam`** (natural `String` order).

| Step | Code | Result / effect |
| ---- | ---- | ----------------- |
| ① | Section `println` | Header: `===== NavigableMap (TreeMap) =====` |
| ② | `printTypeInfo(TreeMap, NavigableMap, SortedMap, Map)` | `TreeMap` = CLASS; others = INTERFACE |
| ③ | `printDefaultInitialCapacity("TreeMap")` | No fixed buckets — **one tree node per entry** |
| ④ | `new TreeMap<>()` | Empty `NavigableMap` implementation |
| ⑤–⑦ | `put("Ram",25)`, `put("Shyam",30)`, `put("Geeta",28)` | `{Geeta=28, Ram=25, Shyam=30}` |
| ⑧ | `println(map)` | Same map string (sorted key order) |
| ⑨ | `get("Shyam")` | `30` |
| ⑨ | `firstKey()` / `lastKey()` | `Geeta` / `Shyam` (`SortedMap`) |
| ⑩ | `remove("Geeta")` | `{Ram=25, Shyam=30}` |
| ⑪ | `ceilingEntry("Ram")` + `lowerEntry("Shyam")` | Prints **`Ram to Ram`** (labels say `subMap` but code uses **entry** navigation APIs) |
| ⑫ | `subMap("Ram", true, "Shyam", true)` | `{Ram=25, Shyam=30}` — **both endpoints inclusive** |
| ⑬ | `floorKey("Shyam")` | `Shyam` (key exists → floor is the key itself) |
| ⑭ | `floorEntry("Ram").getKey()` | `Ram` |
| ⑮ | `pollFirstEntry()` | **Removes** smallest entry; prints key **`Ram`**; map → `{Shyam=30}` |
| ⑯ | `pollLastEntry()` | **Removes** largest entry; prints key **`Shyam`**; map → `{}` |
| ⑰ | `comparator()` | `null` (natural ordering) |
| ⑰ | `entrySet` iterator | **No lines** — map is empty after polls |

```mermaid
flowchart LR
  subgraph keys ["Keys after remove(Geeta)"]
    direction LR
    R["Ram"] --- S["Shyam"]
  end
```

#### NavigableMap entry methods used in the demo

| Method | Argument | Demo output | Meaning |
| ------ | -------- | ----------- | ------- |
| **`ceilingEntry(key)`** | `"Ram"` | entry for `Ram` | Smallest key **≥ `Ram`** |
| **`lowerEntry(key)`** | `"Shyam"` | entry for `Ram` | Greatest key **strictly less than** `Shyam` |
| **`floorKey(key)`** | `"Shyam"` | `Shyam` | Greatest key **≤ `Shyam`** |
| **`floorEntry(key)`** | `"Ram"` | key `Ram` | Greatest key **≤ `Ram`** (entry view) |
| **`pollFirstEntry()`** | — | removes & returns `Ram` | **`SortedMap`/`NavigableMap` poll** — mutates map |
| **`pollLastEntry()`** | — | removes & returns `Shyam` | Removes highest entry |

```mermaid
pie showData
    title NavigableMap-specific calls in demonstrateNavigableMap()
    "ceilingEntry" : 1
    "lowerEntry" : 1
    "floorKey" : 1
    "floorEntry" : 1
    "pollFirstEntry" : 1
    "pollLastEntry" : 1
    "subMap inclusive overload" : 1
```

> **Console labels vs methods:** two `println` lines use the text `floorEntry` / `ceilingEntry` but the code calls **`pollFirstEntry()`** and **`pollLastEntry()`**, which **remove** entries. That is why the final iterator prints nothing.

#### Parallel: key-only vs entry APIs

```mermaid
flowchart TB
  subgraph keyOnly ["Key methods (examples)"]
    FK["floorKey / ceilingKey / lowerKey / higherKey"]
  end
  subgraph entry ["Entry methods (demo uses these)"]
    FE["floorEntry / ceilingEntry / lowerEntry / higherEntry"]
    PE["pollFirstEntry / pollLastEntry"]
  end
  Nav["NavigableMap"] --> keyOnly
  Nav --> entry
```

Related APIs **not** called in this demo: `descendingMap()`, `navigableKeySet()`, `higherEntry`, `ceilingKey`, etc. They appear in the **TreeMap** public-method list from `printDefaultCapacitySummary`.

---

### `mapConstructors("NavigableMap")` behavior

`mapConstructors` in [`mapDemo.java`](../../../demo/src/main/java/com/collections/map/mapDemo.java) has **no `case "NavigableMap"`** (or `"SortedMap"`), so the switch **falls through to `default`** and runs **`demonstrateHashMapConstructors()`**.

```mermaid
flowchart TD
  MC["mapConstructors(\"NavigableMap\")"] --> SW{"switch collectionType"}
  SW --> DEF["default → demonstrateHashMapConstructors()"]
```

That is why the log after the NavigableMap block shows **`HashMap(): {}`** and related lines — not `TreeMap()` constructors. For TreeMap constructors, run [`treeMap.java`](../../../demo/src/main/java/com/collections/map/treeMap.java) or extend the switch with `NavigableMap` → `demonstrateTreeMapConstructors()`.

---

### `printDefaultCapacitySummary` from `navigableMap.main`

```java
CollectionTypeInspector.printDefaultCapacitySummary("HashMap", "LinkedHashMap", "TreeMap", "Hashtable");
```

```mermaid
pie showData
    title Inspector summaries after NavigableMap demo
    "HashMap" : 1
    "LinkedHashMap" : 1
    "TreeMap" : 1
    "Hashtable" : 1
```

Each block prints **type**, **capacity / load factor** (where applicable), **public methods**, and a **one-line summary**. The **TreeMap** list includes full **`NavigableMap`** surface: `ceilingEntry`, `descendingMap`, `pollFirstEntry`, `subMap`, `tailMap`, …

To print **`NavigableMap`** as the interface summary, pass `"NavigableMap"` (supported in [`CollectionTypeInspector`](../../../demo/src/main/java/com/collections/collectionBaseClasses/CollectionTypeInspector.java)).

---

### What `NavigableMap` adds beyond `SortedMap`

| Layer | Responsibility |
| ----- | ---------------- |
| **`Map`** | `put` / `get` / `remove`; entry, key, and value views |
| **`SortedMap`** | `firstKey` / `lastKey`; classic `subMap` / `headMap` / `tailMap` |
| **`NavigableMap`** | `*Entry` and `*Key` nearest-match pairs; `descendingMap`; inclusive range overloads; `pollFirstEntry` / `pollLastEntry` |
| **`TreeMap`** | Standard implementation used in the demo |

```mermaid
mindmap
  root((NavigableMap API))
    Used in demonstrateNavigableMap
      put get remove
      firstKey lastKey
      ceilingEntry lowerEntry
      floorKey floorEntry
      subMap inclusive
      pollFirstEntry pollLastEntry
    On interface not in demo
      descendingMap
      higherEntry ceilingKey
      navigableKeySet
```

---

### Verified NavigableMap output

```text
===== NavigableMap (TreeMap) =====
----- Type Classification -----
  TreeMap              -> CLASS
  NavigableMap         -> INTERFACE
  SortedMap            -> INTERFACE
  Map                  -> INTERFACE
--------------------------------
After put() (stored in sorted key order): {Geeta=28, Ram=25, Shyam=30}
get("Shyam"): 30
firstKey(): Geeta
lastKey(): Shyam
After remove("Geeta"): {Ram=25, Shyam=30}
subMap("Ram", "Shyam") [to exclusive]: Ram to Ram
subMap("Ram", true, "Shyam", true) [both inclusive]: {Ram=25, Shyam=30}
headMap("Shyam") [keys < Shyam]: Shyam
tailMap("Ram") [keys >= Ram]: Ram
floorEntry("Ram"): Ram
ceilingEntry("Ram"): Shyam
comparator(): null
Iterator over entrySet() (sorted order):
```

*(Iterator body empty — map empty after `pollFirstEntry` / `pollLastEntry`.)*

### Run the NavigableMap demo

```bash
cd demo
mvn -q exec:java -Dexec.mainClass=com.collections.map.navigableMap
```

Main class: `com.collections.map.navigableMap`.

> **Also see:** [`demonstrateSortedMap()`](../../../demo/src/main/java/com/collections/map/mapDemo.java) for `SortedMap` range views without poll/entry navigation; [`Hashtable` execution flow](hashTable.md) for bucket-based maps.

---


