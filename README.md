# Hello world! Line editor program "lineeditor".

## Short program description

This command line application program is to perform simple manipulation over '\*.txt' (plain text) files. To see how to run  the program, please, refer to the [How to run](#how-to-run) section. The list of available commands is described in the [Commands](#commands) section.

## How to run

The program is built into an executable JAR file. You may find it in [./out/artifacts/lineeditor_jar/](./out/artifacts/lineeditor_jar/) folder. To execute the program, you need to open your system terminal, change directory to the one where JAR file is located, and run it by using next command:
```
java -jar lineeditor.jar [filePath]
```
where [filePath] is the path to '.txt' file you want to edit. E.g, your command might look like next:
```
java -jar lineeditor.jar c:\temp\myfile.txt
```
You may also want to use test '\*.txt' files located in [./src/main/resources](./src/main/resources/) folder to test the program.

## How to build

The program was built via IntelliJ IDEA software. Please, [click on this link for detailed guidance](https://www.jetbrains.com/help/idea/compiling-applications.html#compile_module).

However, you are able to build the program only by using your terminal. Please, [click on this link for detailed guidance](https://www.javatpoint.com/how-to-make-an-executable-jar-file-in-java) or [this one](https://www.baeldung.com/java-create-jar).

## Commands

Only next commands are supported so far:
* *list* -- the program outputs the text file into command line in *n:xxx* format, e.g:
```
1:It's 
2:Wensday 
3:My dudes 
```
* *del n* -- the program deletes a line at position *n*
* *ins n* -- the program inserts a new line into text at position *n*. Please note that after this command the program will ask you to write a new line and that every line after *n* will be moved on 1 step forward.
* *save* -- the program saves the changes ~~(unexpected, huh?)~~.
* *quit* -- the program quits. 

## Note/limitations

The only limitation is that the program is able only to work with plain text files so far.

## UinitTests

The project also contains Gradle module to perform Unit Tests. Files located in [./src/main/resources](./src/main/resources/) folder were used for testing. Next tests were performed on empty and not empty text files:
1) the program reads a file correctly;
2) *list* command is performed correctly;
3) *del n* command is performed correctly (test cases, n = {-1, 0, 3, 20, 100});
4) *ins n* command is performed correctly (test cases, n = {-1, 0, 1, 20, 100});
5) *save* command is performed correctly;

*quit* command is not applicable for testing, since it uses *System.exit(0)* command.

No exceptions were noted.
