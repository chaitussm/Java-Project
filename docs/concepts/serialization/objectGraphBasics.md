# Object Graph Basics in Java Serialization

> A visual study guide to serializing connected Java objects and restoring their reachable state.

> **Preview tip:** Use **Markdown Preview** (`Ctrl+Shift+V`) to view the graph illustrations and follow the read-order examples.

<!-- TOC -->
- [Object Graph Basics in Java Serialization](#object-graph-basics-in-java-serialization)
  - [Important Rule: Order Matters](#important-rule-order-matters)
  - [Example Program](#example-program)
  - [How the File Is Read](#how-the-file-is-read)
  - [What Happens If the Order Is Wrong?](#what-happens-if-the-order-is-wrong)
  - [Requirements](#requirements)
  - [Current Object Graph: `dog -> cat -> rat`](#current-object-graph-dog---cat---rat)
<!-- /TOC -->

An object graph is the group of objects that a program writes to a serialized file. Java can write multiple objects into the same file, one after another.

---

## Important Rule: Order Matters

Objects must be deserialized in exactly the same order in which they were serialized.

```text
Serialization order:    Dog -> Cat
Deserialization order:  Dog -> Cat
```text

If the program writes a `Dog` first and a `Cat` second, the first `readObject()` must be cast to `Dog`, and the second `readObject()` must be cast to `Cat`.

## Example Program

The complete commented Java program is kept in the source file below:

```text
demo/src/main/java/com/advanced/serialization/objectGraphs/objectGraphBasics.java
```text

Open that file to study the code line by line. It creates a `dog` object containing a `cat`, which contains a `rat`, then writes and restores the complete connected graph.

## How the File Is Read

```mermaid
flowchart TD
  A["objectGraph.ser"] --> B["readObject() -> dog d1"]
  B --> C["d1.c -> cat c"]
  C --> D["c.r -> rat r"]
  D --> E["r.j = 20"]
```text

## What Happens If the Order Is Wrong?

Suppose the file contains:

```text
Dog -> Cat
```text

but the program tries to read:

```java
Cat c2 = (Cat) ois.readObject();
```

The first object is still a `Dog`, so the cast is invalid and Java can throw a `ClassCastException`.

The read order must match the write order:

| Write order | Read order | Restored type |
| ----------- | ---------- | ------------- |
| `writeObject(dog)` | `readObject()` | `Dog` |
| `writeObject(cat)` | `readObject()` | `Cat` |

## Requirements

- `Dog` and `Cat` must implement `Serializable`.
- Every object reachable through a serialized object graph must also be serializable unless it is marked `transient`.
- The objects should be read in the same order in which they were written.
- The output stream should be closed after writing.
- The input stream should be closed after reading.

The program handles `IOException` for file and stream problems, and `ClassNotFoundException` when a serialized class cannot be found during reading.

## Current Object Graph: `dog -> cat -> rat`

The current Java program has one root object, `dog`. Its `c` field refers to a `cat`, and the cat's `r` field refers to a `rat`:

```mermaid
flowchart TD
  D["dog d"] --> C["cat c"]
  C --> R["rat r"]
  R --> J["int j = 20"]
```text

When the program executes `oos.writeObject(d)`, Java follows these reachable references and serializes the complete graph. The `dog`, `cat`, and `rat` classes must all implement `Serializable`; otherwise Java throws `NotSerializableException`.

During reading, `ois` is created from the same file and `ois.readObject()` restores the root `dog`. The nested objects are then available through `d1.c.r`, so `d1.c.r.j` returns `20`.

The complete implementation is available at:

```text
demo/src/main/java/com/advanced/serialization/objectGraphs/objectGraphBasics.java
```
