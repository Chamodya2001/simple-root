package com.example.simpleroot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Item {

    @Id
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "iteme_name",length = 50)
    private String itemName;

    @Column(name = "price",length = 10)
    private int price;
}
