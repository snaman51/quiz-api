package com.Quiz.App.controllers;
import com.Quiz.App.models.QuizAttempt;
import com.Quiz.App.services.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    @Autowired
    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @GetMapping
    public ResponseEntity<List<QuizAttempt>> getAllQuizAttempts() {
        List<QuizAttempt> quizAttempts = quizAttemptService.getAllQuizAttempts();
        return new ResponseEntity<>(quizAttempts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable Long id) {
        QuizAttempt quizAttempt = quizAttemptService.getQuizAttemptById(id);
        return new ResponseEntity<>(quizAttempt, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuizAttempt> createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        QuizAttempt createdQuizAttempt = quizAttemptService.createQuizAttempt(quizAttempt);
        return new ResponseEntity<>(createdQuizAttempt, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizAttempt> updateQuizAttempt(@PathVariable Long id, @RequestBody QuizAttempt quizAttempt) {
        QuizAttempt updatedQuizAttempt = quizAttemptService.updateQuizAttempt(id, quizAttempt);
        return new ResponseEntity<>(updatedQuizAttempt, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable Long id) {
        quizAttemptService.deleteQuizAttempt(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
