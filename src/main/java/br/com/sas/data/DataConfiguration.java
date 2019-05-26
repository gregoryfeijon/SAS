package br.com.sas.data;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
//	@Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        
//        dataSource.setUrl("jdbc:mysql://localhost:3306/sas?useTimezone=true&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//	
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter(){
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(true);
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
//		adapter.setPrepareConnection(true);
//		return adapter;
//	}
	
	
	@Bean // o retorno do método será um objeto gerenciado pelo Spring
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sas?useTimezone=true&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		factoryBean.setDataSource(dataSource);

		Properties props = new Properties();
//		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
//		props.setProperty("hibernate.hbm2ddl.auto", "create");
		factoryBean.setJpaProperties(props);

		factoryBean.setPackagesToScan("br.com.sas.model");

		return factoryBean;
	}

	
	
	
}
