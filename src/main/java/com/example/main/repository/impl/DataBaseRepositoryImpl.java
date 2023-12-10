package com.example.main.repository.impl;

import com.example.main.entity.MyData;
import com.example.main.entity.UserId;
import com.example.main.mapper.ImportMyDataIdMapper;
import com.example.main.mapper.ImportMyDataMapper;
import com.example.main.mapper.ImportUserIdMapper;
import com.example.main.repository.DataBaseRepository;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class DataBaseRepositoryImpl implements DataBaseRepository {

    private static final String INSERT_INTO_DATA = "INSERT INTO mydata (id, timecreate, my_data, user_id) VALUES (:id, :timecreate, :my_data, :user_id)";
    private static final String DELETE_DATA = "DELETE FROM mydata WHERE (mydata.id = :id)";
    private static final String GET_ALL_USERS = "SELECT * FROM userid";
    private static final String INSERT_ROOT_USER = "INSERT INTO userid values ('root')";
    private static final String GET_ALL_ID = "SELECT id FROM mydata";
    private static final String GET_ALL_DATA = "SELECT my_data FROM mydata";

    private final NamedParameterJdbcOperations jdbcOperations;

    public DataBaseRepositoryImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void setMyData(String user_id, String id, String my_data) {
        if (getAllUserId().isEmpty()) {
            jdbcOperations.update(INSERT_ROOT_USER, new MapSqlParameterSource());
        }

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", Long.valueOf(id));
        parameterSource.addValue( "timecreate", new Timestamp(System.currentTimeMillis()));
        parameterSource.addValue( "my_data", my_data);
        parameterSource.addValue( "user_id", user_id);

        if (getAllDataId().contains(Long.valueOf(id))) {
            jdbcOperations.update(DELETE_DATA, parameterSource);
        }

        jdbcOperations.update(INSERT_INTO_DATA, parameterSource);
    }

    public void setUserId(MapSqlParameterSource parameterSource) {
        jdbcOperations.query("SQL_UPDATE_USER", parameterSource, new SingleColumnRowMapper<String>());
    }

    public List<UserId> getAllUserId() {
        return jdbcOperations.query(GET_ALL_USERS, new MapSqlParameterSource(), new ImportUserIdMapper());
    }

    public List<Long> getAllDataId() {
        return jdbcOperations.query(GET_ALL_ID, new MapSqlParameterSource(), new ImportMyDataIdMapper());
    }

    public List<MyData> getAllData(String userId, String id) {
        return jdbcOperations.query(GET_ALL_DATA, new MapSqlParameterSource(), new ImportMyDataMapper());
    }
}
