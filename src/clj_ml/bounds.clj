(ns clj-ml.bounds
  (:require [clojure.math.numeric-tower :as math]))

(defn hoeffding-error-term
  ([M N delta]
   (let [a (/ 1 (* 2 N))
         b (Math/log (/ (* 2 M) delta))]
     (math/sqrt (* a b))))
  ([N delta]
   (hoeffding-error-term 1 N delta)))

(defn epsilon=
  [epsilon a b]
  (< (math/abs (- a b)) epsilon))

