(ns com.msgodf.cljondroid.main
  (:require [neko.activity :refer [defactivity set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.notify :refer [toast]]
            [neko.find-view :refer [find-view]]
            [neko.threading :refer [on-ui]])
  (:import android.widget.TextView))

(defn notify-from-edit [activity]
  (let [^TextView input (.getText (find-view activity ::user-input))]
    (toast activity
           (if (empty? input)
             "Your input is empty"
             (str "Your input: " input))
           :long)))

(defactivity com.msgodf.cljondroid.MainActivity
  :key :main
  :on-create
  (fn [this bundle]
    (on-ui
      (set-content-view! (*a)
        [:linear-layout {:orientation :vertical
                         :layout-width :fill
                         :layout-height :wrap}
         [:text-view {:text "Enter something here:"}]
         [:edit-text {:id ::user-input
                      :layout-width :fill}]
         [:button {:text "Touch me"
                   :on-click (fn [_] (notify-from-edit (*a)))}]]))))
