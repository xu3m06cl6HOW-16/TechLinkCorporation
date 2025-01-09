package techSpringMVC.model;
/*
 * HQL 是對java物件做查詢 FROM User是給類別
 * 
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="User.getUserByEmail",query =" FROM User WHERE user_email = :userEmail")})
@Table(name= "userfolder")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false)
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_account")
	private String userAccount;
	
	@Column(name = "user_pass")
	private String userPass;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_create_date")
	private Date userCreateDate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String userName, String userAccount, String userPass, String userEmail, Date userCreateDate) {
		super();
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userCreateDate = userCreateDate;
	}



	public User(int userId, String userName, String userAccount, String userPass, String userEmail,
			Date userCreateDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userCreateDate = userCreateDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	@Override
	public String toString() {
		return "UserFolder [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount
				+ ", userPass=" + userPass + ", userEmail=" + userEmail + ", userCreateDate=" + userCreateDate + "]";
	}
	
	

}
