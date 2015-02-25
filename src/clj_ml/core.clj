(ns clj-ml.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.java.io :as io]
            [clojure.string :as s]
            [clj-ml.cli-validators :as validators])
  (:gen-class))

(def cli-opts [["-h" "--help" "prints this help message and exit"]
               ["-d" 
                "--data PATH" 
                "path to file containing data"
                :parse-fn io/file
                :validate (validators/file-validator "-d/--data")]
               ["-p" 
                "--params PATH" 
                "path to fle containing the final model params result"
                :parse-fn io/file]
               ["-l" 
                "--learning-rate RATE"
                "learning rate of the SGD algorithm (often written eta)"
                :parse-fn #(Double/parseDouble %)
                :validate (validators/>0-validator "-l/--learning-rate")]])

(def algorithms #{"logistic-regression" "linear-regression" "artificial-neural-network"})

(defn usage
  [msg summary]
  (println msg)
  (println (format "available algorithms: %s" (s/join "," algorithms)))
  (println summary))

(defn -main
  "Machine Learning Framework"
  [& args]
  (let [{:keys [arguments options errors summary]} (parse-opts args cli-opts)]
    (when errors
      (doseq [e errors]
        (println e))
      (usage "See usage instruction below" summary)
      (System/exit -1))
    (let [{:keys [data params learning-rate help]} options
          [algorithm & _] arguments]
      (when help
        (usage "Machine Learning Framework: Usage instructions" summary)
        (System/exit -1))
      (when-not (algorithms algorithm)
        (usage "unrecognized algorithm" summary)
        (System/exit -2))
      (println algorithm)
      (println options))))
