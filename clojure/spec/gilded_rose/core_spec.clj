(ns gilded-rose.core-spec
(:require [clojure.test :refer :all]
          [gilded-rose.core :as core]))

(def examples
  [(core/item "+5 Dexterity Vest" 10 20)
   (core/item "Aged Brie" 2 0)
   (core/item "Sulfuras, Hand of Ragnaros" 5 7)])

(core/update-current-inventory examples)

(deftest gilded-rose-test
  (is (= "fixme" 1)))
