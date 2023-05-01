package com.example.buildingblocksteam1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> linkedlistScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> questions = new MutableLiveData<>();

    public void setLinkedlistScore(String newData) {
        linkedlistScore.setValue(newData);
    }
    public void setQuestions(ArrayList<Question> questions) {
        this.questions.setValue(questions);
    }

    public LiveData<String> getData() {
        return linkedlistScore;
    }
    public LiveData<ArrayList<Question>> getQuestions() {
        return questions;
    }

}