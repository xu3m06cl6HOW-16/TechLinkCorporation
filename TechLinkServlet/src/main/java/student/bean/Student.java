package student.bean;

import java.io.Serializable;
import java.util.Date;
/*
 * Java Bean規範
 * 1.對每個private欄位設計getter、setter
 * 2.實作serializable介面
 * 3.擁有一個空參數建構子
 */
public class Student implements Serializable{

	private String sno;
	private String sname;
	private Date sbday;
	private Integer ssex;
	private String smail;
	private String spwd;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sno, String sname, Date sbday, Integer ssex, String smail, String spwd) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbday = sbday;
		this.ssex = ssex;
		this.smail = smail;
		this.spwd = spwd;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getSbday() {
		return sbday;
	}

	public void setSbday(Date sbday) {
		this.sbday = sbday;
	}

	public Integer getSsex() {
		return ssex;
	}

	public void setSsex(Integer ssex) {
		this.ssex = ssex;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sbday=" + sbday + ", ssex=" + ssex + ", smail=" + smail
				+ ", spwd=" + spwd + "]";
	}
	
	

}
