package com.example.main.controller;

import com.example.main.entity.MyData;
import com.example.main.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApiEndpoint {

    @Autowired
    private DataBaseRepository dataBaseRepository;


    @GetMapping(value = "get/{UserId}/{Id}",
        produces = {"application/json"})
    public List<MyData> getData(@PathVariable("UserId") String userId, @PathVariable("Id") String id) {
        return dataBaseRepository.getAllData(userId, id);
    }

    @PostMapping(value = "set/{UserId}/{Id}",
        produces = {"application/json"})
    public String setData(@PathVariable("UserId") String userId, @PathVariable("Id") String id,
                         @RequestBody String myData) {
        dataBaseRepository.setMyData(userId, id, myData);
        return "";
    }
}
