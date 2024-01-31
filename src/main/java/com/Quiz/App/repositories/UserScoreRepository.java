package com.Quiz.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Quiz.App.models.UserScore;
public interface UserScoreRepository extends JpaRepository<UserScore, Long> {
}
