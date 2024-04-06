(ns curso-nufuturo.aula04.resp02)

(defn quadrados-rec-aux [lista res]
  (let [head (first lista) tail (rest lista)
        quadrado (cons (* head head) res)]

    (if (empty? tail) quadrado (quadrados-rec-aux tail quadrado))))

(defn quadrados-rec [lista]
  (if (empty? lista) '() (reverse (quadrados-rec-aux lista '()))))

(assert (= (quadrados-rec [1 2 3 4 5]) [1 4 9 16 25]))
(assert (= (quadrados-rec [3]) [9]))
(assert (= (quadrados-rec []) []))