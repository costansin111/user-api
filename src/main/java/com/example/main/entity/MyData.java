package com.example.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "freedata")
public class MyData {

    @Id
    private Long id;

    private String freeData;

    private Timestamp timeCreate;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserId userId;
}
