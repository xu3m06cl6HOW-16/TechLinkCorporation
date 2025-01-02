package techSpringMVC.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	public static StandardServiceRegistry registry;
	private static final SessionFactory sessionFactory = createSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	private static SessionFactory createSessionFactory() {
		try {
			
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
			
			SessionFactory factory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			
			return factory;
		}catch(Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static void shutdown() {
		if(registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
