(ns ajax-lib.http.status-code)

(defn status-code
  "Return string value for particular status number"
  [status]
  (case status
    101 "101 Switching protocols"
    200 "200 OK"
    403 "403 Forbidden"
    404 "404 Not Found"
    500 "500 Internal Server Error"
    "404 Not Found"))

(defn continue
  "Continue"
  []
  100)

(defn switching-protocols
  "Switching protocols"
  []
  101)

(defn processing
  "Processing"
  []
  102)

(defn ok
  "OK"
  []
  200)

(defn created
  "Created"
  []
  201)

(defn accepted
  "Accepted"
  []
  202)

(defn non-authoritative-information
  "Non authoritative information"
  []
  203)

(defn no-content
  "No content"
  []
  204)

(defn reset-content
  "Reset content"
  []
  205)

(defn partial-content
  "Partial content"
  []
  206)

(defn multi-status
  "Multi-Status"
  []
  207)

(defn already-reported
  "Already Reported"
  []
  208)

(defn im-used
  "IM Used"
  []
  226)

(defn multiple-choices
  "Multiple choices"
  []
  300)

(defn moved-permanently
  "Moved permanently"
  []
  301)

(defn found
  "Found"
  []
  302)

(defn see-other
  "See other"
  []
  303)

(defn not-modified
  "Not modified"
  []
  304)

(defn use-proxy
  "Use proxy"
  []
  305)

(defn temporary-redirect
  "Temporary redirect"
  []
  307)

(defn permanent-redirect
  "Permanent redirect"
  []
  308)

(defn bad-request
  "Bad request"
  []
  400)

(defn unauthorized
  "Unauthorized"
  []
  401)

(defn payment-required
  "Payment required"
  []
  402)

(defn forbidden
  "Forbidden"
  []
  403)

(defn not-found
  "Not found"
  []
  404)

(defn method-not-allowed
  "Method not allowed"
  []
  405)

(defn not-acceptable
  "Not acceptable"
  []
  406)

(defn proxy-authentication-required
  "Proxy authentication required"
  []
  407)

(defn request-timeout
  "Request timeout"
  []
  408)

(defn conflict
  "Conflict"
  []
  409)

(defn gone
  "Gone"
  []
  410)

(defn length-required
  "Length required"
  []
  411)

(defn precondition-failed
  "Precondition failed"
  []
  412)

(defn request-entity-too-large
  "Request entity too large"
  []
  413)

(defn request-uri-too-large
  "Request URI too large"
  []
  414)

(defn unsupported-media-type
  "Unsupported media type"
  []
  415)

(defn requested-range-not-satisfied
  "Requested range not satisfied"
  []
  416)

(defn expectation-failed
  "Expectation failed"
  []
  417)

(defn im-teapot
  "I'm a teapot"
  []
  418)

(defn misdirected-request
  "Misdirected request"
  []
  421)

(defn unprocessable-entity
  "Unprocessable Entity"
  []
  422)

(defn locaked
  "Locked"
  []
  423)

(defn failed-dependency
  "Failed Dependency"
  []
  424)

(defn upgrade-required
  "Upgrade required"
  []
  426)

(defn precondition-required
  "Precondition required"
  []
  428)

(defn too-many-requests
  "Too many requests"
  []
  429)

(defn request-header-fields-too-large
  "Request header fields too large"
  []
  431)

(defn connection-closed-without-response
  "Connection Closed Without Response"
  []
  444)

(defn unavailable-for-legal-reasons
  "Unavailable for legal reasons"
  []
  451)

(defn client-closed-request
  "Client Closed Request"
  []
  499)

(defn internal-server-error
  "Internal Server Error"
  []
  500)

(defn not-implemented
  "Not implemented"
  []
  501)

(defn bad-gateway
  "Bad gateway"
  []
  502)

(defn service-unavailable
  "Service unavailable"
  []
  503)

(defn gateway-timeout
  "Gateway timeout"
  []
  504)

(defn http-version-not-supported
  "HTTP version not supported"
  []
  505)

(defn variante-also-negotiates
  "Variant Also Negotiates"
  []
  506)

(defn insufficient-storage
  "Insufficient Storage"
  []
  507)

(defn loop-detected
  "Loop Detected"
  []
  508)

(defn not-extended
  "Not Extended"
  []
  510)

(defn network-authentication-required
  "Network authentication required"
  []
  511)

(defn network-connect-timeout-error
  "Network Connect Timeout Error"
  []
  599)

