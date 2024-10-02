package com.alanyu.sprintbootmall.Config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "sprintboot-mall")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

}
