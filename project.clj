(defproject personalplank "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :source-paths ["src/clj" "src/cljs"]
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [liberator "0.12.2"]
                 [org.clojure/clojurescript "0.0-2411"]
                 [ring "1.2.2"]
                 [compojure "1.1.6"]
                 [cljs-ajax "0.3.0"]
                 [enlive "1.1.5"]
                 [clojurewerkz/titanium "1.0.0-beta2"]
                 [com.cemerick/friend "0.2.1"]
                 [reagent "0.4.3"] ]
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/austin "0.1.5"]
            [lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.11"]]   :ring {:handler personalplank/handler}
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/generated/app.js"
                                   :optimizations :whitespace
                                   :preamble ["reagent/react.js"]
                                   :pretty-print true}}]})
