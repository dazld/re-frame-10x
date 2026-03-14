(ns day8.re-frame-10x.tools.throttle
  (:require [re-frame.trace]))

(def default-buffer-size 50)

(defonce ^:private state (atom {:drop-count 0
                                :buffer-size 0
                                :throttling? false}))

(defn buffer-size []
  (:buffer-size @state))

(defn dropped-count []
  (:drop-count @state))

(defn reset-drop-count! []
  (swap! state assoc :drop-count 0))

(defn increment-drop-count! []
  (swap! state update :drop-count inc))

(defn increment-buffer-size! []
  (swap! state update :buffer-size inc))

(defn is-throttling? []
  (:throttling? @state))

(defn set-throttling! [val]
  (swap! state assoc :throttling? val))

(defn clear-throttling! []
  (swap! state assoc :throttling? false :buffer-size 0))
