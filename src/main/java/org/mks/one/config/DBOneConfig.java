package org.mks.one.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = {
		"org.mks.one.repository" }, entityManagerFactoryRef = "dbOneEntityManagerFactory")
public class DBOneConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.datasource.db.one")
	public DataSourceProperties dbOneDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.datasource.db.one")
	public DataSource dbOneDataSource() {
		return dbOneDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean dbOneEntityManagerFactory(
			EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
		return entityManagerFactoryBuilder.dataSource(dbOneDataSource()).packages("org.mks.one").persistenceUnit("db_one")
				.build();
	}

}
