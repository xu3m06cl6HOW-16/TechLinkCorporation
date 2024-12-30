package com.techHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "DETAILS")
public class Details{
	
	@Id
	@Column(name = "CNAME")
	private String cname;
	
	@Column(name = "TNAME")
	private String tname;
	
	@Column(name = "SNAME")
	private String sname;
	
	@Column(name = "SCORE")
	private Integer score;
	
	@Transient
	@Column(name = "EVALUATE")
	private String evaluate;
	
	

	@Override
	public String toString() {
		return "Details [cname=" + cname + ", tname=" + tname + ", sname=" + sname + ", score=" + score + ", evaluate="
				+ evaluate + "]";
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getTname() {
		return tname;
	}



	public void setTname(String tname) {
		this.tname = tname;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	public String getEvaluate() {
		return evaluate;
	}



	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}



	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Details(String cname, String tname, String sname, Integer score, String evaluate) {
		super();
		this.cname = cname;
		this.tname = tname;
		this.sname = sname;
		this.score = score;
		this.evaluate = evaluate;
	}	

}
