package com.innovation.bookshop.service;

import java.util.List;

import com.innovation.bookshop.model.BookOrder;
import com.innovation.bookshop.model.Signup;

public interface BookOrderService {
	BookOrder add(BookOrder b);
	List<BookOrder>getAll(String emailid);
	BookOrder update(int orderno,BookOrder b);
	List<BookOrder>getAllOrders();
	BookOrder search(int orderno);
}
