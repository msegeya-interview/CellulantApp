package com.cellulant.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Paul Msegeya
 */

@Component
@Configuration
@PropertySource({"classpath:application.properties"})
public class CellulantAppDatasourceConfig {
    /*
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver}")
    private String driverClass;

    public CellulantAppDatasourceConfig() {
    }

    @Bean
    public DataSource dsCellulant() {
        DataSource dataSource = DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(driverClass).build();

        return dataSource;
    }

    @Bean(name = {"jdbcCellulant"})
    @Autowired
    @Lazy
    public JdbcTemplate cellulantJdbcTemplate(@Qualifier("dsCellulant") DataSource dsAtmReceipt) {
        return new JdbcTemplate(dsCellulant());
    }

    @Bean(name = {"jdbcNamedCellulant"})
    @Autowired
    public NamedParameterJdbcTemplate namedParameterCellulantJdbcTemplate(@Qualifier("dsCellulant") DataSource dsAtmReceipt) {
        return new NamedParameterJdbcTemplate(dsCellulant());
    }*/
}
