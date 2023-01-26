package com.co.enggit.modules.login.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "user" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String email;
    private String password;
    private Long transactionId;
    private String mobile;
    private String firstName;
    private String lastName;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany
    private Set<Roles> roles;



}
