package com.gildedrose;

public class DefaultItemStrategy implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
