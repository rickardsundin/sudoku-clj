(ns sudoku-clj.grid-test
  (:require [midje.sweet :refer [facts fact]]
            [sudoku-clj.grid :refer :all]))

(facts "about Sudoku grid"
  (fact (count empty-grid) => 81)
)
