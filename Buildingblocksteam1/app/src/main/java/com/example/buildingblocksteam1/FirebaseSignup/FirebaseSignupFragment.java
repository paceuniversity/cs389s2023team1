package com.example.buildingblocksteam1.FirebaseSignup;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buildingblocksteam1.FirebaseLogin.FirebaseLoginFragment;
import com.example.buildingblocksteam1.NotificationHelper;
import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentFirebaseSignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirebaseSignupFragment#} factory method to
 * create an instance of this fragment.
 */
public class FirebaseSignupFragment extends Fragment {
    private static final String TAG = "FirebaseSignupFragment";

    private FragmentFirebaseSignupBinding mBinding;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseAuth mAuth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentFirebaseSignupBinding.inflate(inflater, container, false);

        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Buttons

        mBinding.emailCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mBinding.fieldEmail.getText().toString();
                String password = mBinding.fieldPassword.getText().toString();
                String username = mBinding.signupUsername.getText().toString();
                createAccount(email, password, username);

            }
        });


        mBinding.moveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirebaseSignupFragment.this)
                        .navigate(R.id.action_signup_to_login);
            }
        });

        mBinding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirebaseSignupFragment.this)
                        .navigate(R.id.action_reload_to_FirstFragment);
            }
        });


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void createAccount(String email, String password, String username) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null){
                                updateDB(email, username);
                                sendEmailVerification();
                                Log.d(TAG, "email verification was sent to " + email);
                            }
                            else {
                                Log.d(TAG, "email verification was not sent to " + email);
                            }
                            reload();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

    private void sendEmailVerification() {
        // Send verification email
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Re-enable button


                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(),
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(getContext(),
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void reload() {
        mAuth.getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    NavHostFragment.findNavController(FirebaseSignupFragment.this)
                            .navigate(R.id.action_reload_to_FirstFragment);
                    Toast.makeText(getContext(),
                            "You have successfully Signed In!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "reload", task.getException());
                    Toast.makeText(getContext(),
                            "Failed to reload user.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mBinding.fieldEmail.getText().toString();
        String confirm_email = mBinding.signupConfirmEmail.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mBinding.fieldEmail.setError("Required.");
            valid = false;
        } else {
            mBinding.fieldEmail.setError(null);
        }
        if (TextUtils.isEmpty(confirm_email)) {
            mBinding.signupConfirmEmail.setError("Required.");
            valid = false;
        } else {
            mBinding.signupConfirmEmail.setError(null);
        }
        if (!email.equals(confirm_email)){
            mBinding.signupConfirmEmail.setError("Emails do not match.");
            valid = false;
        } else {
            mBinding.signupConfirmEmail.setError(null);
        }


        String password = mBinding.fieldPassword.getText().toString();
        String confirm_password = mBinding.signupConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(password)) {
            mBinding.fieldPassword.setError("Required.");
            valid = false;
        } else {
            mBinding.fieldPassword.setError(null);
        }
        if (TextUtils.isEmpty(confirm_password)) {
            mBinding.signupConfirmPassword.setError("Required.");
            valid = false;
        } else {
            mBinding.signupConfirmPassword.setError(null);
        }

        if (!password.equals(confirm_password)){
            mBinding.signupConfirmPassword.setError("Passwords do not match.");
            valid = false;
        } else {
            mBinding.signupConfirmPassword.setError(null);
        }

        return valid;
    }

    private void updateDB(String email, String username) {
        Map<String, Object> info = new HashMap<>();
        info.put("Email", email);
        info.put("username", username);
        db.collection("UserInformation").add(info);
    }

    public void reminderNotification()
    {
        NotificationHelper notificationUtils = new NotificationHelper(getContext());
        long currentTime = System.currentTimeMillis();
        long oneDayInMillis = 1000 * 60 * 60 * 24;
        long triggerReminder = currentTime + oneDayInMillis; //triggers a reminder after 10 seconds.
        notificationUtils.setReminder(triggerReminder);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}