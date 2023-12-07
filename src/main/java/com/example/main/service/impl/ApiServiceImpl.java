package com.example.main.service.impl;

import com.example.main.exception.NotFoundException;
import com.example.main.service.ApiService;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class ApiServiceImpl implements ApiService {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final Properties sqlQueries;

    public ApiServiceImpl(NamedParameterJdbcOperations jdbcOperations, Properties sqlQueries) {
        this.jdbcOperations = jdbcOperations;
        this.sqlQueries = sqlQueries;
    }

    public void setData(String userId, String id, String freeData) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("freeData", freeData);
        jdbcOperations.update(sqlQueries.getProperty("SQL_UPDATE_DATA"), parameterSource);

    }

    @Override
    public String getData(String userId, String id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        List<String> ifExsists = jdbcOperations.query(sqlQueries.getProperty("SQL_GET_ID_STUFF"), parameterSource, new SingleColumnRowMapper<String>());
        if (!Boolean.getBoolean(ifExsists.get(0))) {
           throw new NotFoundException();
        }

        parameterSource.addValue("id", id);
        jdbcOperations.query(sqlQueries.getProperty("SQL_GET_ID_STUFF"), parameterSource, new SingleColumnRowMapper<String>());
        return null;
    }
}
