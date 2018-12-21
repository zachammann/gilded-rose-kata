(ns gilded-rose.core-spec
(:require [clojure.test :refer :all]
          [gilded-rose.core :as core]))

(def items [(core/item "foo" 0 0)])

(deftest gilded-rose-test
  (is (= "fixme" (:name (first (core/update-quality items)))))
  (is (= 1 1)))
