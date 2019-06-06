package com.udemy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOG")
public class Log {

	@Id
	@GeneratedValue
	private int id;

	private Date date;

	private String details;

	private String username;

	private String url;

	public Log() {
		// TODO Auto-generated constructor stub
	}

	public Log(Date date, String details, String username, String url) {
		super();
		this.date = date;
		this.details = details;
		this.username = username;
		this.url = url;
	}

	public Log(int id, Date date, String details, String username, String url) {
		super();
		this.id = id;
		this.date = date;
		this.details = details;
		this.username = username;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", date=" + date + ", details=" + details + ", username=" + username + ", url=" + url
				+ "]";
	}

}
