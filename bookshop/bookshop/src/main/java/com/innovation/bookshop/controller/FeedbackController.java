package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.Feedback;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.service.FeedbackService;

@RestController
@RequestMapping("/bookshop/")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {
	@Autowired
	private FeedbackService ss;

	@GetMapping("/feedback")
	public List<Feedback>getAll()
	{
		return ss.findAll();
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback>save(@RequestBody Feedback f)
	{
		Feedback sp=ss.add(f);
		return new ResponseEntity<Feedback>(sp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/feedback/{feedbackid}")
	public ResponseEntity<Void>del(@PathVariable ("feedbackid") int feedbackid)
	{
		ss.delete(feedbackid);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


	
}
