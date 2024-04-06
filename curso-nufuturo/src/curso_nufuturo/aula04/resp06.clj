(ns curso-nufuturo.aula04.resp06)

(defn soma-quadrados [lista]
  (reduce + (map (fn [n] (* n n)) lista)))

(assert (= (soma-quadrados [1 2 3 4 5]) 55))
(assert (= (soma-quadrados [3]) 9))
(assert (= (soma-quadrados []) 0))