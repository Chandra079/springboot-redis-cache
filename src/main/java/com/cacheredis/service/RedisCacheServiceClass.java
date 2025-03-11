package com.cacheredis.service;


import com.cacheredis.entity.RedisItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RedisCacheServiceClass {

    @Autowired
    RepostioryClass repostioryClass;

    @Cacheable(value = "redisitem" ,key = "#id")
    public RedisItem listofItems(int id) {

        System.out.println("In CacheServiceClass ");
//        List<RedisItem> itemList = new ArrayList<>();


        List<RedisItem>list= repostioryClass.getItemList();

        Optional<RedisItem> first = list.stream().filter(item -> item.getId() == id).findFirst();
        if (first.isPresent()){
            return first.get();
        }
    return null;
    }

    @CachePut(value = "redisitem" ,key = "#item.id")
    public RedisItem updateItem(RedisItem item) {
        RedisItem returnItem =null;

        System.out.println("In CacheServiceClass Updated ");

        List<RedisItem> itemList = RepostioryClass.getItemList();

        itemList.stream().filter(redisitem -> redisitem.getId()==item.getId()).
                map( redisItem -> {
                    redisItem.setId(item.getId());
                    redisItem.setDescription(item.getDescription().concat("---Updated"));
                    return  redisItem;
                }
              ).collect(Collectors.toList());
        Optional<RedisItem> first = itemList.stream().filter(item2 -> item2.getId() == item.getId()).findFirst();
        if (first.isPresent()){
            returnItem= first.get();
        }
        return returnItem;
    }



}
