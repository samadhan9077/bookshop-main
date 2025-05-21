package com.innovation.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.exception.ResourceNotFoundException;
import com.innovation.bookshop.model.Cart;
import com.innovation.bookshop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	@Qualifier("cartRepo")
	private CartRepository cartRepo;
	
	@Override
	public Cart add(Cart c) {
		return cartRepo.save(c);
	}

	@Override
	public List<Cart> getAll(String email) {
		return cartRepo.findAllByEmail(email);
	}

	@Override
	public void deleteById(int cartid) {
		Cart c=cartRepo.findById(cartid).orElseThrow(()->new ResourceNotFoundException("Resource is not found by id"+cartid));
		cartRepo.deleteById(cartid);
	}

	@Override
	public Cart update(int cartid, Cart nc) {
		Cart c=cartRepo.findById(cartid).orElseThrow(()->new ResourceNotFoundException("Resource is not found by id"+cartid)); 
		c.setEmail(nc.getEmail());
		c.setBooktitle(nc.getBooktitle());
		c.setQty(nc.getQty());
		c.setAmount(nc.getAmount());
		return cartRepo.save(c);
	}

	@Override
	public Cart search(int cartid) {
		Cart c=cartRepo.findById(cartid).orElseThrow(()->new ResourceNotFoundException("Resource is not found by id"+cartid));
		return c;
	}

}
