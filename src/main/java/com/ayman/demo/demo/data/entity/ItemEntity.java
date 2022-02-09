package com.ayman.demo.demo.data.entity;

import com.gildedrose.Item;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quality;
    private Integer sellIn;

    protected ItemEntity() {
    }

    public ItemEntity(String name, Integer sellIn, Integer quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public void setSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quality=" + quality +
                ", sellIn=" + sellIn +
                '}';
    }


    public Item getGlidedRoseItem() {
        return new Item(this.name, this.sellIn, this.quality);
    }
}
