# Amazon Java Compiler

## Introduction
Amazon has decided to internally distribute its own version of Java. Your team now owns writing the compiler
for the new Amazon Java version. Before the Java code is translated into machine code, the compiler does many syntax
checks. Today we will be implementing the first syntax check!

Valid Java files must have balanced curly braces, meaning there need to be the same number of left curly braces, '{'
as right curly braces, '}' in a file. The `AmazonJavaFileCompiler` first parses a file and then applies different
checks.

### Before Starting
We'll be using other Java files as *resources* to test our compiler. To make sure we can run and
debug our tests in IntelliJ, verify the directories `src/resources` and `tst/resources` are marked as
*Resources Root* and *Test Resources Root* respectively. You can do so by looking at the directories in IntelliJ's
project panel and looking for a small yellow icon on the folders.

If you don't see an icon, right click the directories and select 'Mark Directory as -> Resources Root' and 'Mark
Directory as -> Test Resources Root' from the context menu, depending on whether it's in the `src/main` or `src/test`
directory. Do **not** select 'unmark as...' since that means they already are marked as resource roots, and IntelliJ
should be able to access files within those folders.

### Implementing the Amazon Java Compiler Check
You will be implementing the `check` method in the `BalancedCurlyBraceValidator` class. The method is provided with a
list of characters from the file that is being compiled. The method should return `true` if the curly braces in the file
are balanced, and false otherwise.

Your check method does not need to handle the case of a `String` literal containing an escaped curly brace.

Unit tests have been provided in the `BalancedCurlyBraceValidatorTest` class for the check method.

### Applying the Curly Brace Check
 `AmazonJavaFileCompiler` is responsible for parsing a provided Amazon Java file, and then applying compilation
 checks in its `compile` method. Update `AmazonJavaFileCompiler` to use the new check you wrote in
 `BalancedCurlyBraceValidator`. Currently, whether a file compiles or not will be based only on this check. Your
 teammates will be adding new checks soon!

The  `AmazonJavaFileCompiler` contains a main method that you can run to interact with your compiler. 

You can verify that your compiler is working as expected by running the `AmazonJavaFileCompilerIntegrationTest` tests. 

### Extension: Debug
We also have a requirement to track and print additional debug information when compiling. The
`BalancedCurlyBraceValidator` has a `debug` variable. If this is set to true using the `setDebug` method,
the `check` method should track and print the following information *before* returning true or false.

The compiler team is interested in recording:
* The maximum number of unbalanced parenthesis encountered while validating the list of file characters
* The count of remaining unbalanced parenthesis by each type i.e. '{' or '}'.
* The longest string of characters between a pair of balanced parenthesis in the list of file characters
