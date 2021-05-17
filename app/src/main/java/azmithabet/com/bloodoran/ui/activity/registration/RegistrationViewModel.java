package azmithabet.com.bloodoran.ui.activity.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import azmithabet.com.bloodoran.model.User;

public class RegistrationViewModel extends ViewModel {

    private final RegistrationRepository registrationRepository=new RegistrationRepository();

    public LiveData<Integer> registration(User user) {
        return registrationRepository.registration(user);
     }


 }
