(ns curso_nufuturo.aula03.resp02)

(defn length [s]
  (if (empty? s)
    0
    (+ 1 (length (rest s)))))

(assert (= (length [2 4 6 8]) 4))
(assert (= (length []) 0))
(assert (= (length [1 2]) 2))
(assert (= (length [2 3 66 87 54 23]) 6))

(defn value_at [seq i]
  (cond
    (= i 1) (first seq)
    (empty? seq) nil
    :else (value_at (rest seq) (- i 1))))

(assert (= (value_at [2 4 6 8] 1) 2))
(assert (= (value_at [2 3] 5) nil))
(assert (= (value_at [] 2) nil))
(assert (= (value_at [1 2] -2) nil))
(assert (= (value_at [2 3 66 87 54 23] 3) 66))

(defn index
  ([v sq i]
   (cond
     (empty? sq) -1
     (= v (first sq)) i
     :else (index v (rest sq) (inc i))))
  ([v sq]
   (index v sq 0)))

(assert (= (index 2 [1 5 2]) 2))
(assert (= (index 5 [1 4 3]) -1))
(assert (= (index 3 []) -1))
(assert (= (index 10 [10 2 5 15]) 0))
(assert (= (index 4 [1 2 3 4]) 3))
(assert (= (index 7 [3 4 5 6]) -1))