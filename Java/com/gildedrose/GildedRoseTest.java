package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    //degrade twice as quickly
    public void conjuredItemQuality() {
        Item[] items = new Item[]
        {
            new Item("+1 Spiked Guantlet", 5, 4),
            new Item("Conjured +1 Spiked Guantlet", 5, 4),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(2, app.items[1].quality);
    }
    
    @Test
    //increase in quality twice as quickly
    public void conjuredBrie() {
        Item[] items = new Item[]
        {
            new Item("Aged Brie", 5, 4),
            new Item("Conjured Aged Brie", 5, 4),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }
    
    @Test
    //increase in value at the same rate
    public void conjuredBackstagePasses(){
        Item[] items = new Item[]
        {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4),
            new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 5, 4),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(7, app.items[1].quality);
    }
    
    @Test
    //legendary item does not degrade
    public void conjuredSulfuras(){
        Item[] items = new Item[]
        {
            new Item("Sulfuras, Hand of Ragnaros", 5, 80),
            new Item("Conjured Sulfuras, Hand of Ragnaros", 5, 80),
        };
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 80; i++)
        {
            app.updateQuality();
            assertEquals(80, app.items[0].quality);
            assertEquals(80, app.items[1].quality);
        }
    }
    
    @Test
    //conjured Brie past sell by increases in quality faster
    public void oldBrie(){
        Item[] items = new Item[]
        {
            new Item("Aged Brie", 0, 4),
            new Item("Conjured Aged Brie", 0, 4),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }
    
    @Test
    //Nothing goes above 50 or below 0 quality
    public void itemQualityBounds(){
        Item[] items = new Item[]
        {
            new Item("Conjured Brie", 20, 0),
            new Item("Conjured Chainmail", 40, 50),
        };
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 50; i++)
        {
            app.updateQuality();
            assertTrue(app.items[0].quality <= 50);
            assertTrue(app.items[1].quality >= 0);
        }
    }

}
