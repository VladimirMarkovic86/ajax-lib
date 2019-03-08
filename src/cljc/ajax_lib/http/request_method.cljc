(ns ajax-lib.http.request-method)

; The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
(def GET
     "GET")
; Customized GET method for websocket requests
(def ws-GET
     "ws GET")

; The HEAD method asks for a response identical to that of a GET request, but without the response body.
(def HEAD
     "HEAD")

; The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.
(def POST
     "POST")

; The PUT method replaces all current representations of the target resource with the request payload.
(def PUT
     "PUT")

; The DELETE method deletes the specified resource.
(def DELETE
     "DELETE")

; The CONNECT method establishes a tunnel to the server identified by the target resource.
(def CONNECT
     "CONNECT")

; The OPTIONS method is used to describe the communication options for the target resource.
(def OPTIONS
     "OPTIONS")

; The TRACE method performs a message loop-back test along the path to the target resource.
(def TRACE
     "TRACE")

; The PATCH method is used to apply partial modifications to a resource. 
(def PATCH
     "PATCH")

