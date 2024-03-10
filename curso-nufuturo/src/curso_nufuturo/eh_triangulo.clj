(ns curso-nufuturo.eh_triangulo)

(defn eh_triangulo [a b c]
      (let [bc (< a (+ b c)) ac (< b (+ a c)) ab (< c (+ a b))]
           (if (and bc ac ab))
           (println "triangulo valido")
           (println "triangulo nao eh valido")))