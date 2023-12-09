package com.example.main.controller;

import com.example.main.service.impl.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ApiEndpoint {

    @Autowired
    private ApiServiceImpl apiService;


    @GetMapping(value = "get/{UserId}/{Id}",
        produces = {"application/json"})
    public String getData(@PathVariable("UserId") String userId, @PathVariable("Id") String id) {
        return apiService.getData(userId, id);
    }

    @PostMapping(value = "set/{UserId}/{Id}",
        produces = {"application/json"})
    public String setData(@PathVariable("UserId") String userId, @PathVariable("Id") String id,
                         @RequestBody String freeData) {
        apiService.setData(userId, id, freeData);
        return "";
    }
}
