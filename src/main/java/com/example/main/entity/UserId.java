package com.example.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserId")
public class UserId {

    @Id
    private String userId;

}
