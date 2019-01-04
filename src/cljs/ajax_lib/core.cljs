(ns ajax-lib.core
  (:require [ajax-lib.http.mime-type :as mt]
            [ajax-lib.http.request-header :as rh]
            [ajax-lib.http.entity-header :as eh]
            [cljs.reader :as reader]))

(def base-url
     (atom nil))

(def with-credentials
     (atom false))

(defn get-response
  "Get response from XMLHttpRequest"
  [xhr
   & [raw]]
  (try
    (if raw
      (.-response
        xhr)
      (reader/read-string
        (.-response
          xhr))
     )
    (catch js/Error e
      (.log
        js/console
        (.-message
          e))
     ))
 )

(defn ajax-error
  "Handle details error"
  [xhr]
  (let [response (get-response xhr)
        error-message (:error-message response)]
    (.error js/console error-message))
 )

(defn onload
  "Ajax onload function"
  [xhr
   params-map]
  (if (and (= (.-readyState
                xhr)
              4)
           (= (.-status
                xhr)
              200))
    (let [success-fn (:success-fn params-map)
          success-fn (if success-fn
                       success-fn
                       (fn [] ))]
      (.log
        js/console
        xhr)
      (success-fn
        xhr
        params-map))
    (let [error-fn (:error-fn params-map)
          error-fn (if error-fn
                     error-fn
                     ajax-error)]
      (case (.-status
              xhr)
        1 (.log js/console "OPENED")
        2 (.log js/console "HEADERS_RECEIVED")
        3 (.log js/console "LOADING")
        (do (.log
              js/console
              xhr)
            (error-fn
              xhr
              params-map))
       ))
    ))

(defn onready
  "Ajax onreadystatechange function"
  [xhr
   params-map]
  (if (and (= (.-readyState
                xhr)
              4)
           (= (.-status
                xhr)
              200))
    ((:success-fn params-map)
      xhr
      params-map)
    (case (.-readyState
            xhr)
      1 (.log js/console "OPENED")
      2 (.log js/console "HEADERS_RECEIVED")
      3 (.log js/console "LOADING")
      ((:error-fn params-map)
        xhr
        params-map))
   ))

(defn set-request-header
  "Set request header"
  [xhr
   [key value]]
  (.setRequestHeader
    xhr
    key
    value))

(defn set-request-property
  "Set request property"
  [xhr
   [key value]]
  (aset
    xhr
    key
    value))

(defn ajax
  "Universal ajax call
  
  :url                     Define url address to communicate with
  :request-method          Define request method ex. GET, POST...
  :success-fn              Specify function name which will handle success

                           example: (defn success-handler
                                      \"Simple ajax success handler\"
                                      [xhr
                                       params-map]
                                      implementation..)

  :error-fn                Specify function name which will handle error

                           example: (defn error-handler
                                      \"Simple ajax error handler\"
                                      [xhr
                                       params-map]
                                      implementation..)

  :request-header-map      Define map with key value pairs for request header
  :request-property-map    Define map with key value pairs for setting property values
  :entity                  Define content that you want to send
  :entity-fn-params        In case entity is a function, define vector of it's params
                            example: [param1 param2]"
  [params-map]
  (let [xhr (js/XMLHttpRequest.)
        url (if @base-url
              (str
                @base-url
                (:url params-map))
              (:url params-map))
        request-method (or (:request-method params-map)
                           "POST")
        request-header-map (conj
                             {(rh/accept) (mt/text-plain)
                              (eh/content-type) (mt/text-plain)}
                             (:request-header-map params-map))
        request-property-map (conj
                               {"responseType" (mt/text-plain)}
                               (when @with-credentials
                                 {"withCredentials" true}))
        request-property-map (conj
                               request-property-map
                               (:request-property-map params-map))
        entity (:entity params-map)
        entity-fn-params (:entity-fn-params params-map)
        entity (if (fn? entity)
                 (entity entity-fn-params)
                 entity)]
    (aset
      xhr
      "onload"
      #(onload
         xhr
         params-map))
  ;    (aset xhr "onreadystatechange" onready)
  ;    (aset xhr "onprogress" onprogress)
    (.open
      xhr
      request-method
      url
      true)
    (doseq [[k v] request-header-map]
      (set-request-header
        xhr
        [k v]))
    (doseq [[k v] request-property-map]
      (set-request-property
        xhr
        [k v]))
    (if entity
      (.send
        xhr
        entity)
      (.send
        xhr))
   ))

(defn sjax
  "Synchronous javascript and XML
   
   Same as ajax, except this function waits for server response"
  [params-map]
  (let [xhr (js/XMLHttpRequest.)
        url (if @base-url
              (str
                @base-url
                (:url params-map))
              (:url params-map))
        request-method (or (:request-method params-map)
                           "POST")
        request-header-map (conj
                             {(rh/accept) (mt/text-plain)
                              (eh/content-type) (mt/text-plain)}
                             (:request-header-map params-map))
        request-property-map (conj
                               {"responseType" (mt/text-plain)}
                               (when @with-credentials
                                 {"withCredentials" true}))
        request-property-map (conj
                               request-property-map
                               (:request-property-map params-map))
        entity (:entity params-map)
        entity-fn-params (:entity-fn-params params-map)
        entity (if (fn? entity)
                 (entity entity-fn-params)
                 entity)]
    (.open
      xhr
      request-method
      url
      false)
    (doseq [[k v] request-header-map]
      (set-request-header
        xhr
        [k v]))
    (doseq [[k v] request-property-map]
      (set-request-property
        xhr
        [k v]))
    (if entity
      (.send
        xhr
        entity)
      (.send
        xhr))
    (if (and (= (.-readyState
                  xhr)
                4)
             (= (.-status
                  xhr)
                200))
      (.log
        js/console
        xhr)
      (case (.-status
              xhr)
        1 (.log js/console "OPENED")
        2 (.log js/console "HEADERS_RECEIVED")
        3 (.log js/console "LOADING")
        (.error
          js/console
          xhr))
     )
   xhr))

