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
    public enum  MAIL_STATUS
    {
        start_sending,Message_Sent
    }
    public static final String PASSWORD = "password";
    public static final String USERS_NODE = "users";

    public static final String COORDINATES = "coordinates";

    public static final int ERROR_PROBLEM = 0;
    public static final int DONE_PROCESS = 1;
    public static final int EMAIL_EXIST = 2;
    public static final int ERROR_INFORMATION =3;// login

    public static final String EMAIL ="blooadoran2021@gmail.com";
    public static final String PASSWORD_MAIL ="01147598412";

    public static final String DONOR_TYPE_ST ="donor_type";

    public static final int HOME_FRAGMENT =0;
    public static final int NOTIFICATION_FRAGMENT =1;
    public static final int PROFILE_FRAGMENT =2;
    public static final int STATICS_FRAGMENT =3;

}

