package com.ayman.demo.demo.controller;


import com.ayman.demo.demo.data.manager.ItemManager;
import com.gildedrose.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gildedrose.GildedRose;

@RestController
public class GildedRoseRestController {
    @Autowired
    private GildedRose gildedRoseApp;

    @Autowired
    private ItemManager itemManager;

    GildedRoseRestController() {
    }

    @GetMapping("/api/glidedRose/items")
    Item[] index() {
        return itemManager.getGildedRoseItems();
    }

    @PutMapping("/api/glidedRose/items")
    Item[] updateItemsQuality() {
        Item[] items = itemManager.getGildedRoseItems();
        gildedRoseApp.setItems(items);
        gildedRoseApp.updateQuality();
        itemManager.updateEntityItems(gildedRoseApp.getItems());
        return gildedRoseApp.getItems();
    }


}
