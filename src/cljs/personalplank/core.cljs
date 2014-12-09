(ns personalplank.core
  (:require [reagent.core :as r]))


(enable-console-print!)

(def app-state
  (r/atom
   {:users
    [{:name "joseph" :password "dreamcoat" }
     {:name "phantom" :password "opera" }]}))

(defn login [c] (print "login"))

(defn user [c]
  [:li
   [:span (:name c)]
   [:button {:on-click #(login c)} "Login"]])

(defn user-list []
  [:div
   [:h1 "User List"]
   [:ul
    (for [c (:users @app-state)]
      [user c])]])

;; Render the root component
(defn start []
  (r/render-component 
   [user-list]
   (.getElementById js/document "root")))
