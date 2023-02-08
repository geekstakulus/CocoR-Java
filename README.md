# Coco/R - Compiler Generator

Coco/R for Java is a compiler generator that allows you to create a scanner and a parser for a source language, 
given an attributed grammar. 
The generated scanner uses a deterministic finite automaton 
and the parser generates a recursive descent model. 
Additionally, 
LL(1) conflicts can be resolved through a multi-symbol lookahead 
or by semantic checks, 
resulting in the class of accepted grammars being LL(k) for an arbitrary k.

Coco/R is available for various programming languages, 
including Modula-2, 
Oberon, 
Pascal, 
C#, 
C++, 
SWIFT, 
and many others. 
This project specifically focuses on providing Coco/R for Java, 
and is a fork of the [CocoR-Java](https://github.com/SSW-CocoR/CocoR-Java) repository.

With Coco/R for Java, 
you can quickly and easily generate a scanner and parser for a source language, 
given an attributed grammar. 
Whether you're a language designer or a Java software developer looking to build your own language processors,
such as compilers,
transpilers,
assemblers,
interpreters,
and many other types of text processors, 
Coco/R for Java can help you get started with ease and speed.

Coco/R is similar to ANTLR.
However,
while ANTLR is one of the most widely-used parser generators, 
Coco/R provides greater flexibility and customization options.

## Requirements

In order to use Coco/R, 
you'll need to have the following software installed:

- A compatible operating system (e.g. Windows, Linux, macOS)
- Java 8 or later

## Usage

To use Coco/R, follow these steps:

1. Define the attributed grammar of the source language you want to generate a scanner and parser for.
2. Run Coco/R, specifying the input file containing the attributed grammar and the names of the output files to be generated.
3. Use the generated scanner and parser in your own software to parse and process source code written in the language described by the attributed grammar.

## Contributing

If you're interested in contributing to the development of Coco/R, we welcome your contributions! Here are some ways you can help:

- Report bugs and suggest new features
- Write documentation and examples
- Improve the codebase by submitting pull requests

## License

Coco/R is released under the [GNU General Public License, version 2 (GPL-2.0)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html).
