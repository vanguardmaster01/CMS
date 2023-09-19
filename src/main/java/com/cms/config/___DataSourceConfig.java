package com.cms.config;

import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class DataSourceConfig {
	  @Value("${spring.datasource.cms.driverClassName}")
	    private String cmsDriverName;

	    @Value("${spring.datasource.cms.url}")
	    private String cmsUrl;

	    @Value("${spring.datasource.cms.username}")
	    private String cmsUserName;

	    @Value("${spring.datasource.cms.password}")
	    private String cmsPassword;
	    
	    @Value("${spring.datasource.utahtruckdrivingschool.driverClassName}")
	    private String utahtruckdrivingschoolDriverName;

	    @Value("${spring.datasource.utahtruckdrivingschool.url}")
	    private String utahtruckdrivingschoolUrl;

	    @Value("${spring.datasource.utahtruckdrivingschool.username}")
	    private String utahtruckdrivingschoolUserName;

	    @Value("${spring.datasource.utahtruckdrivingschool.password}")
	    private String utahtruckdrivingschoolPassword;
	    
	    @Value("${spring.datasource.truckcity.driverClassName}")
	    private String truckcityDriverName;

	    @Value("${spring.datasource.truckcity.url}")
	    private String truckcityUrl;

	    @Value("${spring.datasource.truckcity.username}")
	    private String truckcityUserName;

	    @Value("${spring.datasource.truckcity.password}")
	    private String truckcityPassword;
	    
	    @Value("${spring.datasource.towing.driverClassName}")
	    private String towingDriverName;

	    @Value("${spring.datasource.towing.url}")
	    private String towingUrl;

	    @Value("${spring.datasource.towing.username}")
	    private String towingUserName;

	    @Value("${spring.datasource.towing.password}")
	    private String towingPassword;
	    
	    @Value("${spring.datasource.onlineroadservices.driverClassName}")
	    private String onlineroadservicesDriverName;

	    @Value("${spring.datasource.onlineroadservices.url}")
	    private String onlineroadservicesUrl;

	    @Value("${spring.datasource.onlineroadservices.username}")
	    private String onlineroadservicesUserName;

	    @Value("${spring.datasource.onlineroadservices.password}")
	    private String onlineroadservicesPassword;
	    
	    @Bean
	    public DataSource cmsDataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName(cmsDriverName);
	        dataSourceBuilder.url(cmsUrl);
	        dataSourceBuilder.username(cmsUserName);
	        dataSourceBuilder.password(cmsPassword);
	        return dataSourceBuilder.build();
	    }
}