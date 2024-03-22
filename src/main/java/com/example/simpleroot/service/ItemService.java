package com.example.simpleroot.service;

import com.example.simpleroot.controller.ItemController;
import com.example.simpleroot.dto.ItemDto;

import java.util.List;

public interface ItemService  {
    String saveitem(ItemDto itemDto);

    String updateItm(ItemDto itemDto);

    String deleteitem(ItemDto itemDto);

    ItemDto  getbyid(int itemid);

    List<ItemDto> getalldet();

    List<ItemDto> getdetilsModelmapper();
}
