package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Feedback;
import com.innovation.bookshop.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	@Qualifier("feedbackRepo")
	private FeedbackRepository feedbackRepo;

	@Override
	public Feedback add(Feedback f) {
		// TODO Auto-generated method stub
		return feedbackRepo.save(f);
	}

	@Override
	public List<Feedback> findAll() {
		// TODO Auto-generated method stub
		return feedbackRepo.findAll();
	}

	@Override
	public void delete(int feedbackid) {
		Feedback f=feedbackRepo.findById(feedbackid).orElseThrow(()->new ResourceNotFoundException("Resource not found by id"+feedbackid));
		feedbackRepo.deleteById(feedbackid);
	}
	


}
