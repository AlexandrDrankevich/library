package com.ex.library.dao;

import com.ex.library.entity.PrintingProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintingProductRepository extends CrudRepository<PrintingProduct, Long> {
    List<PrintingProduct> findByAuthorIgnoreCase(String author);

    List<PrintingProduct> findByPublisherIgnoreCase(String publisher);

    List<PrintingProduct> findByNameIgnoreCase(String name);
}
