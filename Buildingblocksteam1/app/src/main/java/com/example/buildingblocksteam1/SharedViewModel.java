package com.example.buildingblocksteam1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> linkedListScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> linkedListQuestions = new MutableLiveData<>();

    public void setLinkedListScore(String newData) {
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

    private MutableLiveData<String> stacksScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> stacksQuestions = new MutableLiveData<>();

    public void setStacksScore(String newData) {
        stacksScore.setValue(newData);
    }
    public void setStacksQuestions(ArrayList<Question> questions) {
        this.stacksQuestions.setValue(questions);
    }

    public LiveData<String> getStacksScore() {
        return stacksScore;
    }
    public LiveData<ArrayList<Question>> getStacksQuestions() {
        return stacksQuestions;
    }
    private MutableLiveData<String> queuesScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> queuesQuestions = new MutableLiveData<>();

    public void setQueuesScore(String newData) {
        queuesScore.setValue(newData);
    }
    public void setQueuesQuestions(ArrayList<Question> questions) {
        this.queuesQuestions.setValue(questions);
    }

    public LiveData<String> getQueuesScore() {
        return queuesScore;
    }
    public LiveData<ArrayList<Question>> getQueuesQuestions() {
        return queuesQuestions;
    }
    private MutableLiveData<String> treesScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> treesQuestions = new MutableLiveData<>();

    public void setTreesScore(String newData) {
        treesScore.setValue(newData);
    }
    public void setTreesQuestions(ArrayList<Question> questions) {
        this.treesQuestions.setValue(questions);
    }

    public LiveData<String> getTreesScore() {
        return treesScore;
    }
    public LiveData<ArrayList<Question>> getTreesQuestions() {
        return treesQuestions;
    }
    private MutableLiveData<String> graphsScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> graphsQuestions = new MutableLiveData<>();

    public void setGraphsScore(String newData) {
        graphsScore.setValue(newData);
    }
    public void setGraphsQuestions(ArrayList<Question> questions) {
        this.graphsQuestions.setValue(questions);
    }

    public LiveData<String> getGraphsScore() {
        return graphsScore;
    }
    public LiveData<ArrayList<Question>> getGraphsQuestions() {
        return graphsQuestions;
    }
    private MutableLiveData<String> hashTablesScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> hashTablesQuestions = new MutableLiveData<>();

    public void setHashTablesScore(String newData) {
        hashTablesScore.setValue(newData);
    }
    public void setHashTablesQuestions(ArrayList<Question> questions) {
        this.hashTablesQuestions.setValue(questions);
    }

    public LiveData<String> getHashTablesScore() {
        return hashTablesScore;
    }
    public LiveData<ArrayList<Question>> getHashTablesQuestions() {
        return hashTablesQuestions;
    }
    private MutableLiveData<String> arraysScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> arraysQuestions = new MutableLiveData<>();

    public void setArraysScore(String newData) {
        arraysScore.setValue(newData);
    }
    public void setArraysQuestions(ArrayList<Question> questions) {
        this.arraysQuestions.setValue(questions);
    }

    public LiveData<String> getArraysScore() {
        return arraysScore;
    }
    public LiveData<ArrayList<Question>> getArraysQuestions() {
        return arraysQuestions;
    }
    private MutableLiveData<String> heapsScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> heapsQuestions = new MutableLiveData<>();

    public void setHeapsScore(String newData) {
        heapsScore.setValue(newData);
    }
    public void setHeapsQuestions(ArrayList<Question> questions) {
        this.heapsQuestions.setValue(questions);
    }

    public LiveData<String> getHeapsScore() {
        return heapsScore;
    }
    public LiveData<ArrayList<Question>> getHeapsQuestions() {
        return heapsQuestions;
    }
    private MutableLiveData<String> sortingScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> sortingQuestions = new MutableLiveData<>();

    public void setSortingScore(String newData) {
        sortingScore.setValue(newData);
    }
    public void setSortingQuestions(ArrayList<Question> questions) {
        this.sortingQuestions.setValue(questions);
    }

    public LiveData<String> getSortingScore() {
        return sortingScore;
    }
    public LiveData<ArrayList<Question>> getSortingQuestions() {
        return sortingQuestions;
    }
    private MutableLiveData<String> searchingScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> searchingQuestions = new MutableLiveData<>();

    public void setSearchingScore(String newData) {
        searchingScore.setValue(newData);
    }
    public void setSearchingQuestions(ArrayList<Question> questions) {
        this.searchingQuestions.setValue(questions);
    }

    public LiveData<String> getSearchingScore() {
        return searchingScore;
    }
    public LiveData<ArrayList<Question>> getSearchingQuestions() {
        return searchingQuestions;
    }
    private MutableLiveData<String> greedyScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> greedyQuestions = new MutableLiveData<>();

    public void setGreedyScore(String newData) {
        greedyScore.setValue(newData);
    }
    public void setGreedyQuestions(ArrayList<Question> questions) {
        this.greedyQuestions.setValue(questions);
    }

    public LiveData<String> getGreedyScore() {
        return greedyScore;
    }
    public LiveData<ArrayList<Question>> getGreedyQuestions() {
        return greedyQuestions;
    }
    private MutableLiveData<String> divideAndConquerScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> divideAndConquerQuestions = new MutableLiveData<>();

    public void setDivideAndConquerScore(String newData) {
        divideAndConquerScore.setValue(newData);
    }
    public void setDivideAndConquerQuestions(ArrayList<Question> questions) {
        this.divideAndConquerQuestions.setValue(questions);
    }

    public LiveData<String> getDivideAndConquerScore() {
        return divideAndConquerScore;
    }
    public LiveData<ArrayList<Question>> getDivideAndConquerQuestions() {
        return divideAndConquerQuestions;
    }
    private MutableLiveData<String> dynamicScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> dynamicQuestions = new MutableLiveData<>();

    public void setDynamicScore(String newData) {
        dynamicScore.setValue(newData);
    }
    public void setDynamicQuestions(ArrayList<Question> questions) {
        this.dynamicQuestions.setValue(questions);
    }

    public LiveData<String> getDynamicScore() {
        return dynamicScore;
    }
    public LiveData<ArrayList<Question>> getDynamicQuestions() {
        return dynamicQuestions;
    }
    private MutableLiveData<String> backtrackingScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> backtrackingQuestions = new MutableLiveData<>();

    public void setBacktrackingScore(String newData) {
        backtrackingScore.setValue(newData);
    }
    public void setBacktrackingQuestions(ArrayList<Question> questions) {
        this.backtrackingQuestions.setValue(questions);
    }

    public LiveData<String> getBacktrackingScore() {
        return backtrackingScore;
    }
    public LiveData<ArrayList<Question>> getBacktrackingQuestions() {
        return backtrackingQuestions;
    }
    private MutableLiveData<String> bruteForceScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> bruteForceQuestions = new MutableLiveData<>();

    public void setBruteForceScore(String newData) {
        bruteForceScore.setValue(newData);
    }
    public void setBruteForceQuestions(ArrayList<Question> questions) {
        this.bruteForceQuestions.setValue(questions);
    }

    public LiveData<String> getBruteForceScore() {
        return bruteForceScore;
    }
    public LiveData<ArrayList<Question>> getBruteForceQuestions() {
        return bruteForceQuestions;
    }
    private MutableLiveData<String> randomizedScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> randomizedQuestions = new MutableLiveData<>();

    public void setRandomizedScore(String newData) {
        randomizedScore.setValue(newData);
    }
    public void setRandomizedQuestions(ArrayList<Question> questions) {
        this.randomizedQuestions.setValue(questions);
    }

    public LiveData<String> getRandomizedScore() {
        return randomizedScore;
    }
    public LiveData<ArrayList<Question>> getRandomizedQuestions() {
        return randomizedQuestions;
    }
    private MutableLiveData<String> stringMatchingScore = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Question>> stringMatchingQuestions = new MutableLiveData<>();

    public void setStringMatchingScore(String newData) {
        stringMatchingScore.setValue(newData);
    }
    public void setStringMatchingQuestions(ArrayList<Question> questions) {
        this.stringMatchingQuestions.setValue(questions);
    }

    public LiveData<String> getStringMatchingScore() {
        return stringMatchingScore;
    }
    public LiveData<ArrayList<Question>> getStringMatchingQuestions() {
        return stringMatchingQuestions;
    }


}