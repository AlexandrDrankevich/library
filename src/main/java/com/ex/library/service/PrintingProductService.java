package com.ex.library.service;

import com.ex.library.dao.PrintingProductRepository;
import com.ex.library.entity.PrintingProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintingProductService {
	@Autowired
	private PrintingProductRepository printingProductRepository;

	public List<PrintingProduct> findAll() {
		return (List<PrintingProduct>) printingProductRepository.findAll();
	}

	@Caching(evict = { @CacheEvict("product"), 
			@CacheEvict(value = "products", allEntries = true) })
	public void delete(long id) {
		printingProductRepository.deleteById(id);
	}

	@Cacheable("product")
	public PrintingProduct findById(long id) {
		return (PrintingProduct) printingProductRepository.findById(id).get();
	}

	@Caching(put = @CachePut(value = "product", key = "#printingProduct.id"), 
			evict = @CacheEvict(value = "products", allEntries = true))
	public PrintingProduct save(PrintingProduct printingProduct) {
		return printingProductRepository.save(printingProduct);
	}

	@Cacheable(value = "products", key = "#searchData")
	public List<PrintingProduct> findByData(String searchType, String searchData) {
		System.out.println("HI");
		switch (searchType) {
		case ("publisher"):
			return printingProductRepository.findByPublisher(searchData);
		case ("author"):
			return printingProductRepository.findByAuthor(searchData);
		case ("name"):
			return printingProductRepository.findByName(searchData);
		default:
			return null;
		}
	}
}
