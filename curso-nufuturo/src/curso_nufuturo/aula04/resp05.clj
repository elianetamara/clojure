(ns curso-nufuturo.aula04.resp05)

(defn soma-quadrados [lista]
  (let [lista-quadrado (map (fn [n] (* n n)) lista)]
    (apply + lista-quadrado)))

(assert (= (soma-quadrados [1 2 3 4 5]) 55))
(assert (= (soma-quadrados [3]) 9))
(assert (= (soma-quadrados []) 0))