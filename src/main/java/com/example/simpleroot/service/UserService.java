package com.example.simpleroot.service;

import com.example.simpleroot.dto.UserDto;

import java.util.List;

public interface UserService {


    public UserDto usersave(UserDto userDto);

    public List<UserDto> getAllUsers();

    public String update(UserDto userDto);

    public boolean delete(UserDto userDto);

    public UserDto getDetailsBYuserId(String userId);

    public UserDto getDetailsByidAndaddress(String userid,String address);

    }
