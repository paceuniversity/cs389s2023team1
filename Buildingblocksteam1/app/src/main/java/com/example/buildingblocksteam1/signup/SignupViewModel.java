package com.example.buildingblocksteam1.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.buildingblocksteam1.data.LoginRepository;
import com.example.buildingblocksteam1.data.Result;
import com.example.buildingblocksteam1.data.SignupRepository;
import com.example.buildingblocksteam1.data.model.LoggedInUser;
import com.example.buildingblocksteam1.R;
import com.example.buildingblocksteam1.data.model.SignedUpUser;


public class SignupViewModel extends ViewModel {


    private MutableLiveData<SignupFormState> SignupFormState = new MutableLiveData<>();
    private MutableLiveData<SignupResult> SignupResult = new MutableLiveData<>();

    private SignupRepository SignupRepository;


    SignupViewModel(SignupRepository SignupRepository) {
        this.SignupRepository = SignupRepository;
    }
    LiveData<SignupFormState> getSignupFormState() {
        return SignupFormState;
    }

    LiveData<SignupResult> getSignupResult() {
        return SignupResult;
    }

    public void signup(String username, String password) {
        // can be launched in a separate asynchronous job
        Result<SignedUpUser> result = SignupRepository.login(username, password);

        if (result instanceof Result.Success) {
            SignedUpUser data = ((Result.Success<SignedUpUser>) result).getData();
            SignupResult.setValue(new SignupResult(new SignedupUserView(data.getDisplayName())));
        } else {
            SignupResult.setValue(new SignupResult(R.string.login_failed));
        }
    }

    public void SignupDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            SignupFormState.setValue(new SignupFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            SignupFormState.setValue(new SignupFormState(null, R.string.invalid_password));
        } else {
            SignupFormState.setValue(new SignupFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
