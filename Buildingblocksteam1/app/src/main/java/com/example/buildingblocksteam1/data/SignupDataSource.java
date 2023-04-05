package com.example.buildingblocksteam1.data;


import com.example.buildingblocksteam1.data.model.SignedUpUser;


import java.io.IOException;

public class SignupDataSource {

    public Result<SignedUpUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            SignedUpUser fakeUser =
                    new SignedUpUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
