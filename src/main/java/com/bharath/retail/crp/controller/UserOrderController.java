package com.bharath.retail.crp.controller;

import com.bharath.retail.crp.dto.TheeMonthRewards;
import com.bharath.retail.crp.dto.UserOrderDTO;
import com.bharath.retail.crp.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("/addOrder")
    public ResponseEntity<UserOrderDTO> createUser(@Valid @RequestBody UserOrderDTO userOrderDTO) {
        UserOrderDTO createUserOrderDTO = this.userOrderService.createOrder(userOrderDTO);
        if (createUserOrderDTO != null) {
            return new ResponseEntity<>(createUserOrderDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/getAllOrders")
    public ResponseEntity<List<UserOrderDTO>> getAllOrders() {
        List<UserOrderDTO> allOrders = this.userOrderService.getAllOrders();
        if (allOrders != null) {
            return new ResponseEntity<>(allOrders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllRewardsFor3Moths")
    public ResponseEntity<List<TheeMonthRewards>> getRewardsFor3Months() {
        List<TheeMonthRewards> allOrders = this.userOrderService.getAllRewardMonthWise();
        if (allOrders != null) {
            return new ResponseEntity<>(allOrders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
