package com.curso.spring.boot.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "role")
@Data
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codrole;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Collection<UserModel> users;
}
