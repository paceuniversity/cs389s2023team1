package com.example.buildingblocksteam1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> linkedListScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> linkedListQuestions = new MutableLiveData<>();

    public void setLinkedlistScore(String newData) {
        linkedListScore.setValue(newData);
    }
    public void setLinkedListQuestions(ArrayList<Question> questions) {
        this.linkedListQuestions.setValue(questions);
    }

    public LiveData<String> getLinkedListScore() {
        return linkedListScore;
    }
    public LiveData<ArrayList<Question>> getLinkedListQuestions() {
        return linkedListQuestions;
    }

}