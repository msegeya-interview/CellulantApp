package com.cellulant.config;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
/**
 * 
 * @author Paul Msegeya
 */
public class BaseJdbcConfig {

    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;
    public NamedParameterJdbcTemplate namedParameterJdbcTemplateObject;

    public BaseJdbcConfig() {
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplateObject = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setNamedParameterJdbcTemplateObject(NamedParameterJdbcTemplate namedParameterJdbcTemplateObject) {
        this.namedParameterJdbcTemplateObject = namedParameterJdbcTemplateObject;
    }
}
