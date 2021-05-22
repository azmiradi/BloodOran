package azmithabet.com.bloodoran.ui.activity.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import azmithabet.com.bloodoran.model.Donor;

public class RegistrationViewModel extends ViewModel {

    private final RegistrationRepository registrationRepository=new RegistrationRepository();

    public LiveData<Integer> registration(Donor user) {
        return registrationRepository.registration(user);
     }


 }
