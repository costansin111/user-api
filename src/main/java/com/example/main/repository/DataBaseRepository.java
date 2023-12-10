package com.example.main.repository;

import com.example.main.entity.MyData;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public interface DataBaseRepository {

    public void setMyData(String user_id, String id, String my_data);

    public void setUserId(MapSqlParameterSource parameterSource);

    public List<MyData> getAllData(String userId, String id);
}
