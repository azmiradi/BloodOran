package azmithabet.com.bloodoran.model;

import azmithabet.com.bloodoran.util.Const;

public class Recipients {
    private Const.RECIPIENTS_TYPE recipients_type;
    private String name;
    private String email;
    private String password;
    private Coordinates coordinates;
    private String phone;
    private Const.USER_TYPE user_type;
    public Recipients(String name, String email, String password,
                      Coordinates coordinates, String phone, Const.USER_TYPE user_type
            , Const.RECIPIENTS_TYPE recipients_type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.coordinates = coordinates;
        this.phone = phone;
        this.user_type=user_type;
        this.recipients_type = recipients_type;
    }

    public Const.RECIPIENTS_TYPE getRecipients_type() {
        return recipients_type;
    }

    public void setRecipients_type(Const.RECIPIENTS_TYPE recipients_type) {
        this.recipients_type = recipients_type;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
