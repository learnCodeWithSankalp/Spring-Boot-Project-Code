package com.lcwsankalp.movieticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwsankalp.movieticket.entity.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {

}
