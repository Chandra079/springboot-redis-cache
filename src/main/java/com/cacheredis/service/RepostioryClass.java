package com.cacheredis.service;

import com.cacheredis.entity.RedisItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepostioryClass {
    static List<RedisItem> itemList = new ArrayList<>();

    static {
        itemList.add(new RedisItem(101,"Laptop", "High-performance gaming laptop", 1200));
        itemList.add(new RedisItem(102,"Smartphone", "5G-enabled smartphone with OLED display", 800));
        itemList.add(new RedisItem(103,"Headphones", "Noise-canceling over-ear headphones", 250));
        itemList.add(new RedisItem(104,"Smartwatch", "Waterproof smartwatch with heart-rate monitor", 300));
        itemList.add(new RedisItem(105,"Tablet", "10-inch tablet with stylus support", 600));
    }

    public static List<RedisItem> getItemList() {
        return itemList;
    }
}
