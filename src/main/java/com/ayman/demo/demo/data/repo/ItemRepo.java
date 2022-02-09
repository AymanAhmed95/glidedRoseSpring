package com.ayman.demo.demo.data.repo;

import com.ayman.demo.demo.data.entity.ItemEntity;
import com.gildedrose.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<ItemEntity, Integer> {
    List<ItemEntity> findAll();

}
