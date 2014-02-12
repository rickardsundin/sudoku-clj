(ns sudoku-clj.solve-test
  (:require [midje.sweet :refer [facts fact]]
            [sudoku-clj.solve :refer :all]
            [sudoku-clj.grid :refer [empty-grid]]))

(def puzzle
      [8 \_  2 \_ \_  9 \_ \_ 1
      \_  3 \_  1 \_ \_ \_  7 \_
      \_ \_  6 \_  2 \_  9 \_  3
       9 \_ \_  6 \_  5 \_  4 \_
      \_ \_  4 \_ \_ \_  5 \_ \_
      \_  5 \_  4 \_  7 \_ \_  8
       2 \_  8 \_  3 \_  7 \_ \_
      \_  6 \_ \_ \_  1 \_  2 \_
       1 \_ \_  8 \_ \_  3 \_  9 ])

(facts "about unit and grid validation"
  (fact (valid-unit? [\_ \_ \_ \_ \_ \_ \_ \_ \_ ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 8 9 ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 1 9]) => false)

  (fact (valid-grid? empty-grid) => true)
  (fact (valid-grid? puzzle) => true)
)
