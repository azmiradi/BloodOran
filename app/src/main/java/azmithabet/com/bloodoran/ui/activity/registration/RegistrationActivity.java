package azmithabet.com.bloodoran.ui.activity.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.shivtechs.maplocationpicker.LocationPickerActivity;
import com.shivtechs.maplocationpicker.MapUtility;
import com.tiper.MaterialSpinner;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.databinding.DataBindingUtil;
 import androidx.lifecycle.ViewModelProvider;
import azmithabet.com.bloodoran.R;
import azmithabet.com.bloodoran.databinding.ActivityRegistrationBinding;
import azmithabet.com.bloodoran.model.Donor;
import azmithabet.com.bloodoran.model.Location;
import azmithabet.com.bloodoran.model.Recipients;
import azmithabet.com.bloodoran.model.User;
import azmithabet.com.bloodoran.ui.activity.BaseActivity;
import azmithabet.com.bloodoran.util.Const;

import static azmithabet.com.bloodoran.util.Const.DONE_PROCESS;
import static azmithabet.com.bloodoran.util.Const.EMAIL_EXIST;
import static azmithabet.com.bloodoran.util.Const.ERROR_PROBLEM;

public class RegistrationActivity extends BaseActivity {
    private static final int ADDRESS_PICKER_REQUEST = 1;
    private ActivityRegistrationBinding binding;
    private Location location;
    private ArrayAdapter<String> genderAdp,countryAdp,userTypeAdp,bloodTypeAdp,donorTypeAdp;

    private Const.USER_TYPE user_type = Const.USER_TYPE.Donor;
    private Const.DONOR_TYPE donor_type = null;

    private Const.SEX_TYPE sex_type = Const.SEX_TYPE.male;
    private Const.RECIPIENTS_TYPE recipients_type=Const.RECIPIENTS_TYPE.Hospital;
    private RegistrationViewModel registrationViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_registration);
        initialization();

    }

    private void initialization() {
        binding.setRegistration(this);
        MapUtility.apiKey = getResources().getString(R.string.maps_key);
        location = new Location();
        initializationAdps();
        registrationViewModel=new ViewModelProvider(this).get(RegistrationViewModel.class);
        listeningSpinners();
    }

    private void initializationAdps() {
        genderAdp= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, toArrayList(R.array.gender));
        binding.gender.setAdapter(genderAdp);

        countryAdp= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, toArrayList(R.array.country));
        binding.country.setAdapter(countryAdp);

        userTypeAdp= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, toArrayList(R.array.user_type));
        binding.userType.setAdapter(userTypeAdp);
        binding.userType.setSelection(0);

        bloodTypeAdp= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, toArrayList(R.array.blood_type));
        binding.bloodType.setAdapter(bloodTypeAdp);

        donorTypeAdp= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, toArrayList(R.array.donor_type));
        binding.donorType.setAdapter(donorTypeAdp);
        binding.donorType.setSelection(0);
        donor_type= Const.DONOR_TYPE.blood;
    }
   private List<String> toArrayList(int array){
      return Arrays.asList(getResources().getStringArray(array));
   }
    private void listeningSpinners() {

        binding.userType.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
                if (toArrayList(R.array.user_type).get(i)
                        .equalsIgnoreCase(getString(R.string.donor))) {

                    user_type = Const.USER_TYPE.Donor;
                    binding.birthdayBox.setVisibility(View.VISIBLE);
                    binding.gender.setVisibility(View.VISIBLE);
                    binding.medicalHistoryBox.setVisibility(View.VISIBLE);
                    binding.bloodType.setVisibility(View.VISIBLE);
                    binding.donorType.setVisibility(View.VISIBLE);

                    //binding.recipientsType.setVisibility(View.GONE);

                } else {
                    user_type = Const.USER_TYPE.Recipients;
                    binding.birthdayBox.setVisibility(View.GONE);
                    binding.gender.setVisibility(View.GONE);
                //    binding.recipientsType.setVisibility(View.VISIBLE);
                    binding.medicalHistoryBox.setVisibility(View.GONE);
                    binding.bloodType.setVisibility(View.GONE);
                    binding.donorType.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(MaterialSpinner materialSpinner) {

            }
        });

       binding.donorType.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
           @Override
           public void onItemSelected(MaterialSpinner materialSpinner, View view, int i, long l) {
               if (toArrayList(R.array.donor_type).get(i).
                       equalsIgnoreCase(getString(R.string.organs)))
               {
                   donor_type=Const.DONOR_TYPE.organs;
               }
               else {
                   donor_type= Const.DONOR_TYPE.blood;
               }
           }

           @Override
           public void onNothingSelected(MaterialSpinner materialSpinner) {

           }
       });
    }


    private boolean checkFields() {
        boolean isComplete = true;
        if (isEmpty(binding.name)) {
            isComplete = false;
            setErrorEditError(binding.name);
        }
        if (isEmpty(binding.email)) {
            isComplete = false;
            setErrorEditError(binding.email);
        }
        if (!isValidEmailAddress(getText(binding.email))) {
            isComplete = false;
           binding.email.setError(getString(R.string.email_not_correct));
        }
        if (!isPasswordMatched(getText(binding.password),getText(binding.confirmPass))) {
            isComplete = false;
            binding.email.setError(getString(R.string.password_not_confirmed));
        }
        if (isEmpty(binding.password)) {
            isComplete = false;
            setErrorEditError(binding.password);
        }
        if (isEmpty(binding.confirmPass)) {
            isComplete = false;
            setErrorEditError(binding.confirmPass);
        }
        if (isEmpty(binding.phoneNumber)) {
            isComplete = false;
            setErrorEditError(binding.phoneNumber);
        }
        if (location.getLat() == 0 && location.getLng() == 0) {
            showToast(R.string.select_location);
            isComplete=false;
        }
        if (binding.country.getSelectedItemId()<0)
        {
            setErrorEditError(binding.country);

        }
        if (user_type.equals(Const.USER_TYPE.Donor)) {
            if (isEmpty(binding.medicalHistory)) {
                isComplete = false;
                setErrorEditError(binding.medicalHistory);
            }
            if (isEmpty(binding.birthday)) {
                isComplete = false;
                setErrorEditError(binding.birthday);
            }
            if (binding.bloodType.getSelectedItemId()<0)
            {
                setErrorEditError(binding.bloodType);

            }
            if (binding.gender.getSelectedItemId()<0)
            {
                setErrorEditError(binding.gender);

            }
        }

        return isComplete;
    }

    public void onLocationSelectPick() {
        Intent i = new Intent(this, LocationPickerActivity.class);
        startActivityForResult(i, ADDRESS_PICKER_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADDRESS_PICKER_REQUEST) {
            try {
                if (data != null && data.getStringExtra(MapUtility.ADDRESS) != null) {
                    String address = data.getStringExtra(MapUtility.ADDRESS);
                    double latitude = data.getDoubleExtra(MapUtility.LATITUDE, 0.0);
                    double longitude = data.getDoubleExtra(MapUtility.LONGITUDE, 0.0);
                    //binding.locationText.setText(address);

                    location.setAddress(address);
                    location.setLat(latitude);
                    location.setLng(longitude);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void registration(){
        User user = null;
        if (checkFields())
        {
            showProgressDialog("",getString(R.string.loading));
            switch (user_type)
            {
                case Donor:
                    user=new Donor(getText(binding.name),getText(binding.email),
                            getText(binding.password),location,getText(binding.phoneNumber)
                    ,getText(binding.birthday),sex_type,
                            getText(binding.medicalHistory),user_type,binding.bloodType.getSelectedItem().toString()
                    ,donor_type);
                    break;
                case Recipients:
                    user=new Recipients(getText(binding.name),getText(binding.email),
                            getText(binding.password),location,getText(binding.phoneNumber),user_type,recipients_type);
                    break;
            }
            registrationViewModel.registration(user)
                    .observe(this, processCode -> {
                        hideDialog();
                        switch (processCode)
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
                    });
        }
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public boolean isPasswordMatched(String pass,String confirmPass)
    {
        return pass.equals(confirmPass);
    }
    public void birthDate(){
        new SpinnerDatePickerDialogBuilder()
                .context(RegistrationActivity.this)
                .showTitle(false)
                .callback((view, year, monthOfYear, dayOfMonth) -> {
                    int month=monthOfYear+1;
                    binding.birthday.setText(year+"-"+month+"-"+dayOfMonth);
                })
                .spinnerTheme(R.style.NumberPickerStyle)
                .showTitle(true)
                .showDaySpinner(true)
                .build()
                .show();
    }
}