(ns personalplank.pages.login
  (:require [reagent.core :as r]))

(enable-console-print!)

(defn login-form []
  [:div {:class "row"}
   [:div {:class "col col-lg-12"}
    [:form {:method "POST" :action "login"}
     [:div "Email:" [:input {:type "text" :name "email"}]]
     [:div "Password:" [:input {:type "password" :name "password"}]]
     [:div [:input {:type "submit" :class "btn btn-primary btn-lg" :value "Log In"}]]]]])

(defn start []
  (r/render-component 
    [login-form]
    (.getElementById js/document "root")))

