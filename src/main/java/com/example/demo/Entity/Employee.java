package com.example.demo.Entity;

//Lombok is a Java library that automatically generates repetitive code for you,
// so you don’t have to write it manually.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import  lombok.AllArgsConstructor;
import  lombok.Getter;
import  lombok.Setter;
import  lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name="Id")
    private Long id;

    @Column(name="First Name")
    private String firstName;

    @Column(name="Last Name")
    private String lastName;

    @Column(name="Email")
    private String email;
}
