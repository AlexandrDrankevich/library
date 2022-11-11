package com.ex.library.dao;

import com.ex.library.entity.PrintingProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintingProductRepository extends CrudRepository<PrintingProduct, Long> {
    List<PrintingProduct> findByAuthor(String author);

    List<PrintingProduct> findByPublisher(String publisher);

    List<PrintingProduct> findByName(String name);
}
