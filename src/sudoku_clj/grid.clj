(ns sudoku-clj.grid)

(def empty-grid (vec (repeat 81 \_)))

(defn- idx
  "Translate position coordinates to grid index"
  [pos]
  (let [[col row] pos]
    (+ col (* row 9))))

(defn- lookup
  "Get value on position in grid"
  [grid pos]
  (get grid (idx pos)))

(defn row
  "Get a row from sudoku grid"
  [grid rowidx]
  (let [startidx (* rowidx 9)]
  (subvec grid startidx (+ startidx 9))))

(defn column
  "Get a column from sudoku grid"
  [grid colidx]
  (vec (map #(lookup grid [colidx %]) (range 9))))
