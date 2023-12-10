package com.example.main.mapper;

import com.example.main.entity.MyData;
import com.example.main.entity.UserId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ImportMyDataMapper implements RowMapper<MyData> {

    @Override
    public MyData mapRow(ResultSet rs, int rowNum) throws SQLException {
        MyData myData = new MyData();
        myData.setId(Long.valueOf(rs.getString("id")));
        myData.setMyData(rs.getString("my_data"));
        myData.setTimeCreate(new Timestamp(Long.parseLong(rs.getString("timecreate"))));
        myData.setUserId(new UserId(rs.getString("user_id")));
        return myData;
    }
}
