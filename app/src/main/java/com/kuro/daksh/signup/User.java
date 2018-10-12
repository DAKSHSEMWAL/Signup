package com.kuro.daksh.signup;

public class User {
    private String firebase_id;
    private String device;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String dob;
    private String status;
    private String data;

    public User() {
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public void setDevice(String device) {
        this.device = device;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirebase_id() {
        return firebase_id;
    }

    public String getDevice() {
        return device;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }
}

