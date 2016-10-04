(ns deathbydetention.core
  (:gen-class))

(use 'deathbydetention.html)

(defn -main
  [& args]
  (println (index {:name "Wil"})))
