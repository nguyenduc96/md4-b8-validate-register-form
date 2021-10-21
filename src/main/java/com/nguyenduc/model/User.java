package com.nguyenduc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 45, message = "Ten phai dai tu 3 den 45 ky tu")
    private String firstName;

    @Size(min = 3, max = 45, message = "Ten phai dai tu 3 den 45 ky tu")
    private String lastName;

    @Size(min = 6, max = 18, message = "Ten dang nhap phai dai tu 6 den 18 ky tu")
    private String userName;

    @Size(min = 6, max = 18, message = "Mat khau phai dai tu 6 den 18 ky tu")
    private String password;

    @Email( message = "Hay nhap dung dinh dang email")
    private String email;

    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "Hay nhap dung dinh dang so dien thoai")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
