package azmithabet.com.bloodoran.ui.activity.login;

import androidx.appcompat.app.AppCompatActivity;
import azmithabet.com.bloodoran.R;
import azmithabet.com.bloodoran.ui.activity.registration.RegistrationActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.ActionCodeSettings;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void click(int id){
        switch (id)
        {
            case R.id.registration:

                 break;
            case R.id.login:
                break;
        }
    }

    private void startActivity(Class<?> aClass) {
        Intent intent=new Intent(this,aClass);
        startActivity(intent);
    }

    private void sendCode(){
        ActionCodeSettings actionCodeSettings =
                ActionCodeSettings.newBuilder()
                        // URL you want to redirect back to. The domain (www.example.com) for this
                        // URL must be whitelisted in the Firebase Console.
                        .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                        // This must be true
                        .setHandleCodeInApp(true)
                        .setIOSBundleId("com.example.ios")
                        .setAndroidPackageName(
                                "com.example.android",
                                true, /* installIfNotAvailable */
                                "12"    /* minimumVersion */)
                        .build();
    }
}