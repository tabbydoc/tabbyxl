(import ru.icc.cells.ssdc.model.*)
(import ru.icc.cells.ssdc.model.style.*)
(import java.lang.Integer)

(deftemplate CCell(declare (from-class CCell)))
(deftemplate CLabel (declare (from-class CLabel)))
(deftemplate CEntry (declare (from-class CEntry)))
(deftemplate CCategory (declare (from-class CCategory)))

( defrule rule1
;;( declare ( auto-focus TRUE))
?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } (text ?text))
;;( test ( ?text matches "#|s" ))
( test ( regexp "#|s" ?text ))
=>
( modify ?c ( text "0" ) )
( ?c.OBJECT setText "0" )
)

( defrule rule2
;;( declare ( auto-focus TRUE))
?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text ) )
;;( test ( call ?text matches "F|\\.|\\.{2}+|\\.{3}+|\\u2026|\\u2014|x|-|NA" ))
( test ( regexp "F|\\.|\\.{2}+|\\.{3}+|\\u2026|\\u2014|x|-|NA" ?text ))
=>
( modify ?c ( text nil ) )
( ?c.OBJECT setText nil )
)

( defrule rule3
;;( declare ( auto-focus TRUE))
?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text ) )
;;( test ( call ?text matches "(\\u2012|\\u2013|\\u2014|\\u2015|\\u002D|\\u2212|\\uFF0D)(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ))
( test ( regexp "(\\u2012|\\u2013|\\u2014|\\u2015|\\u002D|\\u2212|\\uFF0D)(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text ))
=>
( modify ?c ( text ( call "-" concat ( ?text substring 1 )) ) )
( ?c.OBJECT setText ( call "-" concat ( ?text substring 1 )))
)

( defrule rule4
;;( declare ( auto-focus TRUE))
?c <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } )
=>
( modify ?c ( mark "ColumnHeading" ))
( ?c.OBJECT setMark "ColumnHeading" )
( ?c.OBJECT newLabel )
( modify ?c (labelIsTerminalFlag ((?c.OBJECT getLabel) isTerminal)))
)

( defrule rule5
;;( declare ( auto-focus TRUE))
?c1 <- ( CCell { mark == "ColumnHeading" } )
?c2 <- ( CCell { mark == nil && rt > 1 && cl > 1 && blank == FALSE && rt == ( + c1.rb 1 ) && (( cl >= c1.cl && cr < c1.cr ) || ( cl > c1.cl  && cr <= c1.cr ))} )
=>
( modify ?c2 ( mark "ColumnHeading" ))
( ?c2.OBJECT setMark "ColumnHeading" )
( ?c2.OBJECT newLabel )
( modify ?c2 (labelIsTerminalFlag ((?c.OBJECT getLabel) isTerminal)))
( (?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
)

( defrule rule6
;;( declare ( auto-focus TRUE))
?c <- ( CCell { rt > 1 && cl == 1 && blank == FALSE && mark == nil } )
=>
( modify ?c ( mark "RowHeading" ))
( ?c.OBJECT setMark "RowHeading" )
( ?c.OBJECT newLabel )
( modify ?c (labelIsTerminalFlag ((?c.OBJECT getLabel) isTerminal)))
)

( defrule rule7
;;( declare ( auto-focus TRUE))
?c0 <- ( CCell { rt == 1 && cl == 1 && blank == FALSE } )
?c1 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil } (text ?text) )
;;( test ( not ( call ?text matches "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?")))
( test ( not ( regexp "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text )))
?c2 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil && cl <= c1.cl } )
=>
( modify ?c2 ( mark "RowHeading" ))
( ?c2.OBJECT setMark "RowHeading" )
( ?c2.OBJECT newLabel )
( modify ?c2 (labelIsTerminalFlag ((?c2.OBJECT getLabel) isTerminal)))
)

( defrule rule8
;;( declare ( auto-focus TRUE))
?c <- ( CCell { cl > 1 && rt > 1 && blank == FALSE && mark == nil } )
=>
( modify ?c ( mark "DataCell" ))
( ?c.OBJECT setMark "DataCell" )
( ?c.OBJECT newEntry )
)

( defrule rule9
( declare ( no-loop TRUE ))
?c <- ( CCell { cl == 1 && mark == "RowHeading" } ( text ?text ))
( test ( eq ( call ?text charAt 0) 45 ))
=>
( ?c.OBJECT setIndent 2 )
( modify ?c (indent 2))
)


;; indent mb incorrect
( defrule rule10
( declare ( no-loop TRUE ))
?c1 <- ( CCell { cl == 1 && mark == "RowHeading" } (indent ?ind1) )
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > c1.rt } (indent ?ind2) )
( test ( = ?ind2 ( + ?ind1 2 )))
( not ( exists ( CCell { cl == 1 && mark == "RowHeading" && indent == c1.indent && rt > c1.rt && rt < c2.rt } )))
=>
((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel))
)

( defrule rule11
( declare (no-loop TRUE ))
?c1 <- ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && indent == 0 } (text ?text))
;;( test (not ( ?text matches "(?i)(Total\\s*)|(I alt\\s*)|(All\\s*)")))
( test ( not ( regexp "(?i)(Total\\s*)|(I alt\\s*)|(All\\s*)" ?text )))
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > c1.rt && indent == 0 } (style ?style))
( test ((?style getFont) isNormal ))
( not ( exists ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && rt > c1.rt && rt < c2.rt && indent == 0 } )))
=>
((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
)

( defrule rule12
( declare (no-loop TRUE ))
?c <- ( CCell { mark == "ColumnHeading" } )
=>
((?c.OBJECT getLabel) setCategory "ColumnHeading" )
)

( defrule rule13
( declare ( no-loop TRUE ))
?c1 <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } )
?c2 <- ( CCell { mark == "RowHeading" && cl == c1.cl } )
=>
( bind ?index ?c1.cl )
((?c2.OBJECT getLabel) setCategory (str-cat "RowHeading" ?index))
)

( defrule rule14
( declare ( no-loop TRUE))
?c1 <- ( CCell { rt == 1 && cl == 1 } )
?c2 <- ( CCell { mark == "RowHeading" && cl == 1 } )
=>
(( ?c2.OBJECT getLabel ) setCategory "RowHeading1" )
)

( defrule rule15
( declare (no-loop TRUE))
?c1 <- ( CCell { mark == "ColumnHeading" && labelIsTerminalFlag == TRUE })
;;( test ( (?obj getLabel) isTerminal))
?c2 <- ( CCell { mark == "DataCell" && cl == c1.cl } )
=>
((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
)

( defrule rule16
( declare (no-loop TRUE))
?c1 <- ( CCell { mark == "RowHeading" } )
?c2 <- ( CCell { mark == "DataCell" && rt == c1.rt } )
=>
((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
)