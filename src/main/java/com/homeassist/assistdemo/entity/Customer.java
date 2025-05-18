package com.homeassist.assistdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name="name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    //Constructor -----

    public Customer(){

    }

    public Customer(String name, String email, String pass) {
        this.username = name;
        this.email = email;
        this.password = pass;

    }

    //getters and setters ----


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
