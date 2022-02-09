package com.ayman.demo.demo;

import com.ayman.demo.demo.data.entity.ItemEntity;
import com.ayman.demo.demo.data.manager.ItemManager;
import com.ayman.demo.demo.data.repo.ItemRepo;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean("saveItems")
    public CommandLineRunner demo(ItemRepo itemRepo) {
        return (args) -> {
            // save a few customers
            itemRepo.save(new ItemEntity("normal item", 15, 50));
            itemRepo.save(new ItemEntity("normal item", 15, 50));
            itemRepo.save(new ItemEntity("Conjured", 15, 50));
            itemRepo.save(new ItemEntity("Conjured", 15, 50));
            itemRepo.save(new ItemEntity("Aged Brie", 15, 5));
            itemRepo.save(new ItemEntity("Aged Brie", 15, 5));
            itemRepo.save(new ItemEntity("Aged Brie", 15, 5));
            itemRepo.save(new ItemEntity("Backstage passes to a TAFKAL80ETC concert", 15, 5));
            itemRepo.save(new ItemEntity("Backstage passes to a TAFKAL80ETC concert", 15, 5));
            itemRepo.save(new ItemEntity("Sulfuras, Hand of Ragnaros", 50, 80));

            // fetch all customers
            log.info("items found with findAll():");
            log.info("-------------------------------");
            for (ItemEntity itemEntity : itemRepo.findAll()) {
                log.info(itemEntity.toString());
            }


            log.info("");
        };
    }

    @Bean
    @DependsOn("saveItems")
    public GildedRose getGildedRoseApp() {
        return new GildedRose();
    }


    @Bean
    @DependsOn("saveItems")
    public ItemManager getItemManager() {
        return new ItemManager();
    }
}
