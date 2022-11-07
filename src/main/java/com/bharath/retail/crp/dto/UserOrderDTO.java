package com.bharath.retail.crp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDTO {
    private Long price;
    private Long reward;
    private Integer userid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
}