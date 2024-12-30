package com.techHibernate.dto;

import java.io.Serializable;

public class ScoreGroup implements Serializable{

	
	private String cname;
	private String tname;
	private String sname;
	private Integer score;
	private String evaluate;
	
	public ScoreGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreGroup(String cname, String tname, String sname, Integer score, String evaluate) {
		super();
		this.cname = cname;
		this.tname = tname;
		this.sname = sname;
		this.score = score;
		this.evaluate = evaluate;
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

	@Override
	public String toString() {
		return "ScoreGroup [cname=" + cname + ", tname=" + tname + ", sname=" + sname + ", score=" + score
				+ ", evaluate=" + evaluate + "]";
	}
	
	
	
}
