package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.Cart;

public interface CartService {
	Cart add(Cart c);
	List<Cart>getAll(String email);
	void deleteById(int cartid);
	Cart update(int cartid,Cart nc);
	Cart search(int cartid);
}
