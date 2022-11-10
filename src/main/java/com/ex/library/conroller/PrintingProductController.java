package com.ex.library.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ex.library.entity.PrintingProduct;
import com.ex.library.service.PrintingProductService;


@Controller
public class PrintingProductController {
	@Autowired
	private PrintingProductService printingProductService;

	@RequestMapping("/base_page")
	public String goToBasePage(Model model) {

		List<PrintingProduct> listProducts = printingProductService.findAll();
		System.out.println(listProducts);
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
		printingProductService.delete(id);
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
	public String save(HttpServletRequest request, @ModelAttribute("printingProduct") PrintingProduct printingProduct) {
		printingProductService.save(printingProduct);
		return "redirect:/base_page";

	}
	
	@RequestMapping("/searchForm")
	public String showSearchForm() {
		return "searchPage";

	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String searchType=request.getParameter("searhType");
		String searchData=request.getParameter("searchData");
		List<PrintingProduct> listProducts=printingProductService.find(searchType,searchData);
		model.addAttribute("printingProducts", listProducts);
	    return "basePage";
	}

}