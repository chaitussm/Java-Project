# Table of Contents

- [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Why use assertions?](#why-use-assertions)
  - [The `assert` keyword](#the-assert-keyword)
    - [Using `assert` as an identifier in older Java](#using-assert-as-an-identifier-in-older-java)
  - [Types of assert statements](#types-of-assert-statements)
    - [Simple assert statement](#simple-assert-statement)
    - [Augmented assert statement](#augmented-assert-statement)
  - [Enabling assertions in these examples](#enabling-assertions-in-these-examples)
  - [Simple assert example: execution summary](#simple-assert-example-execution-summary)
    - [Simple assert execution flow](#simple-assert-execution-flow)
    - [Simple assert console output](#simple-assert-console-output)
  - [Augmented assert example: execution summary](#augmented-assert-example-execution-summary)
    - [Augmented assert execution flow](#augmented-assert-execution-flow)
    - [Augmented assert console output](#augmented-assert-console-output)
  - [Comparison](#comparison)
  - [When to use assertions](#when-to-use-assertions)
- [various possible runtime flags](#various-possible-runtime-flags)

## Introduction

Assertions let a program check assumptions made by its code. They are useful during development and testing for detecting conditions that should never occur if the program is working correctly.

An assertion is not a replacement for validating input from users or external systems. Assertions are disabled by default unless enabled for the relevant class loader.

## Why use assertions?

Print statements such as `System.out.println` can help with temporary debugging, but they run whenever that code is reached and must often be removed or managed later. Assertions provide checks that can be enabled during development and testing and disabled when they are not needed.

The main purpose of assertions is to validate assumptions made by the code while debugging. After fixing a bug, developers do not have to remove assertion statements: they can remain in the code and be enabled or disabled for a run. Assertions are disabled by default.

When an enabled assertion condition is false, Java throws an `AssertionError`. This makes a failed assumption visible instead of allowing execution to continue as though the assumption were true. Assertions are mainly useful in development and test environments, not as a substitute for production input validation or error handling.

## The `assert` keyword

`assert` became a Java keyword in Java 1.4. From Java 1.4 onward, it cannot be used as an identifier, such as a variable name.

### Using `assert` as an identifier in older Java

This example does not compile with modern Java because `assert` is a keyword:

```java
class Test {
    public static void main(String[] args) {
        int assert = 10;
        System.out.println(assert);
    }
}
```

In the early Java versions when `assert` was not yet a keyword, a source-compatible compiler could accept it as an identifier. Historically, the compiler's `-source` option selected the Java language version used to interpret source code; old examples used commands such as:

```text
javac -source 1.2 Test.java
javac -source 1.3 Test.java
```

These are historical examples, not commands for current JDKs: modern `javac` no longer supports Java 1.2 or 1.3 source levels. Code that uses `assert` as an identifier should be renamed when moving to Java 1.4 or later.

## Types of assert statements

Java has two forms of the assert statement: simple and augmented (also called assert-with-message).

### Simple assert statement

```java
assert condition;
```

The condition must be a boolean expression:

1. If assertions are enabled and the condition is `true`, the assumption is satisfied and the rest of the program continues normally.
2. If assertions are enabled and the condition is `false`, the assumption has failed. Java throws an `AssertionError` without a detail message, and normal execution stops unless the error is caught.
3. After investigating the failure, fix the underlying problem. The assertion can remain in the code for future debugging.
4. If assertions are disabled, the assertion statement has no effect.

### Augmented assert statement

```java
assert condition : detailExpression;
```

The condition must be a boolean expression. The detail expression can be any expression that produces a value; a `String` is commonly used to explain the failure:

1. If assertions are enabled and the condition is `true`, the assumption is satisfied and execution continues.
2. If assertions are enabled and the condition is `false`, Java throws an `AssertionError` with the detail expression's value as its error detail. The detail expression is evaluated only on this failure path.
3. The detail can provide useful context for diagnosing the failed assumption.
4. If assertions are disabled, the assertion statement has no effect.

## Enabling assertions in these examples

Both example programs enable assertions in code before calling `AssertionChecker`:

```java
ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
```

Assertion status must be set before the checker class is initialized. This lets the examples run without an assertion-enabling command-line option.

## Simple assert example: execution summary

The [simple assertion example](../../../demo/src/main/java/com/assertions/simpleAssert/assertionBasics.java) enables assertions, checks age `25`, and then checks age `15` inside a `try` block. Its [checker](../../../demo/src/main/java/com/assertions/simpleAssert/AssertionChecker.java) uses `assert age >= 18;` with no detail message.

The first call passes and prints the access-granted message. The second call fails its assertion, so Java throws an `AssertionError` before that print statement. The `catch` block handles the error, prints a short explanation, and allows the program to finish.

### Simple assert execution flow

```mermaid
flowchart TD
    A["Start main"] --> B["Enable assertions on system class loader"]
    B --> C["Call checkAge(25)"]
    C --> D{"age >= 18?"}
    D -- Yes --> E["Print Access granted for age: 25"]
    E --> F["Call checkAge(15) inside try"]
    F --> G{"age >= 18?"}
    G -- Yes --> H["Print Access granted"]
    G -- No --> I["Throw AssertionError with no detail message"]
    I --> J["catch block prints expected-error notice"]
    H --> K["Print program-finished message"]
    J --> K
    K --> L["End"]
```

### Simple assert console output

```text
--- Starting Assertion Test ---
Access granted for age: 25
Caught expected AssertionError for age below 18.

--- Program finished execution safely ---
```

## Augmented assert example: execution summary

The [augmented assertion example](../../../demo/src/main/java/com/assertions/augumentedAssert/assertionBasics.java) enables assertions, checks age `25`, and then checks age `15` inside a `try` block. Its [checker](../../../demo/src/main/java/com/assertions/augumentedAssert/AssertionChecker.java) uses `assert age >= 18 : ...;` to include a detail message.

The first call passes and prints the access-granted message. On the second call, the condition is false, so Java throws an `AssertionError` containing the message and the supplied age (`15`). The `catch` block prints that message, then the program finishes.

### Augmented assert execution flow

```mermaid
flowchart TD
    A["Start main"] --> B["Enable assertions on system class loader"]
    B --> C["Call checkAge(25)"]
    C --> D{"age >= 18?"}
    D -- Yes --> E["Print Access granted for age: 25"]
    E --> F["Call checkAge(15) inside try"]
    F --> G{"age >= 18?"}
    G -- Yes --> H["Print Access granted"]
    G -- No --> I["Evaluate detail message with age 15"]
    I --> J["Throw AssertionError with detail message"]
    J --> K["catch block prints the error message"]
    H --> L["End"]
    K --> L
```

### Augmented assert console output

```text
Access granted for age: 25
Caught expected assertion: Access denied: age must be 18 or older. Provided: 15
```

## Comparison

| Form      | Example                             | Error detail when the condition fails   |
| --------- | ----------------------------------- | --------------------------------------- |
| Simple    | `assert age >= 18;`                 | No detail message is supplied           |
| Augmented | `assert age >= 18 : "Age: " + age;` | Includes the supplied detail expression |

## When to use assertions

Use assertions for internal assumptions and conditions that indicate a programming defect if they are false. Do not rely on them to reject invalid external input, because assertions may be disabled in another runtime environment.

>assert(b):e;

1. e will be executed if and only if first argument is false i.e if the first argument is true then secodn argument won't be evaluated 
class Test{

  public static void main(String[] args)
  {
     int x = 10;

     assert(x ==10); ++x;

     System.out.println(x);
  }
}

>assert(b):e;

2. For the second argument we can take method call but void return type method call is not allowed otherwise we will get compile time error 

class Test{

  public static void main(String[] args)
  {
     int x = 10;

     assert(x ==10); m1();

     System.out.println(x);
  }

  public static int m1()
  {
    return 777;
  }
}

after enabling the assert we will get the ouput as 

RuntimeException: AssertionError:777

If we use return type as void then we will compile time error 
'void' type not allowed here 

NOTE : among 2 versions of assertions it is recommended to use augumented version because it provides more information for debugging 

# various possible runtime flags

1. -ea | -enableassertions
   To enable assertions in every non-system class(our own classes)
2. -da | -disableassertions
   To disable assertions in every non-system class 
3. -esa | -enablesystemassertions
   To enable assertions in every system class(pre-defined classes)
4. -dsa | --disablesystemassertions 
   To disable assertions in every system class(pre-defined classes)

NOTE: 

We can use above flags simultaneously then jvm will consider thse flags from left to right 

Ex: Java -ea -esa -ea -dsa -da -esa -ea -dsa Test 

### Internal execution — whiteboard trace (`Test`)

![Assertion runtime flags — left-to-right JVM trace (whiteboard)](images/assertion-flags-execution-whiteboard.png)

The example command on the board:

```text
java -ea -esa -ea -dsa -da -esa -ea -dsa Test
```

(`Java` on the slide means the **`java`** launcher; class name **`Test`** is your **non-system** application class.)

#### Two independent switches

The JVM keeps **two** assertion settings. They do **not** share one on/off bit:

| Track | Flags | Affects |
| ----- | ----- | ------- |
| **Non-system** | `-ea` / `-da` (enable / disable assertions) | **Your** classes (`Test`, project code) |
| **System** | `-esa` / `-dsa` (enable / disable **system** assertions) | **JDK** classes (`java.*`, `javax.*`, …) |

Each new flag of a given kind **overwrites** that track for the rest of the parse. The NOTE above applies: when many flags appear on one command line, the JVM applies them **from left to right**.

#### Whiteboard table (pair-by-pair reading)

The slide groups flags **two at a time** to show how each pair updates the two columns **Non-System** and **System** (✓ = enabled, ✗ = disabled):

| Step | Flags read (pair) | Non-System after pair | System after pair |
| ---- | ----------------- | --------------------- | ----------------- |
| 1 | `-ea` `-esa` | ✓ Enabled | ✓ Enabled |
| 2 | `-ea` `-dsa` | ✓ Enabled | ✗ Disabled |
| 3 | `-da` `-esa` | ✗ Disabled | ✓ Enabled |
| 4 | `-ea` `-dsa` | ✓ Enabled | ✗ Disabled |

After **step 4** (end of the full flag list):

| Track | Final state for this command |
| ----- | ---------------------------- |
| **Non-system** | **Enabled** (✓) |
| **System** | **Disabled** (✗) |

So for **`Test`**: assertions in **`Test`** are **on** at runtime (non-system enabled). Assertions inside **system** classes stay **off** (system disabled).

#### Full left-to-right scan (same command, flag by flag)

| Order | Flag | Non-system after | System after |
| ----- | ---- | ---------------- | ------------ |
| start | — | off (default) | off (default) |
| 1 | `-ea` | **on** | off |
| 2 | `-esa` | on | **on** |
| 3 | `-ea` | **on** | on |
| 4 | `-dsa` | on | **off** |
| 5 | `-da` | **off** | off |
| 6 | `-esa` | off | **on** |
| 7 | `-ea` | **on** | on |
| 8 | `-dsa` | on | **off** |

Same **final** result: **non-system enabled**, **system disabled**.

#### Point-by-point (internal execution)

1. **Parse phase** — Before `Test.main` runs, the launcher passes assertion switches to the JVM. No `assert` bytecode runs yet.
2. **Two tracks** — `-ea`/`-da` only flip **non-system**; `-esa`/`-dsa` only flip **system**.
3. **Last flag wins per track** — Later flags on the same track override earlier ones on that same command line.
4. **Class loaders** — **Non-system** assertion setting applies when loading **application** classes (`Test`). **System** setting applies when loading **platform** classes.
5. **`assert` bytecode** — If assertions are **disabled** for that class’s loader, `assert` is a no-op. If **enabled**, a false condition throws `AssertionError`.
6. **`Test` on the board** — With final non-system **enabled**, `assert` in `Test` is active. System **disabled** means JDK `assert` usage is not evaluated.
7. **Pairs on the slide** — Steps 1–4 are a teaching trace; the **full** eight-flag scan above matches the **same** final state.

```mermaid
flowchart TD
  CMD["java -ea -esa ... -dsa Test"] --> PARSE["Parse flags left to right"]
  PARSE --> NS["Non-system track: -ea / -da"]
  PARSE --> SYS["System track: -esa / -dsa"]
  NS --> FNS["Final: non-system ENABLED"]
  SYS --> FSYS["Final: system DISABLED"]
  FNS --> LOAD["Load Test (non-system)"]
  LOAD --> RUN["main runs — assert active in Test"]
  FSYS --> JDK["System classes — assert inactive"]
```

```mermaid
sequenceDiagram
  participant CLI as java launcher
  participant JVM as JVM
  participant Test as Test (non-system)
  CLI->>JVM: apply -ea -esa -ea -dsa -da -esa -ea -dsa
  Note over JVM: non-system=ON, system=OFF
  JVM->>Test: load with assertions enabled
  Test->>Test: execute assert statements if present
  Note over JVM: system classes keep assertions off
```

```mermaid
flowchart LR
  subgraph step1 ["Pair 1: -ea -esa"]
    A1["Non ✓"] 
    A2["Sys ✓"]
  end
  subgraph step2 ["Pair 2: -ea -dsa"]
    B1["Non ✓"]
    B2["Sys ✗"]
  end
  subgraph step3 ["Pair 3: -da -esa"]
    C1["Non ✗"]
    C2["Sys ✓"]
  end
  subgraph step4 ["Pair 4: -ea -dsa"]
    D1["Non ✓"]
    D2["Sys ✗"]
  end
  step1 --> step2 --> step3 --> step4
```

```mermaid
pie showData
    title Final assertion state for this command (two tracks)
    "Non-system ENABLED (Test asserts on)" : 50
    "System DISABLED (JDK asserts off)" : 50
```

```mermaid
pie showData
    title Eight flags on command line by category
    "Non-system flags (-ea / -da)" : 50
    "System flags (-esa / -dsa)" : 50
```

### Scoped execution — class and package selectors (`-ea:` / `-da:`)

![Scoped assertion flags — pack1 / pack2 whiteboard](images/assertion-scoped-flags-whiteboard.png)

The board uses this **classpath layout** (non-system classes):

```text
pack1
 ├── A.class
 ├── B.class
 └── pack2
      ├── C.class
      └── D.class
```

| Class | Fully qualified name |
| ----- | -------------------- |
| `A` | `pack1.A` |
| `B` | `pack1.B` |
| `C` | `pack1.pack2.C` |
| `D` | `pack1.pack2.D` |

**Syntax (after the colon):**

| Form | Meaning |
| ---- | ------- |
| `-ea:pack1.B` | **One class** — enable assertions only in `pack1.B` |
| `-da:pack1.B` | **One class** — disable assertions in `pack1.B` |
| `-ea:pack1...` | **Package subtree** — `pack1` and **all sub-packages** (`pack2`, …) |
| `-da:pack1.pack2...` | **Exclude subtree** — disable for `pack2` and everything under it |

(`...` is the **package** wildcard on the slide — not “current directory”.)

#### Five scenarios from the whiteboard (commands + execution)

| # | Goal (slide) | Command | Internal result after JVM parses flags (left → right) |
| - | ------------ | ------- | ----------------------------------------------------- |
| 1 | Enable assertions **only** in `B` | `java -ea:pack1.B …` | **On:** `pack1.B` only. **Off:** `A`, `C`, `D` (and any class not matching). |
| 2 | Enable in **`B`** and **`D`** | `java -ea:pack1.B -ea:pack1.pack2.D …` | **On:** `pack1.B`, `pack1.pack2.D`. **Off:** `A`, `C`. |
| 3 | Enable in **every** class of `pack1` (including `pack2`) | `java -ea:pack1... …` | **On:** `A`, `B`, `C`, `D`. |
| 4 | Enable all of `pack1` **except** `B` | `java -ea:pack1... -da:pack1.B …` | **On:** `A`, `C`, `D`. **Off:** `B` (disable rule applied after package enable). |
| 5 | Enable all of `pack1` **except** `pack2` classes | `java -ea:pack1... -da:pack1.pack2... …` | **On:** `A`, `B`. **Off:** `C`, `D` (entire `pack2` subtree disabled). |

**How the JVM applies this (execution model):**

1. **Default** — With no global `-ea`, assertions in non-system classes start **disabled**.
2. **Scoped enable** — `-ea:…` turns assertions **on** for matching classes when they are loaded.
3. **Scoped disable** — `-da:…` turns assertions **off** for matching classes (can **override** an earlier `-ea:pack1...` for a narrower name).
4. **Order** — Same rule as the NOTE above: flags are processed **left to right**; a later matching `-da:` can remove assertion checking from a class that was included by an earlier `-ea:pack1...`.
5. **Per class at load time** — When `pack1.A` loads, the JVM checks whether the **current policy** says assertions are enabled for `pack1.A`; same for `B`, `C`, `D` as each class initializes.
6. **`assert` bytecode** — If enabled for that class, a failed `assert` throws `AssertionError`; if disabled, the statement is skipped.

#### Scenario 1 — only `B`

```text
java -ea:pack1.B MainClass
```

```mermaid
flowchart TD
  CMD["-ea:pack1.B"] --> P["Parse scoped rules"]
  P --> A["pack1.A loads → asserts OFF"]
  P --> B["pack1.B loads → asserts ON"]
  P --> C["pack1.pack2.C loads → asserts OFF"]
  P --> D["pack1.pack2.D loads → asserts OFF"]
```

#### Scenario 2 — `B` and `D`

```text
java -ea:pack1.B -ea:pack1.pack2.D MainClass
```

```mermaid
pie showData
    title Assertion enablement (scenario 2)
    "B and D ON" : 50
    "A and C OFF" : 50
```

#### Scenario 3 — whole `pack1` tree

```text
java -ea:pack1... MainClass
```

```mermaid
flowchart LR
  ROOT["-ea:pack1..."] --> A["A ON"]
  ROOT --> B["B ON"]
  ROOT --> P2["pack2"]
  P2 --> C["C ON"]
  P2 --> D["D ON"]
```

#### Scenario 4 — `pack1...` except `B`

```text
java -ea:pack1... -da:pack1.B MainClass
```

```mermaid
sequenceDiagram
  participant JVM
  JVM->>JVM: apply -ea:pack1... (A,B,C,D ON)
  JVM->>JVM: apply -da:pack1.B (B OFF)
  Note over JVM: A,C,D remain ON
```

#### Scenario 5 — `pack1...` except `pack2...`

```text
java -ea:pack1... -da:pack1.pack2... MainClass
```

| Class | Assertions after both flags |
| ----- | --------------------------- |
| `pack1.A` | ON |
| `pack1.B` | ON |
| `pack1.pack2.C` | OFF |
| `pack1.pack2.D` | OFF |

```mermaid
flowchart TD
  E["-ea:pack1..."] --> ALL["Enable A,B,C,D"]
  ALL --> X["-da:pack1.pack2..."]
  X --> F["Disable C,D"]
  F --> OUT["Final: A,B ON — C,D OFF"]
```

```mermaid
pie showData
    title Scenario 5 — classes with assertions ON
    "pack1.A" : 25
    "pack1.B" : 25
    "pack1.pack2.C (off)" : 25
    "pack1.pack2.D (off)" : 25
```

#### Quick map (slide summary)

```mermaid
flowchart TB
  subgraph s1 ["1 single class"]
    C1["-ea:pack1.B"]
  end
  subgraph s2 ["2 two classes"]
    C2["-ea:pack1.B -ea:pack1.pack2.D"]
  end
  subgraph s3 ["3 package tree"]
    C3["-ea:pack1..."]
  end
  subgraph s4 ["4 tree minus class"]
    C4["-ea:pack1... -da:pack1.B"]
  end
  subgraph s5 ["5 tree minus subpackage"]
    C5["-ea:pack1... -da:pack1.pack2..."]
  end
```

