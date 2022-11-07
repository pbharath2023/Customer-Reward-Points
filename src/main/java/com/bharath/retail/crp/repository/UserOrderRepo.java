package com.bharath.retail.crp.repository;

import com.bharath.retail.crp.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder, Integer> {

    public static final String GET3MONTHRECORDS = "select date_format(transaction_date, '%M') as mon,sum(reward) as totalreward,user_id,user_name\n" +
            "       from order_table inner join user on order_table.user_id=user.id where transaction_date >= :startDate and transaction_date <= now()\n" +
            "       group by date_format(transaction_date, '%M'),user_id order by order_table.user_id;";
    @Query(value = GET3MONTHRECORDS, nativeQuery = true)
    public List<Object[]> findAllDataOf3Moths(@Param("startDate") String startDate);
}
