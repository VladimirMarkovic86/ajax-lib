(ns ajax-lib.http.request-state)

; The XMLHttpRequest client has been created, but the open() method hasn't been called yet.
(def UNSENT-num
     0)

(def UNSENT
     "UNSENT")

; open() method has been invoked. During this state, the request headers can be set using the setRequestHeader() method and the send() method can be called which will initiate the fetch.
(def OPENED-num
     1)

(def OPENED
     "OPENED")

; send() has been called and the response headers have been received.
(def HEADERS_RECEIVED-num
     2)

(def HEADERS_RECEIVED
     "HEADERS_RECEIVED")

; Response's body is being received. If responseType is "text" or empty string, responseText will have the partial text response as it loads.
(def LOADING-num
     3)

(def LOADING
     "LOADING")

; The XMLHttpRequest client has been created, but the open() method hasn't been called yet.
(def DONE-num
     4)

(def DONE
     "DONE")

