package com.Quiz.App.models;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class QuestionAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizAttempt getQuizAttempt() {
        return quizAttempt;
    }

    public void setQuizAttempt(QuizAttempt quizAttempt) {
        this.quizAttempt = quizAttempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<String> getSelectedChoices() {
        return selectedChoices;
    }

    public void setSelectedChoices(Set<String> selectedChoices) {
        this.selectedChoices = selectedChoices;
    }

    @ManyToOne
    @JoinColumn(name = "quiz_attempt_id")
    private QuizAttempt quizAttempt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ElementCollection
    @CollectionTable(name = "user_selected_choices", joinColumns = @JoinColumn(name = "question_attempt_id"))
    @Column(name = "selected_choice")
    private Set<String> selectedChoices;

}
