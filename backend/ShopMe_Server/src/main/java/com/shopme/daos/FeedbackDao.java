package com.shopme.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.entities.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	Feedback findByRating(Feedback newFeedback);
	Feedback save(Feedback feedback);
}
