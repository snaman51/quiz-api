package com.Quiz.App.services;
import com.Quiz.App.models.QuizAttempt;
import com.Quiz.App.repositories.QuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;

    @Autowired
    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttempt getQuizAttemptById(Long id) {
        return quizAttemptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("QuizAttempt not found with id: " + id));
    }

    public QuizAttempt createQuizAttempt(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    public QuizAttempt updateQuizAttempt(Long id, QuizAttempt quizAttempt) {
        QuizAttempt existingQuizAttempt = getQuizAttemptById(id);
        existingQuizAttempt.setUser(quizAttempt.getUser());
        existingQuizAttempt.setQuiz(quizAttempt.getQuiz());
        existingQuizAttempt.setQuestionAttempts(quizAttempt.getQuestionAttempts());
        return quizAttemptRepository.save(existingQuizAttempt);
    }

    public void deleteQuizAttempt(Long id) {
        quizAttemptRepository.deleteById(id);
    }
}
