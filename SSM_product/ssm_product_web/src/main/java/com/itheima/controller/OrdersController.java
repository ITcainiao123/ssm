package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll.do")
    public String findAll(Model model, String orderNum, @RequestParam(name = "page",required = false,defaultValue = "1") Integer page, @RequestParam(name = "pageSize",required = false,defaultValue = "3") Integer pageSize){
      List<Orders> orders= ordersService.findAll( page,pageSize,orderNum);
      System.out.println(orders);
        PageInfo pageInfo = new PageInfo(orders);
      model.addAttribute("pageInfo",pageInfo);
      model.addAttribute("orderNum",orderNum);
        return "orders-list";
    }
}
