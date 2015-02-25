(defproject clj-ml "0.1.1"
  :description "Machine learning library"
  :url "https://github.com/jopela/clj-ml"
  :license {:name "Eclipse Public License"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [cheshire "5.4.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [net.mikera/vectorz-clj "0.29.0"]
                 [incanter/incanter-core "1.9.0"]
                 [net.mikera/core.matrix "0.33.2"]]
  :main ^:skip-aot clj-ml.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
