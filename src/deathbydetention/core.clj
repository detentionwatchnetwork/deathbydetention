(ns deathbydetention.core
    (:require [clojure.data.json :as json])
    (:gen-class))

(use 'deathbydetention.html)
(use 'deathbydetention.data)

(defn -main
  [& args]
  (println (json/write-str (transform-records (into [] (concat (map parse-detention-csv args)))))))
