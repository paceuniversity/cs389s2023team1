package com.example.buildingblocksteam1.FirebaseLogin;

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
import android.widget.Toast;

import com.example.buildingblocksteam1.FirebaseSignup.FirebaseSignupFragment;
import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentFirebaseLoginBinding;
import com.example.buildingblocksteam1.databinding.FragmentFirebaseSignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirebaseLoginFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirebaseLoginFragment extends Fragment {

    private static final String TAG = "FirebaseLoginFragment";

    private FragmentFirebaseLoginBinding mBinding;

    private FirebaseAuth mAuth;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentFirebaseLoginBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            reload();
        }
        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mBinding.loginEmail.getText().toString();
                String password = mBinding.loginPassword.getText().toString();
                LogIn(email, password);
            }
        });
        mAuth = FirebaseAuth.getInstance();

    }

    private void LogIn(String email, String password) {
        Log.d(TAG, "Login:" + email);
        if (!validateForm()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "LoginWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            reload();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "LoginWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            reload();


                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mBinding.loginEmail.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mBinding.loginEmail.setError("Required.");
            valid = false;
        } else {
            mBinding.loginEmail.setError(null);
        }

        String password = mBinding.loginPassword.getText().toString();

        if (TextUtils.isEmpty(password)) {
            mBinding.loginPassword.setError("Required.");
            valid = false;
        } else {
            mBinding.loginPassword.setError(null);
        }

        return valid;
    }




    private void reload() {
        mAuth.getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    NavHostFragment.findNavController(FirebaseLoginFragment.this)
                            .navigate(R.id.action_reload_to_FirstFragment2);
                    Toast.makeText(getContext(),
                            "You have successfully Logged In!",
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
}
