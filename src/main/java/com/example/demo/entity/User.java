package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String role;

}
