package com.innovation.bookshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovation.bookshop.model.Book;

@Repository
@Qualifier("bookRepo")
public interface BookRepository extends JpaRepository<Book,Integer> {
List<Book>findAllByType(String type);
}
