(ns curso-nufuturo.aula02.resp02-03)

; q02
(defn conta-rec [num]
  (println num)
  (conta-rec (+ num 1)))

(defn conta [] (conta-rec 0))

(conta)

; A função conta, sem parâmetros, serve apenas para chamar a conta-rec,
; função que contém a lógica recuriva para imprimir os números,
; passando como parâmetro o num que vai sendo atualizado na execução. Por
; não ter condição de parada, acontece um erro de stackOverFlow ao executar

(comment
  ; função com diferentes aridades - q03
  (defn conta
    ([] (conta 0))
    ([num]
     (println num)
     (conta (+ num 1))))

  (println (conta 10))
  (println (conta)))
