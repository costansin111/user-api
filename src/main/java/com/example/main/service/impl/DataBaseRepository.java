package com.example.main.service.impl;

import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseRepository {

    private final NamedParameterJdbcOperations jdbcOperations;

    public DataBaseRepository(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void setData(MapSqlParameterSource parameterSource) {
        jdbcOperations.query("SQL_UPDATE_STUFF", parameterSource, new SingleColumnRowMapper<String>());
    }
}
