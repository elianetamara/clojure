(ns curso_nufuturo.conta_rec_a)

(defn conta
  ([] (conta 0))
  ([num]
   (println num)
   (conta (+ num 1))))

(println (conta 10))
(println (conta))