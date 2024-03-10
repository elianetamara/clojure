(ns curso-nufuturo.aula02.msg_rec)
(defn msg-rec [msg]
  (println msg)
  (msg-rec msg))

(msg-rec (read))

; Execution error (StackOverflowError) at java.nio.CharBuffer/limit (CharBuffer.java:1107).
;null
;Full report at:
;/tmp/clojure-4857155661026683829.edn
; -> erro ocasionado pela função recursiva não ter uma condição de parada,
; estourando a memória da pilha de execução do programa