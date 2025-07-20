package com.eunice.demos.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String password;

}
