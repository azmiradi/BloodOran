package azmithabet.com.bloodoran.model;

import azmithabet.com.bloodoran.util.Const;

public class Donor {
    private String birthDate;
    private Const.SEX_TYPE sex_type;
    private String medicalHistory;
    private String bloodType;
    private Const.DONOR_TYPE donor_type;

    private String name;
    private String email;
    private String password;
    private Coordinates coordinates;
    private String phone;
    private Const.USER_TYPE user_type;

    public Donor() {
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Const.DONOR_TYPE getDonor_type() {
        return donor_type;
    }

    public void setDonor_type(Const.DONOR_TYPE donor_type) {
        this.donor_type = donor_type;
    }

    public Donor(String name, String email, String password,
                 Coordinates coordinates,
                 String phone, String birthDate, Const.SEX_TYPE sex_type,
                 String medicalHistory, Const.USER_TYPE user_type, String bloodType, Const.DONOR_TYPE donor_type) {

        this.birthDate = birthDate;
        this.sex_type = sex_type;
        this.medicalHistory = medicalHistory;
        this.bloodType = bloodType;
        this.donor_type = donor_type;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coordinates = coordinates;
        this.phone = phone;
        this.user_type=user_type;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Const.SEX_TYPE getSex_type() {
        return sex_type;
    }

    public void setSex_type(Const.SEX_TYPE sex_type) {
        this.sex_type = sex_type;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
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
