package tw.com.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class HibrenateConfig {
	
	@Bean
	public HikariDataSource dataSource() {
		HikariConfig config=new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/techlinkdb?serverTimezone=Asia/Taipei");
		config.setUsername("root");
		config.setPassword("123456");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setMaximumPoolSize(10);
		return new HikariDataSource(config);    
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("tw.com");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	public Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
	    return new HibernateTransactionManager(sessionFactory);
	}
}
