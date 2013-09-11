(defproject cv_service "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :main cv_service.core
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler cv_service.core/app
         :auto-reload? true
         :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring "1.2.0"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.2.0-SNAPSHOT"]])