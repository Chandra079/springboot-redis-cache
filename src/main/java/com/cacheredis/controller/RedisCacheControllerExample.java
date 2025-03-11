package com.cacheredis.controller;


import com.cacheredis.entity.RedisItem;
import com.cacheredis.service.RedisCacheServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rediscache")
public class RedisCacheControllerExample {

    @Autowired
    RedisCacheServiceClass cacheServiceClass;


    @GetMapping
    public RedisItem getAllItems(@RequestParam int id) {
        System.out.println("getAllItems In Controller "+id );
        return cacheServiceClass.listofItems(id);
    }

    @PostMapping
    public RedisItem updateItem(@RequestBody RedisItem item) {
        System.out.println("updateItem In Controller");
       return cacheServiceClass.updateItem(item);
    }
}
