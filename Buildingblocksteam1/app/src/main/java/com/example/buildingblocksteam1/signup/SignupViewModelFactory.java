package com.example.buildingblocksteam1.signup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.buildingblocksteam1.data.SignupDataSource;
import com.example.buildingblocksteam1.data.SignupRepository;


public class SignupViewModelFactory implements ViewModelProvider.Factory{

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SignupViewModel.class)) {
            return (T) new SignupViewModel(SignupRepository.getInstance(new SignupDataSource()));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
