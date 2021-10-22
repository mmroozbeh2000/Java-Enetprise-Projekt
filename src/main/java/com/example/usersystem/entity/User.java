package com.example.usersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    @Length(min = 5,max=30, message = "*Ditt användarnamn måste ha minst 5 tecken")
    @NotEmpty(message = "*Ange ett användarnamn")
    private String userName;
    @Column(name = "email")
    @Email(message = "*Var god ange en giltig e-postadress")
    @NotEmpty(message = "*Ange ett e-postadress")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Ditt lösenord måste ha minst 5 tecken")
    @NotEmpty(message = "*Ange ditt lösenord")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Ange ditt namn")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Ange ditt efternamn")
    private String lastName;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}

