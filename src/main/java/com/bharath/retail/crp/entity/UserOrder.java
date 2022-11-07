package com.bharath.retail.crp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "order_table")
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long price;
    private Long reward;
    private Date transactionDate;
    @Transient
    private Integer totalReward;
    @Transient
    private  String  month;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}