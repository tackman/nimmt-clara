(ns nimmt-clara.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (foo "clara"))
