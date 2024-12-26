package techSpringMVC.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import techSpringMVC.dao.UserDao;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;
import techSpringMVC.rowMapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {
		String sql = "INSERT INTO userfolder(user_name,user_account,user_pass,user_email,user_create_date) VALUES ("
				+ " :name, :account, :pass, :email, :createDate)";

		Map<String, Object> map = new HashMap<>();
		map.put("name", userRegisterRequest.getUserName());
		map.put("account", userRegisterRequest.getUserAccount());
		map.put("pass", userRegisterRequest.getUserPass());
		map.put("email", userRegisterRequest.getUserEmail());

		Date now = new Date();
		map.put("createDate", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

		return keyHolder.getKey().intValue();
	}

	@Override
	public User getUserById(Integer userId) {

		String sql = "SELECT s.user_id,s.user_name,s.user_account,s.user_pass,s.user_email,s.user_create_date FROM userfolder s"
				+ " WHERE s.user_id = :userId";
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		
		List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		
		if(userList != null) {
			return userList.get(0);
		}else {
			return null;
		}
		
	}

	@Override
	public User getUserByEmail(String userEmail) {
		
		String sql = "SELECT user_id,user_name,user_account,user_pass,user_email,user_create_date FROM userfolder"
				 + " WHERE user_email = :userEmail";
		
		Map<String,Object> map = new HashMap<>();
		map.put("userEmail", userEmail);
		
		List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public void updatePassWord(String userAccount, String userPass) {
		
		String sql = "UPDATE userfolder SET user_pass = :userPass WHERE user_account = :userAccount";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userPass", userPass);
		map.put("userAccount", userAccount);
		
		namedParameterJdbcTemplate.update(sql, map);
	}

}
