package azmithabet.com.bloodoran.ui.activity.registration;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import azmithabet.com.bloodoran.IfUserExisting;
import azmithabet.com.bloodoran.model.Donor;

import static azmithabet.com.bloodoran.util.Const.DONE_PROCESS;
import static azmithabet.com.bloodoran.util.Const.EMAIL_EXIST;
import static azmithabet.com.bloodoran.util.Const.ERROR_PROBLEM;
import static azmithabet.com.bloodoran.util.Const.PASSWORD;
import static azmithabet.com.bloodoran.util.Const.USERS_NODE;


public class RegistrationRepository {
    private final DatabaseReference databaseReference;

    public RegistrationRepository() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
      }

    public MutableLiveData<Integer> registration(Donor user) {
        MutableLiveData<Integer> isDone=new MutableLiveData<>();
        user.setPassword(encryptPass(user.getPassword()));
        checkEmail(user.getEmail(), processCode -> {
             if (processCode==DONE_PROCESS)
            {
                 databaseReference.child(USERS_NODE)
                         .child(user.getEmail().replace(".", "0"))
                        .setValue(user)
                        .addOnSuccessListener(
                                aVoid -> isDone.setValue(DONE_PROCESS))
                        .addOnFailureListener(e -> isDone.setValue(ERROR_PROBLEM));
            }
            else {
                 isDone.setValue(processCode);
            }
        });

        return isDone;
    }

    private String encryptPass(String password) {
        try {
            return AESCrypt.encrypt(PASSWORD,password);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return password;
        }
    }

    private void checkEmail(String email, IfUserExisting ifUserExisting) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if (snapshot.hasChild(USERS_NODE)) {
                     if (snapshot.child(USERS_NODE).child(email.replace(".", "0"))
                             .exists()) {
                         ifUserExisting.ifUserExisting(EMAIL_EXIST);
                     }
                     else {
                          ifUserExisting.ifUserExisting(DONE_PROCESS);
                     }
                }
                else {
                     ifUserExisting.ifUserExisting(DONE_PROCESS);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                  ifUserExisting.ifUserExisting(ERROR_PROBLEM);
            }
        });
    }

//    public MutableLiveData<User> signIn(String email, String password) {
//        try {
//            password= AESCrypt.encrypt("password",password);
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
//        signInUserMutableLiveData = new MutableLiveData<>();
//        databaseReference = FirebaseDatabase.getInstance().getReference(USERS_NODE);
//
//        String finalPassword = password;
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChild(email.replace(".",
//                        "0"))) {
//                    String pass = snapshot.child(email.replace(".", "0"))
//                            .child(PASSWORD).getValue(String.class);
//                     if (pass.equals(finalPassword)) {
//                        User user = snapshot.child(email.replace(".", "0")).getValue(User.class);
//                        signInUserMutableLiveData.setValue(user);
//                    } else {
//                        signInUserMutableLiveData.setValue(null);
//                    }
//                }
//                else {
//                    signInUserMutableLiveData.setValue(null);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        return signInUserMutableLiveData;
//    }

}
