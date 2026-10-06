# JVM Architecture

> Topic list from Notepad++ classroom notes (two screenshots, **part 1 → part 2**).  
> **You add descriptions** under each heading; this file provides structure and **Ctrl+click** navigation only.

> **Navigation:** Use **Ctrl+click** on [Guide map](#guide-map) or [TOC](#table-of-contents) links in **Markdown Preview** (`Ctrl+Shift+V`) to jump to any topic.

**Source screenshots:** [Part 1](images/notepad-syllabus-part-1.png) · [Part 2](images/notepad-syllabus-part-2.png)

---

## Guide map

| Jump to                                                                                     | Topic (Notepad++)                           |
| ------------------------------------------------------------------------------------------- | ------------------------------------------- |
| [Virtual Machine](#virtual-machine)                                                         | Virtual Machine                             |
| [Type of Virtual Machines](#type-of-virtual-machines)                                       | Type of Virtual Machines                    |
| [Hard ware Based VM](#hard-ware-based-vm)                                                   | ↳ 1. Hard ware Based VM                     |
| [Application Based VM](#application-based-vm)                                               | ↳ 2. Application Based VM                   |
| [Basic Architecture of JVM](#basic-architecture-of-jvm)                                     | Basic Architecture of JVM                   |
| [Class Loader SubSystem](#class-loader-subsystem)                                           | Class Loader SubSystem                      |
| [Loading](#loading)                                                                         | ↳ 1. Loading                                |
| [Linking](#linking)                                                                         | ↳ 2. Linking                                |
| [Initialization](#initialization)                                                           | ↳ 3. Initialization                         |
| [Types of Class Loaders](#types-of-class-loaders)                                           | Types of Class Loaders                      |
| [Bootstrap Class Loader](#bootstrap-class-loader)                                           | ↳ 1. Bootstrap Class Loader                 |
| [Extension Class Loader](#extension-class-loader)                                           | ↳ 2. Extension Class Loader                 |
| [Application Class Loader](#application-class-loader)                                       | ↳ 3. Application Class Loader               |
| [How Class Loader works](#how-class-loader-works)                                           | How Class Loader works                      |
| [What is the need of Customized Class Loader](#what-is-the-need-of-customized-class-loader) | What is the need of Customized Class Loader |
| [Psuedo code for Customized Class Loader](#psuedo-code-for-customized-class-loader)         | Psuedo code for Customized Class Loader     |
| [Various Memory Areas of JVM](#various-memory-areas-of-jvm)                                 | Various Memory Areas of JVM                 |
| [Method Area](#method-area)                                                                 | ↳ 1. Method Area                            |
| [Heap Area](#heap-area)                                                                     | ↳ 2. Heap Area                              |
| [Stack Area](#stack-area)                                                                   | ↳ 3. Stack Area                             |
| [PC Registers](#pc-registers)                                                               | ↳ 4. PC Registers                           |
| [Native Method Stacks](#native-method-stacks)                                               | ↳ 5. Native Method Stacks                   |
| [Program to display heap memory statistics](#program-to-display-heap-memory-statistics)     | Program to display heap memory statistics   |
| [How to set Maximum and Minimum heap size?](#how-to-set-maximum-and-minimum-heap-size)      | How to set Maximum and Minimum heap size?   |
| [Execution Engine](#execution-engine)                                                       | Execution Engine                            |
| [Interpreter](#interpreter)                                                                 | ↳ 1. Interpreter                            |
| [JIT Compilers](#jit-compilers)                                                             | ↳ 2. JIT Compilers                          |
| [Java Native Interface (JNI)](#java-native-interface-jni)                                   | Java Native Interface(JNI)                  |
| [Complete Architecture Diagram of JVM](#complete-architecture-diagram-of-jvm)               | Complete Architecture Diagram of JVM        |
| [Class File Structure](#class-file-structure)                                               | Class File Structure                        |

---

## Table of contents

<!-- TOC -->
- [JVM Architecture](#jvm-architecture)
  - [Guide map](#guide-map)
  - [Table of contents](#table-of-contents)
  - [Virtual Machine](#virtual-machine)
  - [Type of Virtual Machines](#type-of-virtual-machines)
    - [Hard ware Based VM](#hard-ware-based-vm)
    - [Application Based VM](#application-based-vm)
  - [Basic Architecture of JVM](#basic-architecture-of-jvm)
  - [Class Loader SubSystem](#class-loader-subsystem)
    - [Loading](#loading)
    - [Linking](#linking)
    - [Initialization](#initialization)
  - [Types of Class Loaders](#types-of-class-loaders)
    - [Bootstrap Class Loader](#bootstrap-class-loader)
    - [Extension Class Loader](#extension-class-loader)
    - [Application Class Loader](#application-class-loader)
  - [How Class Loader works](#how-class-loader-works)
  - [What is the need of Customized Class Loader](#what-is-the-need-of-customized-class-loader)
  - [Psuedo code for Customized Class Loader](#psuedo-code-for-customized-class-loader)
  - [Various Memory Areas of JVM](#various-memory-areas-of-jvm)
    - [Method Area](#method-area)
    - [Heap Area](#heap-area)
    - [Stack Area](#stack-area)
    - [PC Registers](#pc-registers)
    - [Native Method Stacks](#native-method-stacks)
  - [Program to display heap memory statistics](#program-to-display-heap-memory-statistics)
  - [How to set Maximum and Minimum heap size?](#how-to-set-maximum-and-minimum-heap-size)
  - [Execution Engine](#execution-engine)
    - [Interpreter](#interpreter)
    - [JIT Compilers](#jit-compilers)
  - [Java Native Interface (JNI)](#java-native-interface-jni)
  - [Complete Architecture Diagram of JVM](#complete-architecture-diagram-of-jvm)
  - [Class File Structure](#class-file-structure)
<!-- /TOC -->

---

## Virtual Machine

## Type of Virtual Machines

It is a software simulation of a machine which perform operation like a physical machine. There are 2 types of virual machines 
1. Hardware based or system based virtual machine 
2. Application based or process based virtual machine 

### Hard ware Based VM

1. Hardware based or system based virtual machine

It provides several logical systems on the same computer with strong isolation from each other i.e on one physical machine we are defining multiple logical machines 

The main advantage of hardware based virtual machines is hardware resources sharing and improves utlization of 
hardware resources

Ex: KVM[kernal based virtual machine for linux systems], VMware,Xen, cloud computing etc.

### Application Based VM

2. Applicatin based or process based virtual machine 
   
These virtual machines acts as runtime engines to run a particular programming languages applications 
Ex: JVM[Java Virtual Machine ] ---> Acts as runtime engine to run Java based applications 
    PVM[Parrot Virtual Machine] ---> Acts as runtime engine to run peral based applications 
    CLR[Coomon Language Runtime] ---> Acts as runtime engine to run .NET based applications 
    
JVM is the part of JRE and it is resposible to load and run java .class (class files)

## Basic Architecture of JVM

![Basic Architecture of JVM — classroom whiteboard](images/jvm-basic-architecture-whiteboard.png)

The board shows **three layers**: class loading (top), **runtime data areas** (middle), and **execution + native** (bottom). Arrows are **bidirectional** where drawn with double heads on the slide.

```mermaid
flowchart TB
  CF[".class file"] --> CLS["Class Loader Subsystem"]

  CLS <-->|"load / link / initialize"| RUNTIME

  subgraph RUNTIME ["various memory Areas of JVM"]
    direction LR
    MA["Method Area"]
    HEAP["Heap Area"]
    STACK["Stack Area"]
    PC["PC Registers"]
    NMS["Native method Stacks"]
  end

  RUNTIME <-->|"bytecode execution uses runtime data"| EE["Execution Engine"]

  EE <-->|"JNI bridge"| JNI["Java Native Interface (JNI)"]
  JNI <-->|"native code"| NML["Native method Libraries"]
```

**Data flow (same as whiteboard, top → bottom):**

| Step | From | To | Meaning |
| ---- | ---- | -- | ------- |
| 1 | `.class file` | Class Loader Subsystem | Bytecode enters the JVM; loaders read `.class` (or JAR) bytes. |
| 2 | Class Loader Subsystem | various memory Areas | Loaded types and static state land in **Method Area**; objects in **Heap**; frames in **Stack**; per-thread **PC** and **Native method Stacks**. |
| 3 | various memory Areas | Execution Engine | Interpreter / JIT reads bytecode and uses stack, heap, and method metadata. |
| 4 | Execution Engine | JNI | Calls into platform-specific native code when needed. |
| 5 | JNI | Native method Libraries | OS / C libraries backing `native` methods. |

```mermaid
flowchart LR
  subgraph layer1 ["Layer 1 — Loading"]
    A[".class file"] --> B["Class Loader Subsystem"]
  end
  subgraph layer2 ["Layer 2 — Runtime data areas"]
    direction LR
    M1["Method Area"]
    M2["Heap Area"]
    M3["Stack Area"]
    M4["PC Registers"]
    M5["Native method Stacks"]
  end
  subgraph layer3 ["Layer 3 — Execution & native"]
    E["Execution Engine"]
    J["Java Native Interface (JNI)"]
    N["Native method Libraries"]
    E --- J --- N
  end
  layer1 --> layer2
  layer2 --> layer3
```

```mermaid
pie showData
    title Runtime data areas inside JVM (whiteboard)
    "Method Area" : 20
    "Heap Area" : 20
    "Stack Area" : 20
    "PC Registers" : 20
    "Native method Stacks" : 20
```

## Class Loader SubSystem

<!-- description -->

### Loading

<!-- description -->

### Linking

<!-- description -->

### Initialization

<!-- description -->

---

## Types of Class Loaders

<!-- description -->

### Bootstrap Class Loader

<!-- description -->

### Extension Class Loader

<!-- description -->

### Application Class Loader

<!-- description -->

---

## How Class Loader works

<!-- description -->

---

## What is the need of Customized Class Loader

<!-- description -->

---

## Psuedo code for Customized Class Loader

<!-- description -->

---

## Various Memory Areas of JVM

<!-- description -->

### Method Area

<!-- description -->

### Heap Area

<!-- description -->

### Stack Area

<!-- description -->

### PC Registers

<!-- description -->

### Native Method Stacks

<!-- description -->

---

## Program to display heap memory statistics

<!-- description -->

---

## How to set Maximum and Minimum heap size?

<!-- description -->

---

## Execution Engine

<!-- description -->

### Interpreter

<!-- description -->

### JIT Compilers

<!-- description -->

---

## Java Native Interface (JNI)

<!-- description -->

---

## Complete Architecture Diagram of JVM

<!-- description -->

---

## Class File Structure

<!-- description -->
