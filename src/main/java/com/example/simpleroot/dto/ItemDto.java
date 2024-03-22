package com.example.simpleroot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDto {

    private int itemId;

    private String itemName;

    private int price;

}
