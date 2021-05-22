package azmithabet.com.bloodoran.ui.activity.login;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import azmithabet.com.bloodoran.R;
import azmithabet.com.bloodoran.databinding.ActivityLoginBinding;
import azmithabet.com.bloodoran.javaMail.SendMail;
import azmithabet.com.bloodoran.model.Donor;
import azmithabet.com.bloodoran.model.Mail;
import azmithabet.com.bloodoran.ui.activity.BaseActivity;
import azmithabet.com.bloodoran.ui.activity.registration.RegistrationActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;

import static azmithabet.com.bloodoran.util.Const.DONE_PROCESS;
import static azmithabet.com.bloodoran.util.Const.EMAIL_EXIST;
import static azmithabet.com.bloodoran.util.Const.ERROR_PROBLEM;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        viewModel=new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLogin(this);
    }
    public void click(int id){
        switch (id)
        {
            case R.id.sign_up:
                startActivity(RegistrationActivity.class);
                 break;
            case R.id.sign_in:
                  signIn();
                break;
            case R.id.forget_password:
                break;

        }
    }

    private void signIn() {
        if (checkFields())
        {
            showProgressDialog("",getString(R.string.loading));
            viewModel.registration(getText(binding.email),getText(binding.password))
                    .observe(this, new Observer<Pair<Integer, Donor>>() {
                        @Override
                        public void onChanged(Pair<Integer, Donor> information) {
                            switch (information.first)
                            {
                                case DONE_PROCESS:

                                    break;
                                case ERROR_PROBLEM:
                                    showToast(R.string.error_problem);
                                    break;
                                case EMAIL_EXIST:
                                    showToast(R.string.email_exist);
                                    break;
                            }
                        }
                    });
        }
    }

    private void startActivity(Class<?> aClass) {
        Intent intent=new Intent(this,aClass);
        startActivity(intent);
    }

    private void sendEmail(String email) {

        SendMail sm = new SendMail();
        sm.sendMail(new Mail(email,getString(R.string.app_name),getString(R.string.recovery_password_mail)))
                .observe(this, mail_status -> {
                    switch (mail_status)
                    {
                        case Message_Sent:
                              hideDialog();
                              showToast(R.string.email_sent);
                            break;
                        case start_sending:
                            showProgressDialog("",getString(R.string.loading));
                            break;
                    }
                });

        //Executing sendmail to send email
        sm.execute();
    }
    private boolean checkFields() {
        boolean isComplete = true;

        if (isEmpty(binding.email)) {
            isComplete = false;
            setErrorEditError(binding.email);
        }
        if (!isValidEmailAddress(getText(binding.email))) {
            isComplete = false;
            binding.email.setError(getString(R.string.email_not_correct));
        }

        if (isEmpty(binding.password)) {
            isComplete = false;
            setErrorEditError(binding.password);
        }

        return isComplete;
    }

}