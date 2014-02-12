(ns sudoku-clj.grid)

(def empty-grid (vec (repeat 81 \_)))

(defn row
  "Get a row from sudoku grid"
  [grid rowidx]
  (let [startidx (* rowidx 9)]
  (subvec grid startidx (+ startidx 9))))
