package web.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "web.dao")
@ComponentScan("web")
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
    dataSource.setUrl(env.getRequiredProperty("db.url"));
    dataSource.setUsername(env.getRequiredProperty("db.username"));
    dataSource.setPassword(env.getRequiredProperty("db.password"));

    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();

    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));

    return properties;
  }


  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

    entityManager.setDataSource(dataSource());
    entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManager.setJpaProperties(hibernateProperties());
    entityManager.setPackagesToScan("web.models");

    return entityManager;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }
}
