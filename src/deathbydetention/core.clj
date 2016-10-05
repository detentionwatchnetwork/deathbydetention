(ns deathbydetention.core
    (:require [clojure.data.json :as json])
    (:gen-class))

(use 'deathbydetention.data)

(defn -main
  [& args]
  (let [deaths-data (mapcat identity (map parse-detention-csv args))]
    (println (json/write-str {:deaths deaths-data :locations (generate-locations deaths-data)}))))
