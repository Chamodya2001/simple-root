package com.example.simpleroot.controller;

import com.example.simpleroot.dto.UserDto;
import com.example.simpleroot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
@CrossOrigin


public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<UserDto> getusers(){
        return userService.getAllUsers();

    }


    @PostMapping("/save")
    public UserDto saveuser(@RequestBody UserDto userDto){
       return userService.usersave(userDto);



    }

    @PutMapping("/update")
    public String updateUser(@RequestBody UserDto userDto){
      return   userService.update(userDto);

    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody UserDto userDto){
       return userService.delete(userDto);


    }
    @GetMapping("/getuserdetailsByID/{userid}")
    public UserDto getdetailsByuserId(@PathVariable String userid){
       UserDto details= userService.getDetailsBYuserId(userid);
        return details;

    }

    @GetMapping("/getuserdetais/{userid}/{address}")
    public UserDto getdetailsByuserIdAndaddress(@PathVariable String userid,@PathVariable String address){
        return  userService.getDetailsByidAndaddress(userid,address);


    }

}
