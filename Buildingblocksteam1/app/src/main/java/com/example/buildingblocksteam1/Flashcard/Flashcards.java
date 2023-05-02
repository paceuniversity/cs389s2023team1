package com.example.buildingblocksteam1.Flashcard;

public class Flashcards {

    private String frontSide;
    private String backSide;

    public Flashcards(String frontSide, String backSide) {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public String getBackSide() {
        return backSide;
    }
}
