(ns youtube-looper.util
  (:require [wilkerdev.util :refer [format]]))

(defn seconds->time [seconds]
  (let [minutes (->> (/ seconds 60)
                     (.floor js/Math))
        seconds (mod seconds 60)]
    (format "%02d:%02d" minutes seconds)))

(defn time->seconds [time]
  (let [[_ minutes seconds] (re-find #"^(\d{1,2}):(\d{1,2}(?:\.\d+)?)$" time)]
    (+ (* (js/parseInt minutes) 60)
       (js/parseFloat seconds))))
