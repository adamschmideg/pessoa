(ns pessoa.core-test
  (:require [midje.sweet :refer :all]
            [pessoa.core :as p]))

(p/set-entry! "http://localhost:7878")

(fact
  (p/list-services)
  => {:registry ["http://localhost:7878"]
      :control ["http://localhost:8001" "http://localhost:8002"]})

(def d #inst "1985-04-12T23:20:50.18")

(fact
  (p/call :follow :core/get "bob")
  => [{:date 1, :content "Hi"}
      {:date 2, :content "Hi again"}]
  (p/debug :follow :core/get "bob")
  => {:called {:chat ["bob"]}
      :result [{:date 1, :content "Hi"}
               {:date 2, :content "Hi again"}]})

(fact "Different ways of calling"
      (do
        (require 'chat.core)
        (chat.core/say "Hello"))
      (p/call :chat "core/say" "Hello"))

(fact mocking
      (with-mock :chat "core/say"  (fn [& args] (str "You said: " (first args)))
                 (-> :chat
                     p/list-services
                     (str "/core/say")
                     @(http/post {:post {:message "Hello"}})
                     :body)
                 => "You said: Hello"))
