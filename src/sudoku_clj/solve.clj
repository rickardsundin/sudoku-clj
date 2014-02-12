(ns sudoku-clj.solve
  (:require [sudoku-clj.grid :refer [units first-empty]]))

(defn- duplicates
  "Extract a seq of all duplicate values"
  [seq]
  (for [[id freq] (frequencies seq)
        :when (> freq 1)]
   id))

(defn valid-unit?
  "Return true if the provided sudoku unit (row, column or subgrid) does not contain any duplicate numbers"
  [unit]
  (empty? (duplicates (filter number? unit))))

(defn valid-grid?
  "Return true if the provided sudoku grid is valid"
  [grid]
  (every? valid-unit? (units grid)))

(defn solved?
  [puzzle]
  (and (valid-grid? puzzle) (not (some #{\_} puzzle))))

(defn fill-first-empty
  [puzzle]
  (let [idx (first-empty puzzle)]
  (map #(assoc puzzle idx %) (range 1 10))))

(defn solve-one-step
  [puzzle]
  (filter valid-grid? (fill-first-empty puzzle)))

(defn solve
  [puzzle]
  (loop [[p & ps] (cons puzzle ())]
    (if (solved? p)
      p
      (recur (concat (solve-one-step p) ps)))))
