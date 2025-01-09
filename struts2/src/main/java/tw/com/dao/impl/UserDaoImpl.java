package tw.com.dao.impl;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.com.dao.UserDao;
import tw.com.dto.UserRegisterRequest;
import tw.com.model.User;
import tw.com.util.HibernateUtil;



@Repository
public class UserDaoImpl implements UserDao {
	
	
	SessionFactory sessionFactory;
	
	@PostConstruct
    public void onStartup() {
		sessionFactory = HibernateUtil.getSessionFactory();
    }

	
	@PreDestroy
	  public void onShutdown() {
		HibernateUtil.shutdown();
    }

	@Override
	public User getUserByEmail(String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query<User> query = session.createNamedQuery("User.getUserByEmail", User.class);
		query.setParameter("userEmail", userEmail);
		User user = query.uniqueResult();

		session.getTransaction().commit();
		return user;
	}

	@Override
	public User getUserById(Integer userId) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		User user = session.get(User.class, userId);

		session.getTransaction().commit();
		return user;
	}

	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Date now = new Date();

		User user = new User(userRegisterRequest.getUserName(), userRegisterRequest.getUserAccount(),
				userRegisterRequest.getUserPass(), userRegisterRequest.getUserEmail(), now);
		
		Serializable generatedId = session.save(user);//其實save會回傳一個物件Serializable 就是自增主鍵

		session.getTransaction().commit();
		
		return (Integer)generatedId;
	}

	@Override
	public void updatePassWord(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
	}
}
