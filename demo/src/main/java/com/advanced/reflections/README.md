# Java Reflection Basics

<!-- TOC -->
- [Java Reflection Basics](#java-reflection-basics)
	- [Learning order](#learning-order)
	- [Important terms](#important-terms)
<!-- /TOC -->

This package teaches Java Reflection from the beginning. Reflection lets a running program inspect classes, fields, constructors, methods, modifiers, and arrays at runtime.

## Learning order

1. `classBasics/ClassInspectionBasics.java` - obtain `Class<?>` metadata and load a class by name.
2. `constructors/ConstructorReflectionBasics.java` - discover and invoke constructors.
3. `fields/FieldReflectionBasics.java` - read and update fields, including private fields.
4. `methods/MethodReflectionBasics.java` - discover and invoke methods.
5. `modifiers/ModifierReflectionBasics.java` - identify public, private, static, final, and other modifiers.
6. `arrays/ArrayReflectionBasics.java` - inspect and manipulate arrays without knowing their type at compile time.
7. `complete/CompleteReflectionExample.java` - combine the main reflection operations in one example.

Run from the `demo` directory with Maven compilation, or run an individual class from the compiled output using its fully qualified name.

## Important terms

- `Class<?>` represents a class at runtime.
- `getDeclared...()` includes members declared in that class, including private members.
- `get...()` generally returns public members, including inherited members.
- `setAccessible(true)` requests reflective access to a non-public member.
- `get()` reads a field, `set()` changes a field, and `invoke()` calls a method.
- Reflection can fail at runtime, so checked exceptions must be handled.
