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

(def solved-puzzle
  [8 7 2 3 6 9 4 5 1
   4 3 9 1 5 8 6 7 2
   5 1 6 7 2 4 9 8 3
   9 2 3 6 8 5 1 4 7
   7 8 4 2 1 3 5 9 6
   6 5 1 4 9 7 2 3 8
   2 9 8 5 3 6 7 1 4
   3 6 7 9 4 1 8 2 5
   1 4 5 8 7 2 3 6 9])

(facts "about unit and grid validation"
  (fact (valid-unit? [\_ \_ \_ \_ \_ \_ \_ \_ \_ ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 8 9 ]) => true)
  (fact (valid-unit? [1 2 3 4 5 6 7 1 9]) => false)

  (fact (valid-grid? empty-grid) => true)
  (fact (valid-grid? puzzle) => true)
)

(facts "about sudoku solving"
  (fact (count (fill-first-empty empty-grid)) => 9)

  (fact (count (solve-one-step puzzle)) => 2)

  (fact (solved? empty-grid) => false)
  (fact (solved? puzzle) => false)
  (fact (solved? solved-puzzle) => true)
)

