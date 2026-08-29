# Regular Expressions — Basics

**File:** [regularExpressionBasics.java](../../../demo/src/main/java/com/regularExpressions/regularExpressionBasics.java)

## 📌 Concept

> A regular expression represents a **group of Strings that follow a particular pattern**, instead of a single fixed String. It lets you validate or match many possible inputs (e.g. "any valid mobile number") with one compact rule.

```mermaid
flowchart TD
    A["Regular Expression\n(pattern)"] --> B["Represents a group of Strings\nthat follow that pattern"]
    B --> C["e.g. \\d{10} matches\nany 10-digit mobile number"]
    B --> D["e.g. [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}\nmatches any valid email Id"]
```

### Main application areas

1. **Form/input validation** — e.g. mobile numbers, email addresses.
2. **Pattern-matching applications** — e.g. `Ctrl+F` (Windows), `grep` (Unix).
3. **Building translators** — e.g. assemblers, compilers, interpreters (tokenizing source text against lexical patterns).
4. **Designing digital circuits** — pattern-based state/transition specifications used in digital circuit design.
5. **Communication protocols** — specifying valid message/packet formats, e.g. TCP/IP, UDP.

```mermaid
mindmap
  root((Regular Expressions))
    Form Validation
      Mobile numbers
      Email Ids
    Pattern Matching Tools
      Ctrl+F (Windows)
      grep (Unix)
    Translators
      Assemblers
      Compilers
      Interpreters
    Digital Circuits
      Pattern-based design
    Communication Protocols
      TCP/IP
      UDP
```

## � Execution Summary of the Program

This file demonstrates the core idea of regex matching using `Pattern` and `Matcher`.

### Program flow

```mermaid
flowchart TD
    A["main() starts"] --> B["call fetchPattern(patternString, input)"]
    B --> C["Pattern.compile(input)"]
    C --> D["matcher = pattern.matcher(patternString)"]
    D --> E{"while (matcher.find())"}
    E -- yes --> F["print matcher.start(), matcher.end(), matcher.group()"]
    F --> G["count++"]
    G --> E
    E -- no --> H["print total patterns found"]
```

### What the program does

- `Pattern.compile(input)` creates a regex pattern from the `input` text.
- `pattern.matcher(patternString)` tries to find matches inside the larger string.
- `matcher.find()` keeps scanning until no more matches remain.
- For every match, Java prints:
  - `matcher.start()` → index where the match starts
  - `matcher.end()` → index just after the match ends
  - `matcher.group()` → the actual matched text
- `count` stores how many matches were found.

### Why `start()` and `end()` behave like this

Java uses a half-open range for match boundaries:

- `start()` is inclusive
- `end()` is exclusive

So if a match is found at index `21` and ends at `23`, the matched text is from index `21` and `22`.

```mermaid
sequenceDiagram
    participant J as Java Matcher
    participant S as Source String
    Note over J,S: Example match = "re"
    J->>S: start() = 21
    J->>S: end() = 23
    Note over S: indexes 21..22 are used
    Note over S: end is exclusive, so 23 is just after the match
```

### Example interpretation

```text
match found: re
start = 21
end = 23
actual characters used = indexes 21 to 22
```

So the formula is:

```text
match length = end - start
```

For example:

```text
23 - 21 = 2
```

This explains why the output can look like:

```text
21===23===re
```

Even though the actual match is only two characters long.

public static Pattern complie(String target)

We can use matcher Object to check trhe given pattern in the target String
We can create a matcher Object by using matcher() of Pattern class

Public Matcher matecher(String target)

## Important Methods of Matcher class 
> boolean find()
It attempts to find next match and returns true if it is available 
> int start() 
Returns the start index of the match 
> int end()
Returns end + 1 index of the match 
> String group()
It returns the matched pattern 

# NOTE 
> Pattern and matcher classes present in java.util.regex package 
and introduced in 1.4 V 

## 🔗 Related Files
- [regularExpressionBasics.java](../../../demo/src/main/java/com/regularExpressions/regularExpressionBasics.java) — source file implementing the regex scanning logic.

# character classes 

>[abc] => either 'a' or 'b' or 'c'

>[^abc] => any character except 'a', 'b' or 'c' (negation)

>[a-z] => any character from 'a' to 'z' (lowercase range)

>[A-Z] => any character from 'A' to 'Z' (uppercase range)

>[a-zA-Z] => any character from 'a' to 'z' or 'A' to 'Z' (a letter, either case)

>[0-9] => any digit from '0' to '9'

>[a-d[m-p]] => union: either 'a' to 'd' or 'm' to 'p'

>[a-z&&[def]] => intersection: only 'd', 'e' or 'f' (letters common to both classes)

>[a-z&&[^bc]] => subtraction: 'a' to 'z' except 'b' and 'c'

>[a-z&&[^m-p]] => subtraction: 'a' to 'z' except 'm' to 'p'

# predefined character classes

>. => any character (except line terminator)

>\d => any digit, same as [0-9]

>\D => any non-digit, same as [^0-9]

>\s => any whitespace character (space, tab, newline), same as [ \t\n\x0B\f\r]

>\S => any non-whitespace character, same as [^\s]

>\w => any word character, same as [a-zA-Z_0-9]

>\W => any non-word character, same as [^\w]

# quantifiers

>X? => X occurs zero or one time (optional)

>X* => X occurs zero or more times

>X+ => X occurs one or more times

>X{n} => X occurs exactly n times

>X{n,} => X occurs at least n times

>X{n,m} => X occurs at least n but not more than m times

# boundary matchers

>^ => matches at the beginning of a line

>$ => matches at the end of a line

>\b => matches a word boundary

>\B => matches a non-word boundary

>\A => matches at the beginning of the input

>\Z => matches at the end of the input, before the final line terminator (if any)

>\z => matches at the very end of the input

# logical operators

>XY => X followed by Y (concatenation)

>X|Y => either X or Y (alternation)

>(X) => X as a capturing group

# back references

>\n => matches whatever was matched by the n-th capturing group (e.g. \1 refers to group 1)

# Regular Expressions — Pattern Class 

# split()

We can use Pattern class split() to split thew target String according to a particular pattern

# StringTokenizer 

It is specially designed class for tokenization activity 

StringTokenizer present in java.util package 



