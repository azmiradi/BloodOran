package azmithabet.com.bloodoran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import azmithabet.com.bloodoran.databinding.ActivityMainBinding;
import azmithabet.com.bloodoran.databinding.ActivityRegistrationBinding;
import azmithabet.com.bloodoran.ui.activity.login.LoginActivity;
import azmithabet.com.bloodoran.ui.activity.registration.RegistrationActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setMainactivity(this);
    }
    public void click(int id){
        switch (id)
        {
            case R.id.registration:
                startActivity(RegistrationActivity.class);
                break;
            case R.id.login:
                startActivity(LoginActivity.class);
                break;
        }
    }

    private void startActivity(Class<?> aClass) {
        Intent intent=new Intent(this,aClass);
        startActivity(intent);
    }
}