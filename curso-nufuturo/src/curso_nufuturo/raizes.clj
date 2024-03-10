(ns curso-nufuturo.raizes)
(require '[clojure.math :as math])

(defn delta [a b c]
  (- (* b b) (* 4 a c)))

(defn raiz [b a raizd]
  (/ (+ (* b -1) raizd) (* 2 a)))

(defn raizes [a b c]
  (let [d (delta a b c) raizd (math/sqrt d)]
    (cond (= d 0) [(raiz b a raizd)]
          (> d 0) [(raiz b a raizd), (raiz b a (* -1 raizd))]
          :else (println "delta negativo"))))


(println (raizes (read) (read) (read)))
