package com.example.buildingblocksteam1;

import java.util.ArrayList;

import javax.crypto.AEADBadTagException;

public class Question {
    private String question;
    private ArrayList<String> answerList;
    private String answer;
    private String feedback;

    public Question(String question, String answer1, String answer2, String answer3, String answer4, String answer, String feedback){
        this.question = question;
        answerList = new ArrayList<String>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        answerList.add(answer4);
        String tempAnswer = answer;
        this.feedback = feedback;

        switch (tempAnswer) {
            case "A":
                this.answer = answer1;
                break;
            case "B":
                this.answer = answer2;
                break;
            case "C":
                this.answer = answer3;
                break;
            case "D":
                this.answer = answer4;
                break;
        }
    }

    public String getQuestion() {
        return question;
    }
    public ArrayList<String> getAnswerList() {
        return answerList;
    }
    public String getAnswer() {
        return answer;
    }
    public String getFeedback() {
        return feedback;
    }
}
