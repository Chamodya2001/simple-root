package com.example.simpleroot.service;

import com.example.simpleroot.dto.ItemDto;
import com.example.simpleroot.entity.Item;
import com.example.simpleroot.entity.User;
import com.example.simpleroot.repo.ItemRepo;;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ItemServiceIMPL implements ItemService{
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String saveitem(ItemDto itemDto) {
        itemRepo.save(modelMapper.map(itemDto, Item.class));
        return "saved";
    }

    @Override
    public String updateItm(ItemDto itemDto) {
        if (itemRepo.existsById(itemDto.getItemId())) {
            itemRepo.save(modelMapper.map(itemDto,Item.class));
            return "update";
        }else
            return "this item not database";
    }

    @Override
    public String deleteitem(ItemDto itemDto) {
      if(itemRepo.existsById(itemDto.getItemId())){
          itemRepo.delete(modelMapper.map(itemDto,Item.class));
          return "delete sccessful";
      }else {
          return "not include database";
      }
    }

    @Override
    public ItemDto getbyid(int itemid) {

      Optional<Item>  item=itemRepo.findById(itemid);
      if(item.isPresent()){
          ItemDto item1=new ItemDto(
                  item.get().getItemId(),
                  item.get().getItemName(),
                  item.get().getPrice()
          );
          return item1;

      }else{
          return null;
      }

    }

    @Override
    public List<ItemDto> getalldet() {
        List<Item> itemdet = itemRepo.findAll();
        List<ItemDto> itemdeDTOList = new ArrayList<>();
        for (Item c : itemdet) {
          ItemDto  itemDto = new ItemDto(
                    c.getItemId(),
                    c.getItemName(),
                    c.getPrice()
            );
          itemdeDTOList.add(itemDto);
        }
return itemdeDTOList;
    }

    @Override
    public List<ItemDto> getdetilsModelmapper() {
        List<Item> itemdet1 = itemRepo.findAll();
        List<ItemDto> itemdet=modelMapper.map(itemdet1, new TypeToken<List<ItemDto>>(){}.getType());
        return itemdet;
    }
}
