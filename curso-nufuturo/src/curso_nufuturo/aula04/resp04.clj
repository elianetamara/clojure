(ns curso-nufuturo.aula04.resp04)

(defn quadrados-pares-rec [lista]
  (let [head (first lista) tail (rest lista)]
    (if (empty? lista) '()
                       (if (even? head)
                         (cons (* head head) (quadrados-pares-rec tail))
                         (quadrados-pares-rec tail)))))

(assert (= (quadrados-pares-rec [1 2 3 4 5]) [4 16]))
(assert (= (quadrados-pares-rec [3]) []))
(assert (= (quadrados-pares-rec []) []))