package com.innovation.bookshop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.Admin;


@Repository
@Qualifier("AdminRepo")
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByEmailAndPassword(String email,String password);
}
