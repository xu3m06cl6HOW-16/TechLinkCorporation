package techSpringMVC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import techSpringMVC.model.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserId(rs.getInt("user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setUserAccount(rs.getString("user_account"));
		user.setUserPass(rs.getString("user_pass"));
		user.setUserEmail(rs.getString("user_email"));
		user.setUserCreateDate(rs.getDate("user_create_date"));
		
		return user;
	}

}
