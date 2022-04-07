# Usage

In order to run the executable JAR, you may use the following command with parameters  
```
java -jar TabbyXL-1.1.1-jar-with-dependencies.jar <params>

Params:
-input <path>                      specify a path to an input excel workbook (*.xlsx)
-sheets <sheet indexes>            specify sheet indexes in the input excel workbook (e.g. "0-2,4,5,7-10")
-ruleset <path>                    specify a path to a ruleset file (*.dslr (CRL), *.drl (Drools), or *.clp (JESS))
-categorySpec <path>               specify a path to a directory with category specifications in YAML files (*.cat)
-output <path>                     specify a path to a directory for outputting results
-ignoreSuperscript <true|false>    specify true to ignore superscript text in cells (false used by default)
-useCellText <true|false>          specify true to use cell values as text (false used by default)
-useShortNames <true|false>        specify true to use short names (just sheet names) for output files (false used by default)
-debuggingMode <true|false>        specify true to turn on debugging mode (false used by default)
-ruleEngineConfig <path>           specify optionally a path to a configuration file (*.properties) of a rule engine you prefer to use (e.g. Drools, JESS)
                                   (CRL-to-Java translation is used by default instead of a rule engine)

-help                              print this usage

-googleSheetID                     specify a Google Sheets spreadsheet ID (this can be extracted from its URL)
-googleSheetRange                  specify a range (e.g. "sheet1!A1:F5") in the Google Sheets spreadsheet specified by its ID
```

Mandatory parameters:
* either `-input <path>` or `-googleSheetID <id>`
* `-ruleset <path>`

## Authors

* Alexey O. Shigarov
* Vasiliy V. Khristyuk
* Viacheslav V. Paramonov

## License
Apache License, Version 2.0