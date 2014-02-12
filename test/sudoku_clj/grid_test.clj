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

  (fact (first-empty-pos empty-grid) => [0 0])
  (fact (first-empty-pos puzzle) => [1 0])

  (fact (row puzzle 0) => [8 \_  2 \_ \_  9 \_ \_ 1])
  (fact (row puzzle 8) => [1 \_ \_  8 \_ \_  3 \_  9])

  (fact (column puzzle 0) => [8 \_ \_ 9 \_ \_ 2 \_ 1])
  (fact (column puzzle 8) => [1 \_ 3 \_ \_ 8 \_ \_ 9])

  (fact (box puzzle 0) => [8 \_ 2 \_ 3 \_ \_ \_ 6])
  (fact (box puzzle 8) => [7 \_ \_ \_ 2 \_ 3 \_ 9])

  (fact (count (rows puzzle)) => 9)
  (fact (count (columns puzzle)) => 9)
  (fact (count (boxes puzzle)) => 9)

  (fact (count (units puzzle)) => 27)
)

(facts "about setting values"
  (fact (lookup (setval puzzle [0 0] 5) [0 0]) => 5)
)

