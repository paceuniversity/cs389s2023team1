package com.example.buildingblocksteam1.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.databinding.FragmentSignupBinding;
import com.example.buildingblocksteam1.signup.SignupViewModel;
import com.example.buildingblocksteam1.ui.login.LoginViewModelFactory;


import org.w3c.dom.Text;


public class SignupFragment extends Fragment {

    private SignupViewModel SignupViewModel;
    private FragmentSignupBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SignupViewModel = new ViewModelProvider(this, new SignupViewModelFactory())
                .get(SignupViewModel.class);

        final EditText emailEditText = binding.signupEmail;
        final EditText passwordEditText = binding.signupPassword;
        final Button signupButton = binding.signupButton;
        final TextView loginText = binding.moveToLogin;


        SignupViewModel.getSignupFormState().observe(getViewLifecycleOwner(), new Observer<SignupFormState>() {
            @Override
            public void onChanged(@Nullable SignupFormState SignupFormState) {
                if (SignupFormState == null) {
                    return;
                }
                signupButton.setEnabled(SignupFormState.isDataValid());
                if (SignupFormState.getUsernameError() != null) {
                    emailEditText.setError(getString(SignupFormState.getUsernameError()));
                }
                if (SignupFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(SignupFormState.getPasswordError()));
                }
            }
        });

        SignupViewModel.getSignupResult().observe(getViewLifecycleOwner(), new Observer<SignupResult>() {
            @Override
            public void onChanged(@Nullable SignupResult SignupResult) {
                if (SignupResult == null) {
                    return;
                }
                if (SignupResult.getError() != null) {
                    showLoginFailed(SignupResult.getError());
                }
                if (SignupResult.getSuccess() != null) {
                    updateUiWithUser(SignupResult.getSuccess());
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                SignupViewModel.SignupDataChanged(emailEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        emailEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        /*
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // TODO: Fix signup button

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    SignupViewModel.login(emailEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }

        });*/

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO : Make signup command
                /*
                SignupViewModel.login(emailEditText.getText().toString(),
                        passwordEditText.getText().toString());

                 */
            }
        });

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SignupFragment.this)
                        .navigate(R.id.action_signup_to_login);
            }
        });
    }


    private void updateUiWithUser(SignedupUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(getContext().getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
        }
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(
                    getContext().getApplicationContext(),
                    errorString,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

