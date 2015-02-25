(ns clj-ml.cli-validators)

(defn file-validator
  [argument]
  [#(.isFile %) (format "%s must be a valid path to a file in the filesystem" argument)])

(defn >0-validator 
  [argument]
  [#(> % 0) (format "%s must be greater then 0" argument)])
    

