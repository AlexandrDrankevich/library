package com.ex.library.conroller;

import com.ex.library.entity.PrintingProduct;
import com.ex.library.service.PrintingProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        printingProductService.delete(id);
        return "redirect:/base_page";
    }

    @RequestMapping("/update/{id}")
    public String showUpdateForm(Model model,@PathVariable("id") long id) {
        PrintingProduct printingProduct = printingProductService.findById(id);
        model.addAttribute("printingProduct", printingProduct);
        return "addForm";
    }

    @RequestMapping("/save")
    public String save( @ModelAttribute("printingProduct") PrintingProduct printingProduct,Model model) {
        List<PrintingProduct> listProducts = new ArrayList<PrintingProduct>();
        listProducts.add(printingProductService.save(printingProduct));
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