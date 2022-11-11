package com.ex.library.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.library.entity.PrintingProduct;

@Repository
public interface PrintingProductRepository extends CrudRepository<PrintingProduct, Long> {
	List<PrintingProduct> findByAuthor(String author);
	List<PrintingProduct> findByPublisher(String publisher);
	List<PrintingProduct> findByName(String name);
}
