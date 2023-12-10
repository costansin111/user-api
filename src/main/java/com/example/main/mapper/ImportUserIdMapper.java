package com.example.main.mapper;

import com.example.main.entity.UserId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImportUserIdMapper implements RowMapper<UserId> {

    @Override
    public UserId mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserId userId = new UserId();
        userId.setUserId(rs.getString("user_id"));
        return userId;
    }
}
