package com.example.buildingblocksteam1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> linkedlistScore = new MutableLiveData<>();

    public void setLinkedlistScore(String newData) {
        linkedlistScore.setValue(newData);
    }

    public LiveData<String> getData() {
        return linkedlistScore;
    }
}