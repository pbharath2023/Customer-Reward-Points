package com.bharath.retail.crp.service;

import com.bharath.retail.crp.dto.TheeMonthRewards;
import com.bharath.retail.crp.dto.UserOrderDTO;

import javax.validation.Valid;
import java.util.List;

public interface UserOrderService {

    UserOrderDTO createOrder(@Valid UserOrderDTO userOrderDTO);
    UserOrderDTO updateUser(UserOrderDTO userOrderDTO, Integer id);
    UserOrderDTO getUserById(Integer userId);
    List<UserOrderDTO> getAllUsers();

   List< UserOrderDTO> getAllOrders();

    List<TheeMonthRewards>  getAllRewardMonthWise();
}
