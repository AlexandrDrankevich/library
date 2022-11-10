package com.ex.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.library.dao.PrintingProductRepository;
import com.ex.library.entity.PrintingProduct;

@Service
public class PrintingProductService {
	@Autowired
	private PrintingProductRepository printingProductRepository;
	
	public List<PrintingProduct> findAll(){
		return (List<PrintingProduct>)printingProductRepository.findAll();
		}

	public void delete(String id) {
		System.out.println("Delete"+id);
		
	}

	public PrintingProduct findById(long l) {
		return new PrintingProduct(1,"book","Pit","SBB", new java.sql.Date(1999-10-10))
		;
	}

	public void save(PrintingProduct printingProduct) {
		printingProductRepository.save(printingProduct);
		System.out.println(printingProduct);
		
	}

	public List<PrintingProduct> find(String searchType, String searchData) {
		List<PrintingProduct> list =new ArrayList<PrintingProduct>();
		list.add( new PrintingProduct(1,"book","Pit","SBB", new java.sql.Date(1999-10-10)));
		return list;
		// TODO Auto-generated method stub
		
	}
	
	

}
