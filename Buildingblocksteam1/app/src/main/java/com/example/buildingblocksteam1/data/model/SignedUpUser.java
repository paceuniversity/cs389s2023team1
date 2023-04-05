package com.example.buildingblocksteam1.data.model;

public class SignedUpUser {

    private String userId;
    private String displayName;

    public SignedUpUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
