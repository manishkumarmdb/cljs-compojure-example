(ns cljs-compojure-example.core
  (:require [reagent.core :as reagent :refer [atom]]
            ;;[cljs-compojure-example.greet :as greet]
            ))

(enable-console-print!)

(println "This text is printed from src/cljs-compojure-example/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world! from core.cljs"}))

(defn hello-world []
  [:h3 (:text @app-state)])

;;(greet/say-hello)

(.log js/console "Hello cljs-compojure from core.cljs")

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
