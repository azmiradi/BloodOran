package azmithabet.com.bloodoran.model;

import azmithabet.com.bloodoran.util.Const;

public class Recipients extends User{
    private Const.RECIPIENTS_TYPE recipients_type;

    public Recipients( String name, String email, String password,
                      Location location, String phone,Const.USER_TYPE user_type
            , Const.RECIPIENTS_TYPE recipients_type) {
        super( name, email, password, location, phone,user_type);
        this.recipients_type = recipients_type;
    }
}
