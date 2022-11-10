package com.ex.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.library.entity.PrintingProduct;

@Repository
public interface PrintingProductRepository extends CrudRepository<PrintingProduct, Long> {
}
