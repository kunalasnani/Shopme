package com.shopme.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopme.daos.FeedbackDao;
import com.shopme.entities.Feedback;
import com.shopme.entities.Product;
import com.shopme.entities.User;

@Transactional
@Service
public class FeedbackServiceImpl {

	@Autowired
	private FeedbackDao feedbackDao;
	
	public Feedback findFeedbackByRating(Feedback newFeedback) {
		Feedback feedback = feedbackDao.findByRating(newFeedback);
		return feedback;
	}
	
	public Feedback addFeedback(Feedback newFeedback) {
		Feedback feedback = feedbackDao.save(newFeedback);
		return feedback;
	}
	
//	public Optional<Product> deleteFeedback(Product userId) {
//		Integer user = feedbackDao.findByProductId(userId);
//		//Feedback feedback = feedbackDao.delete(user);
//		
//		if (user == null) {
//			return null;
//		} else {
//			feedbackDao.deleteById(user);
//			return user;
//		}
//	}
}
