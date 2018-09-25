(ns ajax-lib.http.warning-code)

(defn response-is-stale
  "Response is stale"
  []
  110)

(defn revalidation-failed
  "Revalidation failed"
  []
  111)

(defn disconnected-operation
  "Disconnected operation"
  []
  112)

(defn heuristic-expiration
  "Heuristic expiration"
  []
  113)

(defn miscellaneous-warning
  "Miscellaneous warning"
  []
  199)

(defn transformation-applied
  "Transformation applied"
  []
  214)

(defn miscellaneous-persistent-warning
  "Miscellaneous persistent warning"
  []
  299)

