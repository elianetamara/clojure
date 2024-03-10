(ns curso-nufuturo.aula01.tipo_triangulo)

(defn equilatero [a b c]
      (if (= a b c) true false))

(defn isosceles [a b c]
      (if (or (= a b) (= a c) (= b c))
        true false))

(defn escaleno [a b c]
      (if (not= a b c) true false))

(defn tipo_triangulo [a b c]
      (cond (equilatero a b c) :equilatero
            (isosceles a b c) :isosceles
            (escaleno a b c) :escaleno
            :else nil))
(println (tipo_triangulo (read) (read) (read)))