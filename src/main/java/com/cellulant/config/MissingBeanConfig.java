package com.cellulant.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/**
 * 
 * @author Paul Msegeya
 */
@Configuration
public class MissingBeanConfig {
/*
    DataSource dataSource;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MissingBeanConfig() {
    }

    @Bean
    @Autowired
    @Primary
    @ConditionalOnMissingBean({NamedParameterJdbcOperations.class})
    public NamedParameterJdbcTemplate namedParameterEstatementJdbcTemplateObject(@Qualifier("dsCellulant") DataSource dataSource) {
        this.dataSource = dataSource;
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @ConditionalOnMissingBean({JdbcOperations.class})
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate();
    }
*/
}
