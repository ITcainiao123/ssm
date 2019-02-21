package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductContrller {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("productList", list);
        return "product-list";
    }

    @RequestMapping("/add")
    public String add(Product product) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (product.getDepartureTimeStr()!=null&&product.getDepartureTimeStr()!="") {
            Date date = sdf.parse(product.getDepartureTimeStr());
            product.setDepartureTime(date);
        }
        System.out.println(product);
        productService.add(product);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/deleteByIds")
    public String deleteByIds(String[] ids){

        productService.deleteByIds(ids);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/open")
    public @ResponseBody Integer open(String id){
        productService.open(id);

        return 1;
    }
    @RequestMapping("/close")
    public @ResponseBody Integer close(String id){
        productService.close(id);
        return 1;
    }
    @RequestMapping("/judgeAdd")
    public @ResponseBody boolean judgeAdd(String productNum) throws ParseException {
     boolean flg =  productService.judgeAdd(productNum);
     return flg;
    }
    @RequestMapping("/funzzyQuery")
    public String funzzyQuery(String productName,Model model){
        System.out.println(productName);
       List<Product> list= productService.funzzyQuery(productName);
       model.addAttribute("productList",list);
       return "product-list";
    }
    @RequestMapping("/compile")
    public String compile(String id,Model model){
        Product product = productService.compile(id);
        model.addAttribute("product",product);
        return "product-update";
    }
    @RequestMapping("/update")
    public String update(Product product) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (product.getDepartureTimeStr()!=null&&product.getDepartureTimeStr()!="") {
            Date date = sdf.parse(product.getDepartureTimeStr());
            product.setDepartureTime(date);
        }
        productService.update(product);
        return "redirect:/product/findAll";
    }
}
