package com.innovation.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.innovation.bookshop.model.Admin;
import com.innovation.bookshop.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
@Qualifier("AdminRepo")
private AdminRepository AdminRepo;

@Override
public Admin login(String email, String password) {
	return AdminRepo.findByEmailAndPassword(email, password);
}


}
