(ns deathbydetention.geocode
    (:require [clj-http.client :as client]))

(defn geocode-request
    [address]
    (client/get "https://maps.googleapis.com/maps/api/geocode/json"
        {:query-params {:address address} :as :json}))

(defn geocode
    "Uses the google geocoding API to get the lat/long for a address.
    Becareful with how many times you use this function since you can only
    make a certain number of requests per day."
    [address]
    (:location (:geometry (get (:results (:body (geocode-request address))) 0))))
