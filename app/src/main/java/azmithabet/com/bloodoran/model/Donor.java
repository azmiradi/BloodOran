package azmithabet.com.bloodoran.model;

import azmithabet.com.bloodoran.util.Const;

public class Donor extends User{
    private String birthDate;
    private Const.SEX_TYPE sex_type;
    private String medicalHistory;
    private String bloodType;
    private Const.DONOR_TYPE donor_type;

    public Donor( String name, String email, String password,
                 Location location,
                 String phone, String birthDate, Const.SEX_TYPE sex_type,
                 String medicalHistory,Const.USER_TYPE user_type,String bloodType,Const.DONOR_TYPE donor_type) {
        super( name, email, password, location, phone,user_type);
        this.birthDate = birthDate;
        this.sex_type = sex_type;
        this.medicalHistory = medicalHistory;
        this.bloodType = bloodType;
        this.donor_type = donor_type;

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
}
