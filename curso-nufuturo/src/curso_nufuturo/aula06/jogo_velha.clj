(ns curso_nufuturo.aula06.jogo-velha
  (:require [clojure.string :as str]))

(defn initialize-tabuleiro []
  (vec (repeat 3 (vec (repeat 3 \space)))))

(defn initialize-jogo []
  {:tabuleiro (initialize-tabuleiro)
   :jogadores ['X' 'O']
   :jogador-atual 0
   :vitorias {'X' 0, 'O' 0}
   :empates 0})

(defn println-tabuleiro [tabuleiro]
  (doseq [row tabuleiro]
    (println (str/join " | " row))
    (println (apply str (repeat 10 "-")))))

(defn verifica-ganhador [tabuleiro]
  (let [linhas tabuleiro
        colunas (apply map vector tabuleiro)
        diagonais [[(get tabuleiro 0 0) (get tabuleiro 1 1) (get tabuleiro 2 2)]
                   [(get tabuleiro 0 2) (get tabuleiro 1 1) (get tabuleiro 2 0)]]
        todas-possibilidades (concat linhas colunas diagonais)]
    (defn linha-vencedora? [linha]
      (every? #(= (first linha) %) linha))
    (some #(if (linha-vencedora? %) (first %)) todas-possibilidades)))

(defn is-tabuleiro-cheio [tabuleiro]
  (not-any? #{\space} (apply concat tabuleiro)))

(defn update-tabuleiro [tabuleiro jogador posicao]
  (let [row (first posicao)
        col (second posicao)]
    (if (= (get-in tabuleiro [row col]) \space)
      (assoc-in tabuleiro [row col] jogador)
      tabuleiro)))

(defn jogar-novamente []
  (let [novamente (-> (str/upper-case (str/trim (read-line)))
                      first)]
    (if (#{\S \N} novamente)
      (= novamente \S)
      (do (println "Opção inválida, escolha 'S' para sim ou 'N' para não.")
          (jogar-novamente)))))

(defn entrada-valida [mensagem]
  (println mensagem)
  (loop []
    (let [entrada (read-line)]
      (if (re-matches #"\d+" entrada)
        (let [valor (Integer/parseInt entrada)]
          (if (and (>= valor 0) (<= valor 2))
            valor
            (do (println "Por favor, digite um número entre 0 e 2.")
                (recur))))
        (do (println "Por favor, digite um número válido.")
            (recur))))))

(comment(defn game []
          (let [game-data (initialize-jogo)]
            (loop []
              (println-tabuleiro (:tabuleiro game-data))

              (let [winner (verifica-ganhador (:tabuleiro game-data))]
                (when winner
                  (println (str "O jogador " winner " ganhou!"))
                  (update-in game-data [:vitorias winner] inc)
                  (when (jogar-novamente)
                    (assoc game-data :tabuleiro (initialize-tabuleiro)))))

              (when (is-tabuleiro-cheio (:tabuleiro game-data))
                (println "Empate!")
                (update game-data :empates inc)
                (when (jogar-novamente)
                  (assoc game-data :tabuleiro (initialize-tabuleiro))))

              (let [jogador-atual (nth (:jogadores game-data) (:jogador-atual game-data))]
                (println (str "Vez do jogador " jogador-atual))
                (let [row (entrada-valida "Digite o número da linha (0-2): ")
                      col (entrada-valida "Digite o número da coluna (0-2): ")]
                  (when (= (get-in (:tabuleiro game-data) [row col]) \ )
                    (update game-data :tabuleiro #(update-tabuleiro % jogador-atual [row col]))
                    (update game-data :jogador-atual #(mod (inc %) 2)))
                  (println "Posição ocupada. Tente novamente."))))
            (recur)

            (println (str "Placar geral: Jogador X - " (:vitorias (initialize-jogo)) \X ", Jogador O - " (:vitorias (initialize-jogo)) \O ", Empates - " (:empates (initialize-jogo)))))))

(comment(game))