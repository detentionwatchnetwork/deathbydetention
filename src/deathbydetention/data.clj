(ns deathbydetention.data)

(use 'clojure-csv.core)
(use 'deathbydetention.geocode)

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

(defn unique-locations
    [records]
    (distinct (map (fn [x] (get x 3)) records)))

(defn for-interval
    [f coll interval]
    (for [x coll]
        (do (Thread/sleep interval) (f x))))

(defn geocoded-location
    [address]
    {address {:geo (geocode address)}})

(defn generate-locations
    [records]
    ;; when geocoding the addresses we sleep for one second so google doens't
    ;; throttle us
    (into {} (for-interval geocoded-location (unique-locations records) 1000)))
