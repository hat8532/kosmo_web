package com.kosmo.app.home;

import java.sql.Date;
import java.time.LocalDate;

public class CommunityDTO {
	private Integer numNumber;
	private String title;
	private String name;
	private String contents;
	private LocalDate date;
	private Integer star;
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getNumNumber() {
		return numNumber;
	}
	public void setNumNumber(Integer numNumber) {
		this.numNumber = numNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
}
