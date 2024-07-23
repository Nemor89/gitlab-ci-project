package com.ws.gitlab.local.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("com.intellij.jpb.LombokDataInspection")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
}

