;
;to run server:
;in one terminal:
; lein cljsbuild auto
;in a second terminal:
; lein repl
; (require '[personalplank.serv :as serv] )
; (serv/run!)
;then load localhost:8080
(ns personalplank.serv
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty]
            [personalplank.ui :as ui]
            [clojure.java.io :as io]))

(defonce repl-env (reset! cemerick.austin.repls/browser-repl-env
                          (cemerick.austin/repl-env)))

(defn page []
  (enlive/sniptest (slurp (io/resource "app.html"))
                   [:body] (enlive/append
                            (enlive/html [:script (browser-connected-repl-js)]))))
(defroutes site
  (resources "/")
  (GET "/login" req (ui/login login-form))
  (GET "/*" req (page)))

(defn run! []
  (defonce ^:private server
    (ring.adapter.jetty/run-jetty #'site {:port 8080 :join? false}))
  server)

(defn cljs! []
  (cemerick.austin.repls/cljs-repl repl-env))
