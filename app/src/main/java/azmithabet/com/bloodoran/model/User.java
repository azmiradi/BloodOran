package azmithabet.com.bloodoran.model;

import azmithabet.com.bloodoran.util.Const;

public class User {
    private String name;
    private String email;
    private String password;
    private Location  location;
    private String phone;
    private Const.USER_TYPE user_type;
    public User( String name, String email, String password,
                Location location, String phone,Const.USER_TYPE user_type) {
         this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.phone = phone;
        this.user_type=user_type;
    }

    public Const.USER_TYPE getUser_type() {
        return user_type;
    }

    public void setUser_type(Const.USER_TYPE user_type) {
        this.user_type = user_type;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

