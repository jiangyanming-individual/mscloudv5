package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;

import java.util.List;

public interface PayService {

    public int addPay(Pay pay);

    public int deletePay(Integer id);

    public int updatePay(Pay pay);

    public Pay getPayById(Integer id);

    public List<Pay> getAll();
}
