package com.cacheredis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class RedisItem implements Serializable {

    private int id;
    private String name;
    private String description;
    private int price;
}
