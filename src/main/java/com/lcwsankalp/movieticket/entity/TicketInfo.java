package com.lcwsankalp.movieticket.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name="TICKET_INFO")
public class TicketInfo {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String movieName;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="DD-MM-YYYY")
	private Date movieDate;
	private String movieTime;
	private double ticketPrize;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public double getTicketPrize() {
		return ticketPrize;
	}
	public void setTicketPrize(double ticketPrize) {
		this.ticketPrize = ticketPrize;
	}
	@Override
	public String toString() {
		return "TicketInfo [id=" + id + ", name=" + name + ", email=" + email + ", movieName=" + movieName
				+ ", movieDate=" + movieDate + ", movieTime=" + movieTime + ", ticketPrize=" + ticketPrize + "]";
	}
	
	

}
