package com.example.simpleroot.service;

import com.example.simpleroot.dto.UserDto;
import com.example.simpleroot.entity.User;
import com.example.simpleroot.repo.UserRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto usersave(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;


    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userlist = userRepo.findAll();
        return modelMapper.map(userlist, new TypeToken<List<UserDto>>() {
        }.getType());


    }

    @Override
    public String update(UserDto userDto) {


        if (userRepo.existsById(userDto.getId())) {
            userRepo.save(modelMapper.map(userDto, User.class));
            return "user update";
        }else
            return "user not in database";

    }

    @Override
    public boolean delete(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto,User.class));
        return true;

    }

    //user id by>userge details ganima
    //select * from user where id=1;
    @Override
    public UserDto getDetailsBYuserId(String userId){
        User user=userRepo.getUserdetaildByuseId(userId);
       return modelMapper.map(user,UserDto.class);

    }
    //user id ,address by>userge detalis ganima
    //select * from user where id=1 and address
    @Override
    public UserDto getDetailsByidAndaddress(String userid,String address){
        User user=userRepo.getDetailsByIdAndAddres(userid,address);
        return modelMapper.map(user,UserDto.class);


    }

}