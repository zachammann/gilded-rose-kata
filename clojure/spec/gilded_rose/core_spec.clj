(ns gilded-rose.core-spec
(:require [clojure.test :refer :all]
          [gilded-rose.core :as core]))

(comment
  This is a sample codebase for testing. The Gilded Rose is an imaginary grocery
  store in a fantasy world. It sells some weird products. Like any grocery store,
  the products lose quality (value) the longer they sit on the shelf (with a few
  exceptions we are unlikely to get to).

  Let's work through these TODOs:
    1. Write some tests asserting what `core/update-quality` should return right now.
    2. Update the function so that aged brie doubles in value every 30 days.
    3. Update the function to cap quality at 50.

  It is super entirely possible we won't make it past the first TODO. This is a TON
  of new information all at once.

  I am your resource, ask me any questions, there are seriously no dumb ones. The
  more you talk through your logic out loud, the easier it is for me to see how you
  approach problems.

  I can run tests any time, and am happy to give you examples of how functions work
  in the REPL. If something doesn't make sense, please ask me and we'll figure it
  out together.
  )

(def items [(core/item "foo" 0 0)
            (core/item "Aged Brie" 5 27)
            (core/item "bar" 0 9)])

(deftest gilded-rose-test
  (is (= 1 1))

  (is (= "fixme" (:name (first (core/update-quality items)))))

  ; (is (= "fixme" (:quality (first (core/update-quality items)))))

  )


(comment
  ; Some handy examples to use in your repl

  (+ 1 1)           ; (1 + 1)
  (+ 1 1 1 1)       ; (1 + 1 + 1 + 1)
  (> 9 0)

  (first [5 4 3])
  (second [5 4 3])
  (last [5 4 3])

  (:a {:a "howdy" :b "what's up"})

  (merge {:a 1 :b 2 :c 3} {:d 4})
  (merge {:a 1 :b 2 :c 3} {:c 900 :d 4})

  (map inc [1 2 3 60 15])
  (map (fn [x] (str x "!")) ["a" "b" 50 4 "hi"])

  (defn cond-example [x]
    (cond
      (= 1 0)
      (println "false")

      (= 1 5)
      (println "also false")

      (= 1 x)
      (println "what do you know, x = 1, it's true!")

      :else
      (println "no true values here")))

  (defn if-example [x]
    (if (= x 1)
      (println "true: x = 1")
      (println "false: x != 1")))

  )