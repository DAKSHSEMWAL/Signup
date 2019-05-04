package com.kuro.daksh.signup;


public class getUser {
    private String firebase_id;
    private String device;
    private String phone;
    private String login_type;
    private String password;
    private String status;
    private String data;

    public getUser() {
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirebase_id() {
        return firebase_id;
    }

    public String getDevice() {
        return device;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin_type() {
        return login_type;
    }

    public String getPassword() {
        return password;
    }


    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }
}


