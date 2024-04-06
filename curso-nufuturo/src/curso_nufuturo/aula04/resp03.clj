(ns curso-nufuturo.aula04.resp03)

(defn quadrados-pares [lista]
  (map (fn [n] (* n n)) (filter even? lista)))

(assert (= (quadrados-pares [1 2 3 4 5]) [4 16]))
(assert (= (quadrados-pares [3]) []))
(assert (= (quadrados-pares []) []))