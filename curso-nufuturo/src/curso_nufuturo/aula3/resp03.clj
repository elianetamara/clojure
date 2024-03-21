(ns curso_nufuturo.aula3.resp03)

(defn somador [operador]
  (fn processo [seq]
    (if (empty? seq)
      0
      (+ (operador (first seq)) (processo (rest seq))))))

(def soma-cubos (somador (fn [n] (* n n n))))
(def soma-dobros (somador (fn [n] (* n 2))))
(def soma-triplos (somador (fn [n] (* n 3))))

(def soma (somador (fn [n] n)))
(def conta (somador (fn [n] (+ 1))))

(assert (= (soma-cubos [1 2 3 4]) 100))
(assert (= (soma-cubos [2 3 4 5]) 224))

(assert (= (soma-dobros [1 2 3 4]) 20))
(assert (= (soma-dobros [2 3 4 5]) 28))

(assert (= (soma-triplos [1 2 3 4]) 30))
(assert (= (soma-triplos [2 3 4 5]) 42))

(assert (= (soma [2 3 4 5]) 14))
(assert (= (conta [2 3 4 5]) 4))