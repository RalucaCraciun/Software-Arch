package com.gildedrose;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GildedRose {
    List<Item> items;
    private static final Map<String, ItemStrategy> itemStrategies = new HashMap<>();

    static {
        itemStrategies.put("Aged Brie", new AgedBrieStrategy());
        itemStrategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
        itemStrategies.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        itemStrategies.put("Conjured", new DefaultItemStrategy()); // Apply default for Conjured or similar items
    }

    public GildedRose(Item[] items) {
        this.items = List.of(items);
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = itemStrategies.getOrDefault(item.name, new DefaultItemStrategy());
            strategy.updateQuality(item);
        }
    }
}

