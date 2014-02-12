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

(defn- box-row-index
  "Get row index for index in box"
  [boxidx idx]
  (+ (* 3 (mod boxidx 3)) (mod idx 3)))

(defn- box-col-index
  "Get column index for index in box"
  [boxidx idx]
  (+ (* 3 (quot boxidx 3)) (quot idx 3)))

(defn- boxpos
  "Get box positions for box index"
  [boxidx idx]
  (vec [(box-row-index boxidx idx)
        (box-col-index boxidx idx)]))

(defn box
  "Get a box from grid"
  [grid boxidx]
  (vec (map #(lookup grid (boxpos boxidx %)) (range 9))))
