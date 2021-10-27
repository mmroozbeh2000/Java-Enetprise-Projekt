package com.example.usersystem;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    @NotEmpty(message = "*Please provide your name!")

    private String name;

    @Column
    @NotEmpty(message = "*Please provide your surname!")
    private String surname;

    @Column
   @Email(message = "*Please provide an email!")
    @NotEmpty(message = "*Please provide an email!")
    private String email;

    @Column
    @NotNull(message = "*please enter your number!")
    private int phone;

    @CreationTimestamp
    @Column(name="created", updatable = false)
    private LocalDateTime createTimeDate;

    @UpdateTimestamp
    @Column(name="lastUpdated")
    private  LocalDateTime updateTimeDate;




}