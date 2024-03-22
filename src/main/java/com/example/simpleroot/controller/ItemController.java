package com.example.simpleroot.controller;


import com.example.simpleroot.dto.ItemDto;
import com.example.simpleroot.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
@CrossOrigin
@AllArgsConstructor

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String additem(@RequestBody ItemDto itemDto){
        return itemService.saveitem(itemDto);
    }
    @PutMapping("/updateItem")
    public String updateitem(@RequestBody ItemDto itemDto){
        return itemService.updateItm(itemDto);

    }
    @DeleteMapping("/deleteitem")
    public String deleteitem(@RequestBody ItemDto itemDto){
        return itemService.deleteitem(itemDto);

    }

    @GetMapping(
            path = {"/get-by-id"},
            params = {"id"}
    )
    public ItemDto getItembyId(@RequestParam(value = "id") int itemid){    //requastparm vala namai string eke variable namai samni nm value kiyala ekk onn na
        ItemDto itemDto=itemService.getbyid(itemid);
        return itemDto;
    }

    @GetMapping(
            path = "/get-all-user"
    )
    public List<ItemDto> getalldetails(){
        List<ItemDto> allitem=itemService.getalldet();
        return allitem;

    }

    @GetMapping(
            path = "/getalldetails-modelmapper"
    )
    public List<ItemDto> getdetils(){
        List<ItemDto> itemlistModelmapper=itemService.getdetilsModelmapper();
        return itemlistModelmapper;
    }
}
