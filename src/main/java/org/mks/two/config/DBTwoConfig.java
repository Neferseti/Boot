package org.mks.two.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = {
		"org.mks.two.repository" }, entityManagerFactoryRef = "dbTwoEntityManagerFactory")
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
		return entityManagerFactoryBuilder.dataSource(dbTwoDataSource()).packages("org.mks.two").persistenceUnit("db_two")
				.build();
	}
}
