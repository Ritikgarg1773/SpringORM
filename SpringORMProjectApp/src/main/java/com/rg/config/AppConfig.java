package com.rg.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//previously we have done all this using the XML file, now we will use the configuration and property file to do the same task
@Configuration
@PropertySource("objectApp.properties")  // to call the objectApp property class here
@EnableTransactionManagement
@ComponentScan("com.rg")
public class AppConfig {
	@Autowired
	private Environment env; // it will be the springframework core annotation
	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("mysqldriver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("pwd"));
		return ds;
	}
	@Bean
	public Properties pr() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.show"));
		p.put("hibernate.show_format", env.getProperty("orm.format"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.hbmddl"));
		return p;
	}
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds());
		sf.setHibernateProperties(pr());
		sf.setPackagesToScan("com.rg.model");
		return sf;
	}
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager h = new HibernateTransactionManager();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	@Bean
	public HibernateTemplate ht() {
		return new HibernateTemplate(sf().getObject());
	}
}
