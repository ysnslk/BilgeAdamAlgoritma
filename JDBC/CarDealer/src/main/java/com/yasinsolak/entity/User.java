package com.yasinsolak.entity;

public class User {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String securityQuestion;
    private String answer;
    private String address;
    private boolean isActive;

    public User(long id, String name, String email, String phone, String password, String securityQuestion, String answer, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.address = address;
    }

    public User(String name, String email, String phone, String password, String securityQuestion, String answer, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.address = address;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + ", securityQuestion=" + securityQuestion + ", answer=" + answer + ", address=" + address + ", isActive=" + isActive + '}';
    }

}
