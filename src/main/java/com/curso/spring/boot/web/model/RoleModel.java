package com.curso.spring.boot.web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserModel> users;
}
