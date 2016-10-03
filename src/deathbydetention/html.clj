(ns deathbydetention.html)

(use 'selmer.parser)

(defn index
    [context]
    (render-file "index.html" context))
