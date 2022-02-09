package com.ayman.demo.demo.data.manager;

import com.ayman.demo.demo.data.entity.ItemEntity;
import com.ayman.demo.demo.data.repo.ItemRepo;
import com.gildedrose.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemManager {
    @Autowired
    ItemRepo itemRepo;

    public Item[] getGildedRoseItems() {
        List<ItemEntity> itemEntityList = itemRepo.findAll();
        Item[] items = new Item[itemEntityList.size()];
        for (int i = 0; i < itemEntityList.size(); i++) {
            items[i] = itemEntityList.get(i).getGlidedRoseItem();
        }
        return items;
    }


    public void updateEntityItems(Item[] items) {
        itemRepo.deleteAll();
        for (Item item :
                items) {
            itemRepo.save(new ItemEntity(item.name, item.sellIn, item.quality));
        }
    }

}
