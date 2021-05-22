package azmithabet.com.bloodoran.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.tiper.MaterialSpinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import azmithabet.com.bloodoran.R;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void hidStatusBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }


    public void showProgressDialog(String title, @NonNull String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(true);
        }
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }


    public void hideDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


    protected void showToast(int mToastMsg) {
        Toast.makeText(this, mToastMsg, Toast.LENGTH_SHORT).show();
    }

    public String getText(TextInputEditText inputEditText)
    {
        return inputEditText.getText().toString();
    }

    public boolean isEmpty(TextInputEditText inputEditText)
    {
        return inputEditText.getText().toString().isEmpty();
    }

    public void setErrorEditError(TextInputEditText inputEditText) {
        inputEditText.setError(getString(R.string.requried));
    }
    public void setErrorEditError(MaterialSpinner inputEditText) {
        inputEditText.setError(getString(R.string.requried));
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}