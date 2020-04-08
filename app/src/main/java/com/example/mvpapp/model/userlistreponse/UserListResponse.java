package com.example.mvpapp.model.userlistreponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserListResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("com_code")
    @Expose
    private String comCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("forgot")
    @Expose
    private String forgot;
    @SerializedName("logintype")
    @Expose
    private String logintype;
    @SerializedName("uid")
    @Expose
    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForgot() {
        return forgot;
    }

    public void setForgot(String forgot) {
        this.forgot = forgot;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String toString(){
        return "Name : " + name + "\nID : " + id + "\nEmail : " + email;
    }

}