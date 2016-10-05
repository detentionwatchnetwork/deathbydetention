(ns deathbydetention.data)

(use 'clojure-csv.core)

(defn read-csv
    [path]
    (parse-csv (slurp (clojure.java.io/file path))))

(defn parse-record
    [record]
    record)

(defn parse-detention-csv
    "Every record has to be in the format:
    name, year, facility name, address, contractor. This function reads these
    records from a csv file and returns them mostly un altered except with some
    columns like state parsed and added."
    [path]
    (map parse-record (read-csv path)))

(defn generate-locations
    [records]
    {})
