package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            
            //added code for Conjured Items - I'm going to assume that a conjured backstage pass
            //doesn't increase in quality faster than a normal one and that the Brie does.
            boolean isConjured = false;
            if(items[i].name.contains("Conjured ")) { 
                isConjured = true;
                items[i].name = items[i].name.replace("Conjured ", "");
            }//Boolean for flagging conjured items, and temporary alteration of the item name to avoid conflict
            //with existing code.
            
            
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                        if(isConjured && items[i].quality > 0){ items[i].quality--; }//Decrement for conjured items
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    
                    //Check for Conjured Aged Brie to age faster
                    if((!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) 
                        && isConjured && (items[i].quality < 50))
                    {
                        items[i].quality++;
                    }

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        //Make Conjured Brie past the sell by age even faster
                        if(isConjured && (items[i].quality < 50)){
                            items[i].quality++;
                        }
                    }
                }
            }
            //Restore name of altered item
            if(isConjured)
            {
                items[i].name = "Conjured " + items[i].name;
            }
        }
    }
}
