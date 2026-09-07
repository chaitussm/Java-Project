# Java Reflection Basics

<!-- TOC -->
- [Java Reflection Basics](#java-reflection-basics)
  - [Learning order](#learning-order)
  - [Important terms](#important-terms)
  - [Full guide](#full-guide)
<!-- /TOC -->

This package teaches Java Reflection from the beginning. Reflection lets a running program inspect classes, fields, constructors, methods, modifiers, and arrays at runtime.

## Learning order

| Step | Program | What it demonstrates |
| ---- | ------- | -------------------- |
| 1 | `classBasics/ClassInspectionBasics.java` | Obtain `Class<?>` metadata and load a class by name |
| 2 | `constructors/ConstructorReflectionBasics.java` | Discover and invoke constructors |
| 3 | `fields/FieldReflectionBasics.java` | Read and update fields, including private fields |
| 4 | `methods/MethodReflectionBasics.java` | Discover and invoke methods |
| 5 | `modifiers/ModifierReflectionBasics.java` | Identify public, private, static, final, and other modifiers |
| 6 | `arrays/ArrayReflectionBasics.java` | Inspect and manipulate arrays without knowing their type at compile time |
| 7 | `complete/CompleteReflectionExample.java` | Combine the main reflection operations in one example |

Run from the `demo` directory with Maven compilation, or run an individual class from the compiled output using its fully qualified name.

## Important terms

| Term | Meaning |
| ---- | ------- |
| `Class<?>` | Represents a class at runtime |
| `getDeclared...()` | Includes members declared in that class, including private members |
| `get...()` | Generally returns public members, including inherited members |
| `setAccessible(true)` | Requests reflective access to a non-public member |
| `get()` | Reads a field |
| `set()` | Changes a field |
| `invoke()` | Calls a method |

Reflection can fail at runtime, so checked exceptions must be handled.

## Full guide

For the complete documentation with diagrams and examples, see [Java-Reflection-Basics-Guide.md](../../../../docs/concepts/reflections/Java-Reflection-Basics-Guide.md).
