package model;

import java.util.List;

public class Contest {
    int id;
    int numberOfQuestions;
    List<Integer> questions;

    public Contest(int numberOfQuestions, List<Integer> questions) {
        this.numberOfQuestions = numberOfQuestions;
        this.questions = questions;
        this.id = this.id + 1;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

}
