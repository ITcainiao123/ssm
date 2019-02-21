package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrdersMapper;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(int page,int pageSize,String orderNum) {
        PageHelper.startPage(page,pageSize);
        return ordersMapper.findAll(orderNum);
    }
}
