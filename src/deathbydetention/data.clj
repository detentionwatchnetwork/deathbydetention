(ns deathbydetention.data)

(use 'clojure-csv.core)

(defn read-csv
    [path]
    (parse-csv (slurp (clojure.java.io/file path))))

(defn parse-location-address-state
    "Every location address should be in the format <address>, <state> <zipcode>"
    [location-address]
    (nth (reverse (clojure.string/split location-address #" ")) 1))

(defn parse-record
    [record]
    (conj record (parse-location-address-state (get record 3))))

(defn parse-detention-csv
    "Every record has to be in the format:
    name, year, facility name, address, contractor. This function reads these
    records from a csv file and returns them mostly un altered except with some
    columns like state parsed and added."
    [path]
    (map parse-record (read-csv path)))
