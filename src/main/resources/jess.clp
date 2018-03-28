(import ru.icc.cells.ssdc.model.*)
(import ru.icc.cells.ssdc.model.style.*)

(deftemplate CCell(declare (from-class CCell)))
(deftemplate CLabel (declare (from-class CLabel)))
(deftemplate CEntry (declare (from-class CEntry)))
(deftemplate CCategory (declare (from-class CCategory)))


( defmodule Module1
( declare (auto-focus TRUE))
)

( defrule rule1
( declare (salience 220)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } (text ?t&:(eq ( call ?t matches "#|s" ) TRUE )))

=>

( ?c.OBJECT setText "0" )
( update ?c.OBJECT )
(printout t "RULE 1" crlf)
)



( defrule rule2
( declare (salience 210)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?t&:( eq ( call ?t matches "F|\\.|\\.{2}+|\\.{3}+|\\u2026|\\u2014|x|-|NA" ) TRUE ) ) )

=>

( ?c.OBJECT setText nil )
( update ?c.OBJECT )
(printout t "RULE 2" crlf)
)



( defrule rule3
( declare (salience 200)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?t&:( eq ( call ?t matches "(\\u2012|\\u2013|\\u2014|\\u2015|\\u002D|\\u2212|\\uFF0D)(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ) TRUE ) ) )

=>

( bind ?s "-" )
( ?c.OBJECT setText ( call ?s concat ( call ?t substring 1 )))
( update ?c.OBJECT )
(printout t "RULE 3" crlf)
)





( defrule rule4
( declare (salience 180)
          ( no-loop TRUE )
          )

?c <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } )

=>

( ?c.OBJECT setMark "ColumnHeading" )
( ?c.OBJECT newLabel )
( update ?c.OBJECT )
( printout t "RULE 4 " ?c.text  " " ((?c.OBJECT getLabel)  isTerminal) crlf)
)




( defrule rule5
( declare (salience 170)
          ( no-loop FALSE )
          )

?c1 <- ( CCell { mark == "ColumnHeading" }  (rb ?rb1) (cl ?cl1) (cr ?cr1))
?c2 <- ( CCell { mark == nil && blank == FALSE } (rt ?rt2&:( and (> ?rt2 1) (= ?rt2 (+ ?rb1 1)))) (cr ?cr2) (cl ?cl2&:(> ?cl2 1)) )  ;;(cl ?cl2&:(and (> ?cl2 1) (or (and (<= ?cl1 ?cl2) (< ?cr2 ?cr1)) (and (< ?cl1 ?cl2) (<= ?cr2 ?cr1)) ) )) )
(test (or (and (<= ?cl1 ?cl2) (< ?cr2 ?cr1)) (and (< ?cl1 ?cl2) (<= ?cr2 ?cr1))))
=>
( ?c2.OBJECT setMark "ColumnHeading" )
( ?c2.OBJECT newLabel )
((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
( update ?c1.OBJECT )
( update ?c2.OBJECT )
(printout t "RULE 5 " ?c2.text " " ?c1.text crlf)
)




( defrule rule6
( declare (salience 160)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl == 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "RowHeading" )
( ?c.OBJECT newLabel )
( update ?c.OBJECT )
(printout t "RULE 6 " ?c.text crlf)
)




( defrule rule7
( declare (salience 150)
          ( no-loop TRUE ))

?c0 <- ( CCell { rt == 1 && cl == 1 && blank == FALSE } )
?c1 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil } (text ?t&:(not ( call ?t matches "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?"  ) ) ) )
?c2 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil && cl <= c1.cl } )

=>

( ?c2.OBJECT setMark "RowHeading" )
( ?c2.OBJECT newLabel )
( update ?c2.OBJECT )
;;(printout t "RULE 7 " (not (regexp "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?c1.text )) " " ?c1.text " "  ?c2.text crlf)
)




( defrule rule8
( declare (salience 140)
          ( no-loop TRUE ))

?c <- ( CCell { cl > 1 && rt > 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "DataCell" )
( ?c.OBJECT newEntry )
( update ?c.OBJECT )
(printout t "RULE 8 " (?c.OBJECT getText) crlf)
)




( defrule rule9
( declare ( no-loop TRUE )
          ( salience 120 ))

?c <- ( CCell { cl == 1 && mark == "RowHeading" && charAt0 == 45 } )

=>

( ?c.OBJECT setIndent 2 )
( update ?c.OBJECT )
(printout t "RULE 9 " (?c.OBJECT getCharAt0) crlf)
)





( defrule rule10
( declare ( no-loop TRUE )
          ( salience 100 )
          )

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" }  (indent ?ind1) )
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > c1.rt } (indent ?ind2&:( = ?ind2 ( + ?ind1 2 ))) )
( not  ( exists ( CCell { cl == 1 && mark == "RowHeading" && indent == c1.indent && rt > c1.rt && rt < c2.rt } ) ) )

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel))
(printout t "RULE 10" crlf)
)




( defrule rule11
( declare (no-loop TRUE )
          ( salience 80 ))

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" && indent == 0 } ( style ?s1&:( eq ( call (call ?s1 getFont) isBold ) TRUE ) ) ( text ?t&: (not ( regexp "(?i)(Total\\s*)|(I alt\\s*)|(All\\s*)" ?t ) ) ) )
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > c1.rt && indent == 0 } ( style ?s2&:( eq (call (call ?s2 getFont) isNormal) TRUE ) ) )
( not ( exists ( CCell { cl == 1 && mark == "RowHeading" && rt > c1.rt && rt < c2.rt && indent == 0 } (style ?s3&:(call (call ?s3 getFont) isBold) ) ) ) )

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
(printout t "RULE 11 " ?c2.text " " ?c1.text crlf)
)





( defrule rule12
( declare (no-loop TRUE )
          ( salience 50 ))

?c <- ( CCell { mark == "ColumnHeading" } )

=>
((?c.OBJECT getLabel) setCategory "ColumnHeading" )
( update ?c.OBJECT )
(printout t "RULE 12" crlf)
)



( defrule rule13
( declare ( no-loop TRUE )
          ( salience 40 ))

?c1 <- ( CCell { rt == 1 && blank == FALSE && cl > 1 } ) ;; (cl ?cl1&:(> ?cl1 1)) )
?c2 <- ( CCell { mark == "RowHeading" && cl == c1.cl } )

=>

((?c2.OBJECT getLabel) setCategory (str-cat "RowHeading" ( call ?c1.OBJECT getCl)))
( update ?c2.OBJECT )
(printout t "RULE 13" crlf)
)



( defrule rule14
( declare ( no-loop TRUE)
          ( salience 30 ))

?c1 <- ( CCell { rt == 1 && cl == 1 } )
?c2 <- ( CCell { mark == "RowHeading" && cl == 1 } )

=>

(( ?c2.OBJECT getLabel ) setCategory "RowHeading1" )
( update ?c2.OBJECT )
(printout t "RULE 14" crlf)
)





( defrule rule15
( declare (no-loop TRUE)
          ( salience 10 ))

?c1 <- ( CCell  { mark == "ColumnHeading" } ( label ?l ) )  ;;&:(neq ?label nil) ) ))
;;(test ( eq (call ?l isTerminal ) TRUE ))
?c2 <- ( CCell { mark == "DataCell" && cl == c1.cl } )
=>
(if (call ?l isTerminal ) then
((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
( update ?c2.OBJECT )
(printout t "RULE 15 " (?c2.OBJECT getText) " " (?c1.OBJECT getText) " " ( ?l isTerminal ) crlf)
)
)





( defrule rule16
( declare (no-loop TRUE)
          ( salience 0 ))

?c1 <- ( CCell { mark == "RowHeading" } (rt ?rt1) )
?c2 <- ( CCell { mark == "DataCell" && rt == ?rt1 } )

=>

((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
( update ?c2.OBJECT )
(printout t "RULE 16" crlf)
)