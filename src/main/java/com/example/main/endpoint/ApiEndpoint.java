package com.example.main.endpoint;

import com.example.main.service.impl.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiEndpoint {

    @Autowired
    private ApiServiceImpl apiService;

    @RequestMapping(value = "get/{UserId}/{Id}",
        produces = {"application/json"},
        method = RequestMethod.GET)
    public String getData(@PathVariable("UserId") String userId, @PathVariable("Id") String id) {
        return apiService.getData(userId, id);
    }

    @RequestMapping(value = "set/{UserId}/{Id}",
        produces = {"application/json"},
        method = RequestMethod.POST)
    public String setData(@PathVariable("UserId") String userId, @PathVariable("Id") String id,
                         @RequestBody String freeData) {
        apiService.setData(userId, id, freeData);
        return "";
    }
}
