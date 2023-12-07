package com.example.main.service;

public interface ApiService {

    void setData(String userId, String id, String freeData);

    String getData(String userId, String id);
}
