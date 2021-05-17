package azmithabet.com.bloodoran.util;

public class Const {

    public enum  USER_TYPE
    {
        Donor,Recipients
    }
    public enum  RECIPIENTS_TYPE
    {
        Hospital,blood_bank
    }
    public enum  SEX_TYPE
    {
        male,female
    }
    public enum  DONOR_TYPE
    {
        blood,organs
    }
    public static final String PASSWORD = "password";
    public static final String USERS_NODE = "users";

    public static final int ERROR_PROBLEM = 0;
    public static final int DONE_PROCESS = 1;
    public static final int EMAIL_EXIST = 2;
    public static final int ERROR_INFORMATION =3;


}

