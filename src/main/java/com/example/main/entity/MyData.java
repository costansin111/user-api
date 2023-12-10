package com.example.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "mydata")
public class MyData {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "my_data")
    private String myData;

    @Column(name = "timecreate")
    private Timestamp timeCreate;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private UserId userId;
}
