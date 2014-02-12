(ns sudoku-clj.grid-test
  (:require [midje.sweet :refer [facts fact]]
            [sudoku-clj.grid :refer :all]))

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

(facts "about Sudoku grid"
  (fact (count empty-grid) => 81)

  (fact (row puzzle 0) => [8 \_  2 \_ \_  9 \_ \_ 1])
  (fact (row puzzle 8) => [1 \_ \_  8 \_ \_  3 \_  9])

  (fact (column puzzle 0) => [8 \_ \_ 9 \_ \_ 2 \_ 1])
  (fact (column puzzle 8) => [1 \_ 3 \_ \_ 8 \_ \_ 9])
)

