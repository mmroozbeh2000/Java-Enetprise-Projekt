package com.example.usersystem;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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

    private String name;

    @Column
    private String surname;

    @Column
   @Email

    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column
    private int saldo;

}