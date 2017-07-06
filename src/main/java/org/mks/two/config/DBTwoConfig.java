package org.mks.two.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
		"org.mks.two.repository" }, entityManagerFactoryRef = "dbTwoEntityManagerFactory", transactionManagerRef = "dbTwoTransactionManager")
public class DBTwoConfig {

	@Bean
	@ConfigurationProperties(prefix = "app.datasource.db.two")
	public DataSourceProperties dbTwoDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties(prefix = "app.datasource.db.two")
	public DataSource dbTwoDataSource() {
		return dbTwoDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean dbTwoEntityManagerFactory(
			EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
		return entityManagerFactoryBuilder.dataSource(dbTwoDataSource()).packages("org.mks.two")
				.persistenceUnit("db_two").build();
	}

	@Bean
	public PlatformTransactionManager dbTwoTransactionManager(
			@Qualifier("dbTwoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
