package com.example.buildingblocksteam1.signup;

import android.content.Intent;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;

import com.example.buildingblocksteam1.signup.SignedupUserView;


public class SignupResult {

    @Nullable
    private SignedupUserView success;
    @Nullable
    private Integer error;

    SignupResult(@Nullable Integer error) {
        this.error = error;
    }

    SignupResult(@Nullable SignedupUserView success) {
        this.success = success;
    }

    @Nullable
    SignedupUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }


}
