(ns curso-nufuturo.eh_bissexto)

(defn eh_bissexto [ano]
      (let [div400 (= (mod ano 400) 0)
            div4not100 (and (= (mod ano 4) 0) (not= (mod ano 100) 0))]
           (if (or div400 div4not100)
             (println "bissexto")
             (println "nao eh bissexto"))))

(println (eh_bissexto (read)))