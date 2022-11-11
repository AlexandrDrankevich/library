package com.ex.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.library.dao.PrintingProductRepository;
import com.ex.library.entity.PrintingProduct;

@Service
public class PrintingProductService {
	@Autowired
	private PrintingProductRepository printingProductRepository;

	public List<PrintingProduct> findAll() {
		return (List<PrintingProduct>) printingProductRepository.findAll();
	}

	public void delete(long id) {
		printingProductRepository.deleteById(id);
	}

	public PrintingProduct findById(long id) {
		return (PrintingProduct) printingProductRepository.findById(id).get();
	}

	public void save(PrintingProduct printingProduct) {
		printingProductRepository.save(printingProduct);
	}

	public List<PrintingProduct> findByData(String searchType, String searchData) {
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
