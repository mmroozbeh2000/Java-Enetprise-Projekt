package com.example.usersystem;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "*Please provide your name")
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surname;

    @Column
    @NotNull
    @Email
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column
    private int saldo;

}