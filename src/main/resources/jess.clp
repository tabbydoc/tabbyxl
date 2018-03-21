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
( declare (salience 160)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } (text ?text & : ( regexp "#|s" ?text )))

=>

( ?c.OBJECT setText "0" )
( modify ?c ( text (?c.OBJECT getText )))
)



( defrule rule2
( declare (salience 150)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text & : ( regexp "F|\\.|\\.{2}+|\\.{3}+|\\u2026|\\u2014|x|-|NA" ?text ) ) )

=>

( ?c.OBJECT setText nil )
( modify ?c ( text (?c.OBJECT getText) ) )
)



( defrule rule3
( declare (salience 140)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl > 1 && blank == FALSE } ( text ?text & : ( regexp "(\\u2012|\\u2013|\\u2014|\\u2015|\\u002D|\\u2212|\\uFF0D)(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text ) ) )

=>

( bind ?s "-" )
( ?c.OBJECT setText ( call ?s concat ( ?text substring 1 )))
( modify ?c ( text ( ?c.OBJECT getText )))
)


( defmodule SetMarkModule
( declare (auto-focus TRUE))
)

( defrule rule4
( declare (salience 130)
          ( no-loop TRUE )
          )

?c <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } )

=>

( ?c.OBJECT setMark "ColumnHeading" )
( ?c.OBJECT newLabel )
( modify ?c ( mark "ColumnHeading"))
)




( defrule rule5
( declare (salience 120)
          ( no-loop TRUE )
          )

?c1 <- ( CCell { mark == "ColumnHeading" } (rb ?rb1) (cl ?cl1) (cr ?cr1))
?c2 <- ( CCell { mark == nil && rt > 1 && cl > 1 && blank == FALSE && rt == ( + ?rb1 1 ) && (( cl >= ?cl1 && cr < ?cr1 ) || ( cl > ?cl1  && cr <= ?cr1 )) } )

=>

( ?c2.OBJECT setMark "ColumnHeading" )
( ?c2.OBJECT newLabel )
;;((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
( modify ?c2 ( mark "ColumnHeading" ))
)



( defmodule Module2
( declare (auto-focus TRUE))
)

( defrule rule6
( declare (salience 110)
          ( no-loop TRUE ))

?c <- ( CCell { rt > 1 && cl == 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "RowHeading" )
( ?c.OBJECT newLabel )
( modify ?c ( mark "RowHeading" ))
)




( defrule rule7
( declare (salience 100)
          ( no-loop TRUE ))

?c0 <- ( CCell { rt == 1 && cl == 1 && blank == FALSE } )
?c1 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil } (cl ?cl1) (text ?text & : ( not ( regexp "(-|\\+|\\$)?(\\d+(\\s|\\.|,)?\\d*)+(E|%|\\*)?" ?text ))) )
?c2 <- ( CCell { rt > 1 && cl > 1 && blank == FALSE && mark == nil && cl <= ?cl1 } )

=>

( ?c2.OBJECT setMark "RowHeading" )
( ?c2.OBJECT newLabel )
( modify ?c2 ( mark "RowHeading"))
;;( modify ?c2 ( label (?c2.OBJECT getLabel)))
;;( modify ?c2 (labelIsTerminalFlag ((?c2.OBJECT getLabel) isTerminal)))
)




( defrule rule8
( declare (salience 90)
          ( no-loop TRUE ))

?c <- ( CCell { cl > 1 && rt > 1 && blank == FALSE && mark == nil } )

=>

( ?c.OBJECT setMark "DataCell" )
( ?c.OBJECT newEntry )
( modify ?c ( mark "DataCell"))
)




( defrule rule9
( declare ( no-loop TRUE )
          ( salience 80 ))

?c <- ( CCell { cl == 1 && mark == "RowHeading" } ( text ?text & : ( eq (?text charAt 0) 45 ) ))

=>

( ?c.OBJECT setIndent 2 )
( modify ?c (indent (?c.OBJECT getIndent)))
)



( defmodule Module3
( declare (auto-focus TRUE))
)

( defrule rule5b
( declare (salience 70)
          ( no-loop TRUE )
          )

?c1 <- ( CCell { mark == "ColumnHeading" } (rb ?rb1) (cl ?cl1) (cr ?cr1))
?c2 <- ( CCell { mark == "ColumnHeading" && rt > 1 && cl > 1 && blank == FALSE && rt == ( + ?rb1 1 ) && (( cl >= ?cl1 && cr < ?cr1 ) || ( cl > ?cl1  && cr <= ?cr1 )) } )

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
)

( defrule rule10
( declare ( no-loop TRUE )
          ( salience 70 )
          )

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" } (rt ?rt1) (indent ?ind1) )
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > ?rt1 } (rt ?rt2) (indent ?ind2 & : ( = ?ind2 ( + ?ind1 2 ))) )
( not  ( CCell { cl == 1 && mark == "RowHeading" && indent == ind1 && rt > ?rt1 && rt < ?rt2 } ))

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel))
)



;;( defmodule rule11module
;;( declare (auto-focus TRUE))
;;)

( defrule rule11
( declare (no-loop TRUE )
          ( salience 60 ))

?c1 <- ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && indent == 0 } (rt ?rt1) (text ?text & : ( not ( regexp "(?i)(Total\\s*)|(I alt\\s*)|(All\\s*)" ?text ))))
?c2 <- ( CCell { cl == 1 && mark == "RowHeading" && rt > ?rt1 && indent == 0 } (rt ?rt2) (style ?style & : ((?style getFont) isNormal )))
( not ( CCell { cl == 1 && mark == "RowHeading" && boldFlag == TRUE && rt > ?rt1 && rt < ?rt2 && indent == 0 } ))

=>

((?c2.OBJECT getLabel) setParent (?c1.OBJECT getLabel) )
)




( defmodule rule12module
( declare (auto-focus TRUE))
)

( defrule rule12
( declare (no-loop TRUE )
          ( salience 50 ))

?c <- ( CCell { mark == "ColumnHeading" } )

=>
((?c.OBJECT getLabel) setCategory "ColumnHeading" )
)



( defrule rule13
( declare ( no-loop TRUE )
          ( salience 40 ))

?c1 <- ( CCell { rt == 1 && cl > 1 && blank == FALSE } (cl ?cl1) )
?c2 <- ( CCell { mark == "RowHeading" && cl == ?cl1 } )

=>

;;( bind ?index ?cl1 )
((?c2.OBJECT getLabel) setCategory (str-cat "RowHeading" ?cl1))
)



( defrule rule14
( declare ( no-loop TRUE)
          ( salience 30 ))

?c1 <- ( CCell { rt == 1 && cl == 1 } )
?c2 <- ( CCell { mark == "RowHeading" && cl == 1 } )

=>

(( ?c2.OBJECT getLabel ) setCategory "RowHeading1" )
)





( defmodule rule15module
( declare (auto-focus TRUE))
)

( defrule rule15
( declare (no-loop TRUE)
          ( salience 0 ))

?c1 <- ( CCell { mark == "ColumnHeading" } (cl ?cl1) ( OBJECT ?obj & : ((?obj getLabel) isTerminal)) )
?c2 <- ( CCell { mark == "DataCell" && cl == ?cl1 } )

=>
;;(printout t "AAAAAAAAAAAAAAAAAAAAAAAAAAA" crlf)
((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
)





( defrule rule16
( declare (no-loop TRUE)
          ( salience 0 ))

?c1 <- ( CCell { mark == "RowHeading" } (rt ?rt1) )
?c2 <- ( CCell { mark == "DataCell" && rt == ?rt1 } )

=>

((?c2.OBJECT getEntry) addLabel (?c1.OBJECT getLabel) )
)