(ns cljs-compojure-example.greet
  (:require [ajax.core :refer [GET POST]]
            [dommy.core :as dommy :refer-macros [sel sel1]]))

(defn handler [response]
  (.log js/console "server responded....")
  (-> (sel1 :.fromServer)
      (dommy/set-text!
       (str "Hello " (aget (clj->js response) "greeting")))))

(defn error-handler [{:keys [status-text]}]
  (.log js/console (str "something happened : bad " status " " status-text)))

(defn say-hello []
  (POST "/hello"
        {:params {:user "from Server!"}
         :handler handler
         :error-handler error-handler
         :format :json
         :response-format :json}))
