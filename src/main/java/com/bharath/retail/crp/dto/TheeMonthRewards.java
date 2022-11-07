package com.bharath.retail.crp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheeMonthRewards {
    private String mon;
    private BigDecimal totalReward;
    private Integer userId;
    private String userName;
}
