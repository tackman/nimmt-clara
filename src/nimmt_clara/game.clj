(ns nimmt-clara.game
  (:gen-class)
  (:require [clara.rules.accumulators :as acc]
            [clara.rules :refer :all]
            )
  )


(defrecord Chain [cards])
(defrecord Card [number])
(defrecord CardScore [number score])

(defrule score-of-card-55
  "score of card, number is 55"
  [?card <- Card (= number 55)]
  =>
  (println  "case 55" (:number ?card) )
  (insert! (->CardScore (:number ?card) 7))
  )

(defrule placeholder
  ""
  [?card <- Card (not (= number 55)) (= number 19)]
  =>
  (println "case any " (:number ?card)))




(defrule score-of-cared-repdigit
  "score of card number is repdigit"
  [?card <- Card (not (= number 55)) (= (mod number 10) (quot number 10))]
  =>
  (println "case repdigit "  (:number ?card) )
  (insert! (->CardScore (:number ?card) 5)))

(defrule score-of-card-10n
  "score of card, number is 10n"
  [?card <- Card (not (= number 55)) (not (= (mod number 10) (quot number 10))) (= 0 (mod number 10)) ]
  =>
  (println  "case 10n "  (:number ?card) )
  (insert! (->CardScore (:number ?card) 3)))

(defrule score-of-card-5n
  "score of card, number is 5n"
  [?card <- Card (not (= number 55)) (not (= (mod number 10) (quot number 10))) (not (= 0 (mod number 10))) (= 0 (mod number 5))]
  =>
  (println "case 5n"  (:number ?card) )
  (insert! (->CardScore (:number ?card) 2))
  )

(defrule score-of-card-else
  "score of card, number is 5n"
  [?card <- Card (not (= number 55)) (not (= (mod number 10) (quot number 10))) (not (= 0 (mod number 10))) (not (= 0 (mod number 5)))]
  =>
  (println "case other number " (:number ?card) )
  (insert! (->CardScore (:number ?card) 1))
  )


(defquery get-card-score
  "query score of number"
  [:?number]
  [?cardScore <- CardScore (= ?number number)])
