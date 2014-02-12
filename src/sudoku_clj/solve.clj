(ns sudoku-clj.solve
  (:require [sudoku-clj.grid :refer [units first-empty]]))

(defn- duplicates
  "Extract a seq of all duplicate values"
  [seq]
  (for [[id freq] (frequencies seq)
        :when (> freq 1)]
   id))

(defn valid-unit?
  "Return true if the provided sudoku unit (row, column or subgrid)
  does not contain any duplicate numbers"
  [unit]
  (empty? (duplicates (filter number? unit))))

(defn valid-puzzle?
  "Return true if the provided sudoku puzzle is valid"
  [grid]
  (every? valid-unit? (units grid)))

(defn solved?
  "Return true if the puzzle is valid and has no empty fields"
  [puzzle]
  (and (valid-puzzle? puzzle) (not (some #{\_} puzzle))))

(defn fill-first-empty
  "Given a puzzle, find the first empty field and return 9
  puzzles where that field has been filled with values 1-9"
  [puzzle]
  (let [idx (first-empty puzzle)]
  (map #(assoc puzzle idx %) (range 1 10))))

(defn solve-one-step
  "Given a sudoku puzzle, return a seq of all valid puzzles
  where the first empty field has been given a value."
  [puzzle]
  (filter valid-puzzle? (fill-first-empty puzzle)))

(defn solve
  "Solve a sudoku puzzle"
  [puzzle]
  (loop [[p & ps] (cons puzzle ())]
    (if (solved? p)
      p
      (recur (concat (solve-one-step p) ps)))))
