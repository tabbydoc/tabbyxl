# TabbyXL

A software platform for rule-based transformation spreadsheet data from arbitrary to relational tables.

## Version
1.1.1

## Building with Apache Maven

First, you need to clone the project into your directory

```bash
git clone https://github.com/tabbydoc/tabbyxl.git
```

In order to build the executable JAR with dependencies, change to the project directory, where is pom.xml, and run the following command

```bash
mvn clean install
```

*We recommend you to use Apache Maven 3.6.0 or more and JDK 8 or more*

You may test the newly compiled and packaged JAR file with the following command:

```bash
java -jar target/TabbyXL-1.1.1-jar-with-dependencies.jar -input examples/data/smpl.xlsx -ruleset examples/rules/smpl.crl -output examples/results
```

or run the testing script

```bash
./test.sh
```

On Windows use the batch file

```bash
test.bat
```

*Note that, with this option, you should run `java` included in JDK, not JRE. Otherwise, you get the following message:*

```
Exception in thread "main" java.lang.IllegalStateException
        at ru.icc.td.tabbyxl.crl2j.compiler.CharSequenceCompiler.<init>(CharSequenceCompiler.java:44)
        at ru.icc.td.tabbyxl.crl2j.RuleCodeGen.compileAllRules(RuleCodeGen.java:38)
        at ru.icc.td.tabbyxl.TabbyXL.loadCRL2J(TabbyXL.java:638)
        at ru.icc.td.tabbyxl.TabbyXL.runRulesetWithCRL2J(TabbyXL.java:648)
        at ru.icc.td.tabbyxl.TabbyXL.main(TabbyXL.java:487)
```

*If you see this message, then, please, check that you run `java` included in JDK. You also can try to use `"%JAVA_HOME%/bin/java"` instead of `java` as follows.*

```bash
"%JAVA_HOME%/bin/java" -jar target/TabbyXL-1.1.1-jar-with-dependencies.jar -input examples/data/smpl.xlsx -ruleset examples/rules/smpl.crl -output examples/results
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
```

then it works.

## Usage

In order to run the executable JAR, you may use the following command with parameters  

```
java -jar target/TabbyXL-1.1.1-jar-with-dependencies.jar <params>

Params:
-input <path>                      specify a path to an input excel workbook (*.xlsx)
-sheets <sheet indexes>            specify sheet indexes in the input excel workbook (e.g. "0-2,4,5,7-10")
-ruleset <path>                    specify a path to a ruleset file (e.g. *.crl (CRL), *.drl or *.dslr (Drools), or *.clp (JESS))
-categorySpec <path>               specify a path to a directory with category specifications in YAML files (*.cat)
-output <path>                     specify a path to a directory for outputting results
-ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
-useCellText <true|false>          specify true to use cell values as text (false used by default)
-useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
-debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
-ruleEngineConfig <path>           specify optionally a path to a configuration file (*.properties) of a rule engine you prefer to use (e.g. Drools, JESS)
                                   (CRL-to-Java translation is used by default instead of a rule engine)

-help                              print this usage

-gSheetID <id>                     specify a Google Sheets spreadsheet ID (this can be extracted from its URL)
-gSheetRange <range>               specify a range (e.g. "sheet1!A1:F5") in the Google Sheets spreadsheet
-gServiceAccountKey <path>         specify a path to the Google service account key file (e.g. "mydata/key.p12")
```

Mandatory parameters:
* either `-input <path>` or `-googleSheetID <id>`
* `-ruleset <path>`

*We recommend you to use JRE 8 or more*

## Authors

* Alexey O. Shigarov
* Vasiliy V. Khristyuk
* Viacheslav V. Paramonov

## License
Apache License, Version 2.0
