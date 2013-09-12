(ns cv_service.me
  (:use clj-time.format clj-time.core)
  (:refer-clojure :exclude [extend second]))

(def birth
  (unparse (formatters :date) (date-time 1975 04 28)))

(def me {:firstname "Sven"
         :lastname "Malvik"
         :name "Sven Malvik"
         :birth birth
         :email "sven@malvik.de"
         :web "sven.malvik.de"
         :externalLinks {:googleplus "https://plus.google.com/108647064315385771255"
                         :linkedin "http://no.linkedin.com/in/svenmalvik"
                         :twitter "https://twitter.com/SvenMalvik"
                         :facebook "https://www.facebook.com/sven.malvik"}})

