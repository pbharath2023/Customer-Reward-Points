package com.bharath.retail.crp.serviceimpl;

import com.bharath.retail.crp.dto.TheeMonthRewards;
import com.bharath.retail.crp.entity.User;
import com.bharath.retail.crp.entity.UserOrder;
import com.bharath.retail.crp.repository.UserOrderRepo;
import com.bharath.retail.crp.service.UserOrderService;
import com.bharath.retail.crp.dto.UserOrderDTO;
import com.bharath.retail.crp.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderRepo userOrderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserOrderDTO createOrder(@Valid UserOrderDTO userOrderDTO) {

        UserOrder u = new UserOrder();
        Optional<User> user = userRepo.findById(Math.toIntExact(userOrderDTO.getUserid()));

        if (user.isPresent()) {
            User user1 = user.get();
            u.setUser(user1);
            u.setPrice(userOrderDTO.getPrice());
            u.setReward(calculateRewards(userOrderDTO.getPrice()));
            u.setTransactionDate(userOrderDTO.getTransactionDate());
            UserOrder save = this.userOrderRepo.save(u);
            userOrderDTO.setReward(u.getReward());
            return userOrderDTO;
        } else {
            return null;
        }


    }

    @Override
    public UserOrderDTO updateUser(UserOrderDTO userOrderDTO, Integer id) {
        return null;
    }

    @Override
    public UserOrderDTO getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserOrderDTO> getAllUsers() {
        return null;
    }

    @Override
    public List<UserOrderDTO> getAllOrders() {
        List<UserOrder> allOrder = userOrderRepo.findAll();
        List<UserOrderDTO> userOrderDto = allOrder.stream().map(e -> this.userOrderToUserOrderDto(e)).collect(Collectors.toList());
        return userOrderDto;
    }

    @Override
    public List<TheeMonthRewards> getAllRewardMonthWise() {
        LocalDate d = LocalDate.now();
        String startDate = d.minusMonths(2).with(firstDayOfMonth()).toString();
        List<Object[]> allDataOf3Moths = userOrderRepo.findAllDataOf3Moths( startDate);
        List<TheeMonthRewards> collect = allDataOf3Moths.stream().map(e -> this.convertToRespone(e)).collect(Collectors.toList());
        System.out.println(allDataOf3Moths);
        return collect;
    }

    private TheeMonthRewards convertToRespone(Object[] e) {
        TheeMonthRewards data = new TheeMonthRewards();
        data.setMon((String) e[0]);
        data.setTotalReward((BigDecimal) e[1]);
        data.setUserId((Integer) e[2]);
        data.setUserName((String) e[3]);
        return data;
    }


    Long calculateRewards(Long price) {
        if (price >= 50 && price < 100) {
            return price - 50;
        } else if (price > 100) {
            return (2 * (price - 100) + 50);
        }
        return Long.valueOf(0);
    }

    public UserOrder userOrderDtoToUserOrder(UserOrderDTO userOrderDTO) {
        UserOrder user = this.modelMapper.map(userOrderDTO, UserOrder.class);

        return user;
    }

    public UserOrderDTO userOrderToUserOrderDto(UserOrder user) {
        UserOrderDTO userDto = this.modelMapper.map(user, UserOrderDTO.class);
        userDto.setUserid(user.getUser().getId());
        return userDto;
    }
}

