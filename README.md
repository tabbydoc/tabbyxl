# TabbyXL
A research system for rule-based transformation spreadsheet data from arbitrary to relational tables.

## Building with Apache Maven
In order to build the executable JAR with dependencies, 
change to the project directory where is pom.xml and run the following command
```bash
mvn clean install
```
*We recommend you to use Apache Maven 3.0.5 or more and JDK 1.8.0 or more*

You may test the newly compiled and packaged JAR file with the following command:
```bash
java -jar target/TabbyXL-0.1-jar-with-dependencies.jar -input samples/sampl.xlsx -ruleset samples/sampl.dslr -output samples/results
```
or run the testing script
```bash
./test.sh
```
On Windows use the batch file
```bash
test.bat
```
If the program prints at the end something like this
```
Total number of
	tables: 4
	cells: 105
	not empty cells: 99
	labels: 50
	entries: 51
	label-label pairs: 0
	entry-label pairs: 219
	category-label pairs: 50
	categories: 17
	label groups: 17

Total rule firing time: 91
```
then it works.

## Usage
In order to run the executable JAR, you may use the following command with the parameters  
```
java -jar target/TabbyXL-0.1-jar-with-dependencies.jar <params>

Params:
-input <input excel file>          path to an input excel workbook (*.xlsx file)
-sheets <sheet indexes>            sheet indexes in the input excel workbook (e.g. "0-2,4,5,7-10")
-ruleset <drl or dslr file>        path to a ruleset (*.drl or *.dslr file)
-categorySpec <category directory> path to a directory with category specifications in YAML (*.cat files)
-output <output directory>         path to a directory for outputting results
-ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
-useCellText <true|false>          specify true to use cell values as text (false used by default)
-useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
-debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
-help                              print this usage
```

Only two parameters are mandatory
* `-input <input excel file>`
* `-ruleset <drl or dslr file>`

*We recommend you to use JRE 8 or more*

## Authors

* Alexey O. Shigarov
* Andrey A. Mikhailov

## License
Apache License, Version 2.0