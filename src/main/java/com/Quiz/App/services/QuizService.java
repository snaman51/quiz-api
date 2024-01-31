package com.Quiz.App.services;
import com.Quiz.App.models.Quiz;
import com.Quiz.App.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz getQuizById(Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        return optionalQuiz.orElse(null);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz updateQuiz(Long quizId, Quiz updatedQuiz) {
        Optional<Quiz> optionalExistingQuiz = quizRepository.findById(quizId);

        if (optionalExistingQuiz.isPresent()) {
            Quiz existingQuiz = optionalExistingQuiz.get();
            existingQuiz.setTitle(updatedQuiz.getTitle());
            return quizRepository.save(existingQuiz);
        }

        return null;
    }

    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}
