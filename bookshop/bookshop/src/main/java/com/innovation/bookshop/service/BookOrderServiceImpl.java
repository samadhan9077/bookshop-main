package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.BookOrder;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.repository.BookOrderRepository;

@Service
public class BookOrderServiceImpl implements BookOrderService {
	@Autowired
	@Qualifier("boRepo")
	private BookOrderRepository boRepo;
	
	@Override
	public BookOrder add(BookOrder b) {
		// TODO Auto-generated method stub
		return boRepo.save(b);
	}


	@Override
	public BookOrder update(int orderno, BookOrder b) {
		BookOrder bold=boRepo.findById(orderno).orElseThrow(()->new ResourceNotFoundException("Resource not found by id"+orderno));
		bold.setStatus(b.getStatus());
		return boRepo.save(bold);
	}

	@Override
	public List<BookOrder> getAllOrders() {
		
		return boRepo.findAll();
	}


	@Override
	public List<BookOrder> getAll(String emailid) {
		// TODO Auto-generated method stub
		return boRepo.findAllByEmailid(emailid);
	}


	@Override
	public BookOrder search(int orderno) {
		BookOrder b=boRepo.findById(orderno).orElseThrow(()->new ResourceNotFoundException("Resource is not found"+orderno));
		return b;
	}

}





	


