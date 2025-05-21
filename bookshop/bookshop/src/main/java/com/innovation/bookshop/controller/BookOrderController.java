package com.innovation.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.bookshop.model.BookOrder;
import com.innovation.bookshop.model.Signup;
import com.innovation.bookshop.service.BookOrderService;

@RestController
@RequestMapping("/bookshop/")
@CrossOrigin(origins = "http://localhost:4200")
public class BookOrderController {
	@Autowired
	BookOrderService ss;
	
	@GetMapping("/bookorder")
	public List<BookOrder>getAll()
	{
		return ss.getAllOrders();
	}
	
	@PostMapping("/bookorder")
	public ResponseEntity<BookOrder>save(@RequestBody BookOrder b)
	{
		BookOrder bo=ss.add(b);
		return new ResponseEntity<BookOrder>(bo,HttpStatus.CREATED);
	}
	
	@PutMapping("bookorder/{id}")
	public ResponseEntity<BookOrder>update(@PathVariable("id") int id,@RequestBody BookOrder b)
	{
		BookOrder bo=ss.update(id, b);
		return new ResponseEntity<BookOrder>(bo,HttpStatus.OK);
	}
	
	@GetMapping("/bookorder/{orderno}")
	public ResponseEntity<BookOrder>search(@PathVariable ("orderno") int orderno)
	{
		BookOrder sp=ss.search(orderno);
		return new ResponseEntity<BookOrder>(sp,HttpStatus.OK);
	}
	
	@GetMapping("bookorderemail/{emailid}")
	public List<BookOrder>getAllByEmailId(@PathVariable("emailid") String emailid)
	{
		return ss.getAll(emailid);
	}
	
	
	
}
