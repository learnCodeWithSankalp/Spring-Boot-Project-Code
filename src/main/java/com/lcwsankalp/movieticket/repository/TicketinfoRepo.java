package com.lcwsankalp.movieticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwsankalp.movieticket.entity.TicketInfo;

public interface TicketinfoRepo extends JpaRepository<TicketInfo, String> {

}
