package com.example.service.controller;

import com.example.service.Model.Order;
import com.example.service.Model.Orderr;
import com.example.service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orderr,String> {

    @Query("SELECT o.id AS id, o.nameOrder AS nameOrder, o.phoneOrder AS phoneOrder, " +
            "o.priceOrder AS priceOrder, o.status AS status, o.ship AS ship, o.areaOrder AS areaOrder " +
            "FROM Orderr o")
    List<Order> findAllOrderSummaries();
}
