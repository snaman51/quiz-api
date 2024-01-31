package com.Quiz.App.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Quiz.App.repositories.UserScoreRepository;
import com.Quiz.App.models.UserScore;
import java.util.List;

@Service
public class UserScoreService {

    private final UserScoreRepository userScoreRepository;

    @Autowired
    public UserScoreService(UserScoreRepository userScoreRepository) {
        this.userScoreRepository = userScoreRepository;
    }

    public List<UserScore> getAllUserScores() {
        return userScoreRepository.findAll();
    }

    public UserScore getUserScoreById(Long id) {
        return userScoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserScore not found with id: " + id));
    }

    public UserScore addUserScore(UserScore userScore) {
        return userScoreRepository.save(userScore);
    }

    public UserScore updateUserScore(Long id, UserScore userScore) {
        UserScore existingUserScore = getUserScoreById(id);
        existingUserScore.setScore(userScore.getScore());
        return userScoreRepository.save(existingUserScore);
    }

    public void deleteUserScore(Long id) {
        userScoreRepository.deleteById(id);
    }
}
