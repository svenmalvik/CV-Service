(ns cv_service.core
  (:gen-class :main true)
  (:use compojure.core
        ring.middleware.json
        ring.util.response
        ring.adapter.jetty)
  (:require [compojure.route :as route]
            [cv_service.me :as me]
            [taoensso.timbre :as timbre
             :refer (trace debug info warn error fatal spy with-log-level)]))

(timbre/set-config! [:appenders :spit :enabled?] true)
(timbre/set-config! [:shared-appender-config :spit-filename] "/home/vds/apps/logs/cv_service.log")

(defmacro bench [form]
  `(spy :info (time ~form)))

(defroutes my_routes
  (GET "/me/birth" [] (bench (response (:birth me/me))))
  (GET "/me" [] (bench (response me/me)))
  (route/resources "/"))

(def app (wrap-json-response my_routes))

(defn -main [& args] (run-jetty app {:port 9001}))

