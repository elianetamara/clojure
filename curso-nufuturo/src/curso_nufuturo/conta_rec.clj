(ns curso_nufuturo.conta_rec)

(defn conta-rec [num]
  (println num)
  (conta-rec (+ num 1)))

(def conta (conta-rec 0))

(conta)

; A função conta, sem parâmetros, serve apenas para chamar a conta-rec,
; função que contém a lógica recuriva para imprimir os números,
; passando como parâmetro o num que vai sendo atualizado na execução. Por
; não ter condição de parada, acontece um erro de stackOverFlow ao executar
