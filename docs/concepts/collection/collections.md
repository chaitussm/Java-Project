# Java Collections Guide

> A practical study guide to Java collection interfaces, implementations, constructors, methods, cursors, capacities, and selection rules.

> **Tip:** Open this file in **Markdown Preview** (`Ctrl+Shift+V`) to view formatted tables, diagrams, and clickable links.

---

## Introduction 

<!-- TOC -->
- [Java Collections Guide](#java-collections-guide)
  - [Introduction](#introduction)
  - [Collections](#collections)
  - [Collection Definition](#collection-definition)
  - [Collection Framework](#collection-framework)
  - [9 key interfaces](#9-key-interfaces-of-collection-framework)
  - [Collection vs Collections](#collection-vs-collections)
  - [RandomAccess Interface](#randomaccess-interface)
  - [Package guides](#package-guides-by-demo-folder)
<!-- /TOC -->

> **Quick navigation:** for a focused, side-by-side comparison reference, open [Differences in Java Collections](differences-in-collections.md).

An array is an indexed collection of a fixed number of homogeneous data elements.

The main advantage of arrays is that we can represent multiple values by using a single variable, so the readability of the code will be improved.

### Limitations of arrays

1. Arrays are fixed in size. Once we create an array, there is no chance of increasing or decreasing the size based on our requirement. Because of this, to use the array concept we must know the size in advance, which may not always be possible.
2. An array can hold only homogeneous data-type elements.

   ```java
   Student[] s = new Student[10000];
   s[0] = new Student(); // valid
   s[1] = new Customer(); // incompatible types | found: Customer | required: Student
   ```

   We can solve this problem by using object-type arrays:

   ```java
   Object[] a = new Object[10000];
   a[0] = new Student(); // valid
   a[1] = new Customer(); // valid
   ```

3. The array concept is not implemented based on a standard data structure, so ready-made method support is not available. For every requirement we have to write the code explicitly, which increases the complexity of programming.

---

## Collections

1. Collections are growable in nature; based on our requirement we can increase or decrease the size.
2. Collections can hold both homogeneous and heterogeneous elements.
3. Every collection class is implemented based on some standard data structure, so ready-made method support is available for every requirement.
4. As programmers, we are responsible for using those methods; we are not responsible for implementing them.
5. Usually we can use collections to hold and transfer objects from one location to another location (container). To support this requirement, every collection class by default implements `Serializable` and `Cloneable` interfaces.
6. `ArrayList` and `Vector` classes implement the `RandomAccess` interface so that any random element can be accessed with the same speed.

## Collection Definition

If we want to represent a group of individual objects as a single entity, then we should go for a collection.

## Collection Framework

It contains several classes and interfaces that can be used to represent a group of individual objects as a single entity.

## 9 key interfaces of Collection Framework 

1. `Collection` (I)
   - If we want to represent a group of individual objects as a single entity then we should go for collection.
   - It defines the most coomon methods which are applicable for any coolection object.
   - In general collection Interface is considered as root interface of collection Framework.
   - There is no concvrete class which implements collection interace directly.
2. `List`
3. `Set`
4. `SortedSet`
5. `NavigableSet`
6. `Queue`
7. `Map`
8. `SortedMap`
9. `NavigableMap`

## Collection vs Collections

`Collection` is an interface. If we want to represent a group of individual objects as a single entity, then we should go for a collection.

`Collections` is a utility class present in the `java.util` package used to define several utility methods for collection objects (like sorting, searching, and so on).

## RandomAccess Interface

`RandomAccess` is present in the `java.util` package. It does not contain any methods; it is a marker interface where the required ability is provided automatically by the JVM.

---
## Package guides (by demo folder)

Detailed sections were **moved** from this file into the guides below (not rewritten). Each guide matches a `com.collections.*` package and includes at least one **flagship launcher** with execution flow, diagrams, and pie charts where already documented.

| # | Folder / topic | Guide | Flagship program |
| - | -------------- | ----- | ---------------- |
| 1 | `collectionBaseClasses` | [collectionBaseClasses.md](collectionBaseClasses.md) | `CollectionTypeInspector`, `listDemo` / `setDemo` / `queueDemo` / `mapDemo` |
| 2 | `hashTable` | [hashTable.md](hashTable.md) | [`hashTableDemo.java`](../../../demo/src/main/java/com/collections/hashTable/basicflow/hashTableDemo.java) |
| 3 | `list` | [list.md](list.md) | [`arrayList.java`](../../../demo/src/main/java/com/collections/list/arrayList.java) |
| 4 | `map` | [map.md](map.md) | [`navigableMap.java`](../../../demo/src/main/java/com/collections/map/navigableMap.java) (+ `linkedHashMap`, `hashMap`, …) |
| 5 | `properties` | [properties.md](properties.md) | [`propertiesDemo.java`](../../../demo/src/main/java/com/collections/properties/propertiesDemo.java) |
| 6 | `queue` | [queue.md](queue.md) | [`arrayDeque.java`](../../../demo/src/main/java/com/collections/queue/arrayDeque.java) |
| 7 | `set` | [set.md](set.md) | [`navigableSet.java`](../../../demo/src/main/java/com/collections/set/navigableSet.java) |

### Related collections docs

- [Differences in Java Collections](differences-in-collections.md) — comparison tables
- [Cursors](cursors.md) — Iterator / ListIterator / Enumeration
- [HashSet vs LinkedHashSet](hashset-vs-linkedhashset.md) — quick comparison (also summarized in [set.md](set.md))

### Constructors

Per-type constructor snippets and `*Constructors(String)` dispatch live in each package guide and in [collectionBaseClasses.md](collectionBaseClasses.md).

