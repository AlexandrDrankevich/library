package com.ex.library.conroller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ex.library.entity.PrintingProduct;
import com.ex.library.service.PrintingProductService;

@Controller
public class PrintingProductController {
	@Autowired
	private PrintingProductService printingProductService;

	static final Logger logger = LogManager.getLogger((PrintingProductController.class));

	@RequestMapping("/base_page")
	public String goToBasePage(Model model) {
		List<PrintingProduct> listProducts = printingProductService.findAll();
		model.addAttribute("printingProducts", listProducts);
		return "basePage";
	}

	@RequestMapping("/add")
	public String showAddForm(@ModelAttribute("printingProduct") PrintingProduct printingProduct) {
		return "addForm";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("productId");
		printingProductService.delete(Long.parseLong(id));
		return "redirect:/base_page";
	}

	@RequestMapping("/update")
	public String showUpdateForm(HttpServletRequest request, Model model) {
		String id = request.getParameter("productId");
		PrintingProduct printingProduct = printingProductService.findById(Long.parseLong(id));
		model.addAttribute("printingProduct", printingProduct);
		return "addForm";
	}

	@RequestMapping("/save")
	public String save(HttpServletRequest request, @ModelAttribute("printingProduct") PrintingProduct printingProduct,
			Model model) {
		printingProductService.save(printingProduct);
		List<PrintingProduct> listProducts = new ArrayList<PrintingProduct>();
		listProducts.add(printingProductService.findById(printingProduct.getId()));
		model.addAttribute("printingProducts", listProducts);
		return "basePage";
	}

	@RequestMapping("/searchForm")
	public String showSearchForm() {
		return "searchPage";
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String searchType = request.getParameter("searhType");
		String searchData = request.getParameter("searchData");
		List<PrintingProduct> listProducts = printingProductService.findByData(searchType, searchData);
		model.addAttribute("printingProducts", listProducts);
		logger.info(listProducts);
		return "basePage";
	}
}