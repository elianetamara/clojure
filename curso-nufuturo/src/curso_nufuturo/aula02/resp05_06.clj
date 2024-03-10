(ns curso-nufuturo.aula02.resp05_06)

; q05
(defn conta []
  (doseq [a (range)]
    (println a)))

(comment
  ; q06
  (defn conta [stop]
    (doseq [a (range (+ stop 1))]
      (println a)))

  (conta (read)))
