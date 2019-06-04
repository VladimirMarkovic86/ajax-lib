(ns ajax-lib.core-test-cljs
  (:require [ajax-lib.http.mime-type :as mt]
            [ajax-lib.http.request-method :as rm]
            [clojure.test :refer-macros [deftest is testing]]
            [ajax-lib.core :refer [set-cookie get-response ajax-error onload onready
                                   ajax sjax]]))

(deftest test-set-cookie
  (testing "Test set cookie"
    
    (let [cookie-value nil
          result (set-cookie
                   cookie-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [cookie-value "session=test-session"]
      
      (set-cookie
        cookie-value)
      
      (let [cookies (aget
                      js/document
                      "cookie")]
        
        (is
          (not= -1
                (.indexOf
                  cookies
                  "session=test-session"))
         )
        
       )
      
     )
    
   ))

(deftest test-get-response
  (testing "Test get response"
    
    (let [xhr nil
          result (get-response
                   xhr)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [xhr (clj->js
                {"cljResponseType" (mt/text-plain)
                 "response" "test"})
          result (get-response
                   xhr)]
      
      (is
        (= result
           "test")
       )
      
     )
    
    (let [xhr (clj->js
                {"cljResponseType" (mt/text-clojurescript)
                 "response" "{:test-key-1 1 :test-key-2 \"two\"}"})
          result (get-response
                   xhr)]
      
      (is
        (= result
           {:test-key-1 1
            :test-key-2 "two"})
       )
      
     )
    
   ))

(deftest test-ajax-error
  (testing "Test ajax error"
    
    (let [xhr nil
          result (ajax-error
                   xhr)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [xhr (clj->js
                {"cljResponseType" (mt/text-clojurescript)
                 "response" "{:error-message \"This is error message.\"}"})
          result (ajax-error
                   xhr)]
      
      (is
        (= result
           "This is error message.")
       )
      
     )
    
   ))

(deftest test-onload
  (testing "Test onload"
    
    (let [xhr nil
          params-map nil
          result (onload
                   xhr
                   params-map)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [xhr (clj->js
                {"readyState" 4
                 "status" 200
                 "getResponseHeader" ((fn []
                                        (fn [event]
                                          (.log
                                            js/console
                                            "test response header"))
                                       ))}
               )
          params-map nil
          result (onload
                   xhr
                   params-map)]
      
      (is
        (= result
           "success")
       )
      
     )
    
    (let [xhr (clj->js
                {"readyState" 1})
          params-map nil
          result (onload
                   xhr
                   params-map)]
      
      (is
        (= result
           "error")
       )
      
     )
    
   ))

(deftest test-onready
  (testing "Test onready"
    
    (let [xhr nil
          params-map nil
          result (onready
                   xhr
                   params-map)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [xhr (clj->js
                {"readyState" 4
                 "status" 200})
          params-map nil
          result (onready
                   xhr
                   params-map)]
      
      (is
        (= result
           "success")
       )
      
     )
    
    (let [xhr (clj->js
                {"readyState" 0
                 "status" 200})
          params-map nil
          result (onready
                   xhr
                   params-map)]
      
      (is
        (= result
           "error")
       )
      
     )
    
   ))

(deftest test-ajax-set-request-header-set-request-property
  (testing "Test ajax set request header set request property"
    
    (let [params-map nil
          result (ajax
                   params-map)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [params-map {:url "https://192.168.1.86:1604/login"
                      :success-fn (fn [xhr
                                       params-map]
                                    (.log
                                      js/console
                                      "success")
                                    (is
                                      (= (:entity params-map)
                                         {:entity-prop "entity-prop-value"})
                                     ))
                      :error-fn (fn [xhr
                                     params-map]
                                  (.log
                                    js/console
                                    "error")
                                  (is
                                    (= (:entity params-map)
                                       {:entity-prop "entity-prop-value"})
                                   ))
                      :entity {:entity-prop "entity-prop-value"}}]
      
      (ajax
        params-map)
      
     )
    
   ))

(deftest test-sjax-set-request-header-set-request-property
  (testing "Test sjax set request header set request property"
    
    (let [params-map nil
          result (sjax
                   params-map)]
      
      (is
        (instance?
          js/XMLHttpRequest
          result)
       )
      
     )
    
    (let [params-map {:url "https://192.168.1.86:1604/login"}
          result (sjax
                   params-map)]
      
      (is
        (nil?
          result)
       )
      
     )
    
   ))

