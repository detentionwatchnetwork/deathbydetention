(defproject deathbydetention "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [selmer "1.0.9"]
    [clj-http "3.3.0"]
    [org.clojure/data.json "0.2.6"]
    [clojure-csv/clojure-csv "2.0.1"]]
  :main ^:skip-aot deathbydetention.core
  :target-path "target/%s"
  :resource-paths ["html"]
  :profiles {:uberjar {:aot :all}})
