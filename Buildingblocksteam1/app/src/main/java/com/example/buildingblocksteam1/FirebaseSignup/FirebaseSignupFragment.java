package com.example.buildingblocksteam1.FirebaseSignup;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentFirebaseSignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorResolver;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirebaseSignupFragment#} factory method to
 * create an instance of this fragment.
 */
public class FirebaseSignupFragment extends Fragment {
    private static final String TAG = "FirebaseSignupFragment";

    private FragmentFirebaseSignupBinding mBinding;

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

        final TextView loginText = mBinding.moveToLogin;

        // Buttons

        mBinding.emailCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mBinding.fieldEmail.getText().toString();
                String password = mBinding.fieldPassword.getText().toString();
                createAccount(email, password);
            }
        });

        mBinding.verifyEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmailVerification();
            }
        });


        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirebaseSignupFragment.this)
                        .navigate(R.id.action_signup_to_login);
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

    private void createAccount(String email, String password) {
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
        // Disable button
        mBinding.verifyEmailButton.setEnabled(false);

        // Send verification email
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Re-enable button
                        mBinding.verifyEmailButton.setEnabled(true);

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


    //CHECKS FOR MULTIFACTOR
    /*
    private void checkForMultiFactorFailure(Exception e) {
        // Multi-factor authentication with SMS is currently only available for
        // Google Cloud Identity Platform projects. For more information:
        // https://cloud.google.com/identity-platform/docs/android/mfa
        if (e instanceof FirebaseAuthMultiFactorException) {
            Log.w(TAG, "multiFactorFailure", e);
            MultiFactorResolver resolver = ((FirebaseAuthMultiFactorException) e).getResolver();
            Bundle args = new Bundle();
            args.putParcelable(MultiFactorSignInFragment.EXTRA_MFA_RESOLVER, resolver);
            args.putBoolean(MultiFactorFragment.RESULT_NEEDS_MFA_SIGN_IN, true);
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_emailpassword_to_mfa, args);
        }
    }
*/


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}