package com.example.buildingblocksteam1.data;

import com.example.buildingblocksteam1.data.model.LoggedInUser;
import com.example.buildingblocksteam1.data.model.SignedUpUser;

public class SignupRepository {
    public static volatile SignupRepository instance;

    public SignupDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    public SignedUpUser user = null;

    // private constructor : singleton access
    public SignupRepository(SignupDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static SignupRepository getInstance(SignupDataSource dataSource) {
        if (instance == null) {
            instance = new SignupRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    public void setLoggedInUser(SignedUpUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<SignedUpUser> login(String username, String password) {
        // handle login
        Result<SignedUpUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<SignedUpUser>) result).getData());
        }
        return result;
    }
}
