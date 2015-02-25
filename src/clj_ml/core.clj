(ns clj-ml.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.java.io :as io])
  (:gen-class))

(def cli-opts [["-h" "--help" "prints this help message and exit"]
               ["-d" 
                "--data PATH" 
                "path to file containing data"
                :parse-fn io/file
                :validate [#(.isFile %) "-d/--data must be a valid path to a file in the filesystem"]]])


(defn usage
  [msg summary]
  (println msg)
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
    (let [{:keys [data help]} options
          [algrithm & _] arguments]
      (when help
        (usage "Machine Learning Framework: Usage instructions" summary)
        (System/exit -1))
      (println algrithm)
      (println data))))

