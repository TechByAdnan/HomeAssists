package com.homeassist.assistdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "service")
    private String service;
    @Column(name = "preferred_date")
    private String preferredDate;
    @Column(name = "preferred_time")
    private String preferredTime;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "zip_code")
    private String zipCode;

    public Booking(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Booking(String name, String email, String phone, String service, String preferredDate, String preferredTime, String streetAddress, String landmark, String zipCode) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.service = service;
        this.preferredDate = preferredDate;
        this.preferredTime = preferredTime;
        this.streetAddress = streetAddress;
        this.landmark = landmark;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", service='" + service + '\'' +
                ", preferredDate='" + preferredDate + '\'' +
                ", preferredTime='" + preferredTime + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", landmark='" + landmark + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
