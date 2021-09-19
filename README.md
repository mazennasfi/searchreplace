# searchreplace

## About

**searchreplace** is a Java program that can search and replace a specific text phrase in a text file,
and search and replace a specific text phrase in the attribute values of an XML file.

## Usage

The program accepts 3 command line parameters :

1. fileDataType : the data type of the file which can be txt or xml.
2. oldString : the string that we want to replace.
3. newString : the new string.

The program can read from standard input (the file content) and write to standard output (destination).

## UML class diagram of the program:

![UML class diagram](diagrams/DocumentFactoryMethod.png)

Following the Factory Method design pattern, the Main class asks the DocumentFactory to create a text or xml document,
based on fileDataType entered by the user.
The TextDocument and XMLDocument classes extend from Document abstract class.

## Testing

I used JUnit 5 as unit testing framework.
