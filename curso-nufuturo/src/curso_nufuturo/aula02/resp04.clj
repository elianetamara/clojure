(ns curso-nufuturo.aula02.resp04)

(defn conta []
  (loop [i 0]
      (println i)
      (recur (inc i))))

(conta)

; essas formas especiais são projetadas pra evitar o
; stack overflow em iterações recursivas, usando a "tail call optimization"