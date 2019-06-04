(ns ajax-lib.test-runner
  (:require [ajax-lib.core-test-cljs]
            [doo.runner :refer-macros [doo-tests doo-all-tests]]))

(enable-console-print!)

(doo-tests
  'ajax-lib.core-test-cljs)

