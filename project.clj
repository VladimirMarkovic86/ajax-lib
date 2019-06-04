(defproject org.clojars.vladimirmarkovic86/ajax-lib "0.1.11"
  :description "Simple AJAX library"
  :url "https://github.com/VladimirMarkovic86/ajax-lib"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 ]

  :min-lein-version "2.0.0"
    
  :source-paths ["src/cljc" "src/cljs"]

  :plugins [[lein-cljsbuild  "1.1.7"]
            [lein-doo "0.1.11"]
            ]

  :cljsbuild
    {:builds
      {:test
        {:source-paths ["src/cljc" "src/cljs" "test/cljs"]
         :compiler     {:main ajax-lib.test-runner
                        :optimizations :whitespace
                        :output-dir "resources/public/assets/js/out/test"
                        :output-to "resources/public/assets/js/test.js"}}
       }}
 )

