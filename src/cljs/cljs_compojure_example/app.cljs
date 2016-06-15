(ns cljs-compojure-example.app
  (:require [cljs-compojure-example.greet :as greet]))

(greet/say-hello)

(.log js/console "Hello cljs from app.cljs")
