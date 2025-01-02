package techSpringMVC.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import techSpringMVC.dao.UserDao;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;
import techSpringMVC.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByEmail(String userEmail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query<User> query = session.createNamedQuery("User.getUserByEmail", User.class);
		query.setParameter("userEmail", userEmail);
		User user = query.uniqueResult();

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		return user;
	}

	@Override
	public User getUserById(Integer userId) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = session.get(User.class, userId);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		return user;
	}

	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Date now = new Date();

		User user = new User(userRegisterRequest.getUserName(), userRegisterRequest.getUserAccount(),
				userRegisterRequest.getUserPass(), userRegisterRequest.getUserEmail(), now);
		
		session.save(user);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		return user.getUserId();
	}

	@Override
	public void updatePassWord(User user) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
