(ns nimmt-clara.core
  (:require
   [clara.rules.accumulators :as acc]
   [clara.rules :refer :all])
  )

(use 'nimmt-clara.game
     )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]


  (println "begin session")
  (def sess (-> (mk-session 'nimmt-clara.game :cache false)
                (insert (->Card 54)
                        (->Card 20)
                        (->Card 55)
                        (->Card 44)
                        (->Card 19)
                        (->Card 11)
                        (->Card 45)
                        )
                (fire-rules)
                )
    )
  (println (query sess get-card-score :?number 55 ))
  (println (query sess get-card-score :?number 19))
  (println (query sess get-card-score :?number 11))
  (println (query sess get-card-score :?number 44))
  (println (query sess get-card-score :?number 20))
  (println (query sess get-card-score :?number 45))
  )
