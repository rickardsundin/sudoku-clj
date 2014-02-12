(ns sudoku-clj.solve-test
  (:require [midje.sweet :refer [facts fact]]
            [sudoku-clj.solve :refer :all]))

(facts "about unit and grid validation"
  (fact (valid-unit? [\_ \_ \_ \_ \_ \_ \_ \_ \_ ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 8 9 ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 1 9]) => false)
)
