package com.example.simpleroot.configt;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelmapperConfig {
    //    @Bean
//    public org.modelmapper.ModelMapper modelMapper(){
//        return new org.modelmapper.ModelMapper();


    //}
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
