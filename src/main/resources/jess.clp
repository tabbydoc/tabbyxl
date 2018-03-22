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
( declare (salience 200)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } (text ?text & : ( regexp "#|s" ?text )))

=>

( ?c.OBJECT setText "0" )
( update ?c.OBJECT )
;;(printout t "RULE 1" crlf)
)



( defrule rule2
( declare (salience 200)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text & : ( regexp "F|\\.|\\.{2}+|\\.{3}+|\\u2026|\\u2014|x|-|NA" ?text ) ) )

=>

( ?c.OBJECT setText nil )
( update ?c.OBJECT )
;;(printout t "RULE 2" crlf)
)



( defrule rule3
( declare (salience 200)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text & : ( regexp "(\\u2012|\\u2013|\\u2014|\\u2015|\\u002D|\\u2212|\\uFF0D)(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text ) ) )

=>

( bind ?s "-" )
( ?c.OBJECT setText ( call ?s concat ( ?text substring 1 )))
( update ?c.OBJECT )
;;(printout t "RULE 3" crlf)
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
;;( printout t "RULE 4 " ?c.text  " " ((?c.OBJECT getLabel)  isTerminal) crlf)
)




( defrule rule5
( declare (salience 170)
          ( no-loop TRUE )
          )

?c1 <- ( CCell { mark == "ColumnHeading" } (rb ?rb1) (cl ?cl1) (cr ?cr1))
;;?c2 <- ( CCell { mark == nil && rt > 1 && cl > 1 && blank == FALSE && rt == ( + ?rb1 1 ) && (( cl >= ?cl1 && cr < ?cr1 ) || ( cl > ?cl1  && cr <= ?cr1 )) } )
?c2 <- ( CCell { mark == nil && blank == FALSE } (rt ?rt2 & : ( and (> ?rt2 1) (= ?rt2 (+ ?rb1 1))))  (cl ?cl2 & : (> ?cl2 1) ) (cr ?cr2) )
;;( test ( or ( and (>= ?cl2 ?cl1) (< ?cr2 ?cr1)) ( and (> ?cl2 ?cl1) (<= ?cr2 ?cr1))))

=>
(if ( or ( and (>= ?cl2 ?cl1) (< ?cr2 ?cr1)) ( and (> ?cl2 ?cl1) (<= ?cr2 ?cr1))) then
( ?c2.OBJECT setMark "ColumnHeading" )
( ?c2.OBJECT newLabel )
((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
;;( update (?c1.OBJECT getLabel))
( update ?c2.OBJECT )
;;(printout t "RULE 5 " ?c2.text " " ((?c2.OBJECT getLabel) isTerminal) " " (((?c2.OBJECT getLabel) getParent ) isTerminal) crlf)
)
)




( defrule rule6
( declare (salience 150)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl == 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "RowHeading" )
( ?c.OBJECT newLabel )
( update ?c.OBJECT )
;;(printout t "RULE 6" crlf)
)




( defrule rule7
( declare (salience 150)
          ( no-loop TRUE ))

?c0 <- ( CCell { rt == 1 && cl == 1 && blank == FALSE } )
?c1 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil } (cl ?cl1) (text ?text & : ( not ( regexp "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text ))) )
?c2 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil && cl <= ?cl1 } )

=>

( ?c2.OBJECT setMark "RowHeading" )
( ?c2.OBJECT newLabel )
( update ?c2.OBJECT )
;;(printout t "RULE 7" crlf)
)




( defrule rule8
( declare (salience 140)
          ( no-loop TRUE ))

?c <- ( CCell { cl > 1 && rt > 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "DataCell" )
( ?c.OBJECT newEntry )
( update ?c.OBJECT )
;;(printout t "RULE 8" crlf)
)




( defrule rule9
( declare ( no-loop TRUE )
          ( salience 120 ))

?c <- ( CCell { cl == 1 && mark == "RowHeading" } ( text ?text & : ( eq (?text charAt 0) 45 ) ))

=>

( ?c.OBJECT setIndent 2 )
( update ?c.OBJECT )
;;(printout t "RULE 9" crlf)
)





( defrule rule10
( declare ( no-loop TRUE )
          ( salience 100 )
          )

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" } (rt ?rt1) (indent ?ind1) )
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > ?rt1 } (rt ?rt2) (indent ?ind2 & : ( = ?ind2 ( + ?ind1 2 ))) )
( not  ( CCell { cl == 1 && mark == "RowHeading" && indent == ind1 && rt > ?rt1 && rt < ?rt2 } ))

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel))
( update ?c2.OBJECT )
( update ?c1.OBJECT )
;;(printout t "RULE 10" crlf)
)




( defrule rule11
( declare (no-loop TRUE )
          ( salience 100 ))

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && indent == 0 } (rt ?rt1) (text ?text & : ( not ( regexp "(?i)(Total\\s*)|(I alt\\s*)|(All\\s*)" ?text ))))
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > ?rt1 && indent == 0 } (rt ?rt2) (style ?style)) ;; & : ((?style getFont) isNormal )))
( not ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && rt > ?rt1 && rt < ?rt2 && indent == 0 } ))

=>
(if ((?style getFont) isNormal ) then
((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
( update ?c2.OBJECT )
( update ?c1.OBJECT )
;;(printout t "RULE 11" crlf)
)
)





( defrule rule12
( declare (no-loop TRUE )
          ( salience 50 ))

?c <- ( CCell { mark == "ColumnHeading" } )

=>
((?c.OBJECT getLabel) setCategory "ColumnHeading" )
( update ?c.OBJECT )
;;(printout t "RULE 12" crlf)
)



( defrule rule13
( declare ( no-loop TRUE )
          ( salience 50 ))

?c1 <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } (cl ?cl1) )
?c2 <- ( CCell { mark == "RowHeading" && cl == ?cl1 } )

=>

;;( bind ?index ?cl1 )
((?c2.OBJECT getLabel) setCategory (str-cat "RowHeading" ?cl1))
( update ?c2.OBJECT )
;;(printout t "RULE 13" crlf)
)



( defrule rule14
( declare ( no-loop TRUE)
          ( salience 50 ))

?c1 <- ( CCell { rt == 1 && cl == 1 } )
?c2 <- ( CCell { mark == "RowHeading" && cl == 1 } )

=>

(( ?c2.OBJECT getLabel ) setCategory "RowHeading1" )
( update ?c2.OBJECT )
;;(printout t "RULE 14" crlf)
)





( defrule rule15
( declare (no-loop TRUE)
          ( salience 0 ))

?c1 <- ( CCell { mark == "ColumnHeading" } (cl ?cl1) ( label ?l)) ;;&:(neq ?label nil) ) )
;;( test ( eq ( ?l isTerminal ) TRUE ))
?c2 <- ( CCell { mark == "DataCell" && cl == c1.cl } ) ;;&:( = ?cl2 ?cl1)) )

=>
(if ( ?l isTerminal ) then
((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
( update ?c2.OBJECT )
;;(printout t "RULE 15 " (?c2.OBJECT getText) " " (?c1.OBJECT getText) " " ( eq ( ?l isTerminal ) TRUE ) crlf)
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
;;(printout t "RULE 16" crlf)
)