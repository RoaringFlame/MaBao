package com.mabao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableJpaRepositories(basePackages= "com.mabao.repository")
  public class SpringDataJpaConfig {

  @Bean
  public DataSource dataSource() {
    try   {
      ComboPooledDataSource dataSource = new ComboPooledDataSource();
      dataSource.setDriverClass( "com.mysql.jdbc.Driver");
      dataSource.setJdbcUrl( "jdbc:mysql://127.0.0.1:3306/mabao?useUnicode=true&characterEncoding=UTF-8");
      dataSource.setUser( "root");
      dataSource.setPassword( "root");
      dataSource.setInitialPoolSize(2);
      dataSource.setMinPoolSize(1);
      dataSource.setMaxPoolSize(10);
      dataSource.setMaxStatements(50);
      dataSource.setMaxIdleTime(60);
      return dataSource;
    }   catch   (PropertyVetoException e)   {
      throw   new   RuntimeException(e);
    }
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource);
    emf.setPersistenceUnitName("mabao");
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.setPackagesToScan("com.mabao.pojo");
    return emf;
  }
  
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.MYSQL);
    adapter.setShowSql(true);
    adapter.setGenerateDdl(false);
    adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    return adapter;
  }
  

  @Configuration
  @EnableTransactionManagement
  public static class TransactionConfig {

    @Inject
    private EntityManagerFactory emf;

    @Bean
    public PlatformTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
    }    
  }
  
}
