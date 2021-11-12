package com.qs.javabean;

import lombok.ToString;

import java.util.Date;
@ToString
public class PageData implements Comparable<PageData>{
    private Integer Id;
    private String username;
//    private String password;
//    private String phone;
//    private Date createTime;

    public PageData() {
    }
    public PageData(Integer id, String username) {
        Id = id;
        this.username = username;
    }
    public PageData(Integer id, String username, String password, String phone, Date createTime) {
        Id = id;
        this.username = username;
//        this.password = password;
//        this.phone = phone;
//        this.createTime = createTime;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(PageData o1) {
       int result =  this.getId() == o1.getId() ? -1 : 1;
        return result;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }

//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
}
