package com.shop.controller;

import com.shop.dto.product.ProductDTO;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    // 해당 상품의 상세 페이지 View
    @GetMapping("/{no}")
    public String get_product(
            @PathVariable("no") int no,
            Model model){
        ProductDTO productDTO = productService.get_product(no);
        model.addAttribute("product", productDTO);
        return "main/product";
    }

    @GetMapping
    public String get_products_main(
            @RequestParam(value = "search", required = false) String searchWord, //검색어
            @RequestParam(value = "order", defaultValue = "popular") String order, //인기순, 상품명순, 가격순...
            Model model
    ){
        List<ProductDTO> productDTO = productService.get_products(searchWord, order);
        model.addAttribute("product", productDTO);
        return "main";
    }

}
