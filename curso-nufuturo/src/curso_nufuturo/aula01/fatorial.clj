(ns curso-nufuturo.aula01.fatorial)

(defn fat [n]
      (if (= n 1)
          1
          (* n (fat (- n 1N)))))
