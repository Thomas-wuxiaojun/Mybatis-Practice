package org.example.pojo;

public class User {
    private Integer id;
    private String username;
    private String gender;
    private String password;
    private String addr;

    public User() {
    }

    public User(Integer id, String username, String gender, String password, String addr) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
