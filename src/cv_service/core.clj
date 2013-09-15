(ns cv_service.core
  (:gen-class :main true)
  (:use compojure.core
        ring.middleware.json
        ring.util.response
        ring.adapter.jetty)
  (:require [compojure.route :as route]
            [cv_service.me :as me]))

(defmacro bench [expr]
  `(let [start# (System/nanoTime)
         ret# ~expr]
     (prn
       (str
         "Elapsed time for "
         '(~expr) ": "
         (/ (double (- (System/nanoTime) start#)) 1000000.0)
         " msec"))
     ret#))

(defroutes my_routes
  (GET "/me/birth" [] (bench (response (:birth me/me))))
  (GET "/me" [] (bench (response me/me)))
  (route/resources "/"))

(def app (wrap-json-response my_routes))

(defn -main [& args] (run-jetty app {:port 9001}))