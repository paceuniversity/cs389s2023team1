package com.example.buildingblocksteam1.signup;

public class SignedupUserView {

    private String displayName;
    //... other data fields that may be accessible to the UI

    SignedupUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }

}
