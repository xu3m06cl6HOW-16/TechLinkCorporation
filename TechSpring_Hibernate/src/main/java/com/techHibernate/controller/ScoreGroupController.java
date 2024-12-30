package com.techHibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techHibernate.hibernateUtil.HibernateUtil;
import com.techHibernate.model.Details;


@RestController
public class ScoreGroupController {

	
	@RequestMapping("/test")
	public String hello() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Details> scoreList;
		
		NativeQuery<Details> query = session.createNativeQuery("SELECT t.TNAME,c.CNAME,d.SNAME, s.SNO,s.SCORE "
				+ "FROM sc s JOIN student d ON d.SNO = s.SNO JOIN course c ON c.CNO = s.CNO "
				+ "JOIN teacher t ON t.TNO = c.TNO WHERE s.CNO = 'C001'",Details.class);
		
		scoreList = query.list();
		
		
		session.getTransaction().commit();
		
		for(Details sg : scoreList) {
			System.out.println(sg);
		}
		
		HibernateUtil.shutdown();
		
		System.out.println("Hello world");
		return "Hello world";
	}
}
