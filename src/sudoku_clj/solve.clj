(ns sudoku-clj.solve)

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
