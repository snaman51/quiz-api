package com.Quiz.App.controllers;
import com.Quiz.App.models.UserScore;
import com.Quiz.App.services.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/userscores")
public class UserScoreController {

    private final UserScoreService userScoreService;

    @Autowired
    public UserScoreController(UserScoreService userScoreService) {
        this.userScoreService = userScoreService;
    }

    @GetMapping
    public List<UserScore> getAllUserScores() {
        return userScoreService.getAllUserScores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserScore> getUserScoreById(@PathVariable Long id) {
        UserScore userScore = userScoreService.getUserScoreById(id);
        return ResponseEntity.ok(userScore);
    }

    @PostMapping
    public ResponseEntity<UserScore> addUserScore(@RequestBody UserScore userScore) {
        UserScore newUserScore = userScoreService.addUserScore(userScore);
        return new ResponseEntity<>(newUserScore, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserScore> updateUserScore(@PathVariable Long id, @RequestBody UserScore userScore) {
        UserScore updatedUserScore = userScoreService.updateUserScore(id, userScore);
        return ResponseEntity.ok(updatedUserScore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserScore(@PathVariable Long id) {
        userScoreService.deleteUserScore(id);
        return ResponseEntity.noContent().build();
    }
}
