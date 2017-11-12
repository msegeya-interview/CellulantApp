package com.cellulant;

import java.sql.Timestamp;
import org.springframework.stereotype.Component;

@Component
public class MapSqlParameterSource {

    private final String lengthId = "length_id";

    private final String miles = "miles";

    private final String kilometers = "kilometers";

    private final String date_modified = "date_modified";

    public MapSqlParameterSource() {
    }

    public org.springframework.jdbc.core.namedparam.MapSqlParameterSource getBindingParametersNoArgs() {
        org.springframework.jdbc.core.namedparam.MapSqlParameterSource parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
        getClass();
        parameters.addValue("length_id", "");
        getClass();
        parameters.addValue("miles", "");
        getClass();
        parameters.addValue("kilometers", "");
        getClass();
        parameters.addValue("date_modified", "");

        return parameters;
    }

    public org.springframework.jdbc.core.namedparam.MapSqlParameterSource getBindingParametersAllArgs(Long length_id, String miles, String kilometers, Timestamp date_modified) {
        org.springframework.jdbc.core.namedparam.MapSqlParameterSource parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
        getClass();
        parameters.addValue("length_id", length_id);
        getClass();
        parameters.addValue("miles", miles);
        getClass();
        parameters.addValue("kilometers", kilometers);

        return parameters;
    }

    public org.springframework.jdbc.core.namedparam.MapSqlParameterSource getBindingParameterMiles(String miles, String kilometers) {
        org.springframework.jdbc.core.namedparam.MapSqlParameterSource parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
        getClass();
        parameters.addValue("miles", miles);
        getClass();
        parameters.addValue("kilometers", kilometers);

        return parameters;
    }

    public org.springframework.jdbc.core.namedparam.MapSqlParameterSource getBindingParameterLengthId(Long lengthId, String kilometers) {
        org.springframework.jdbc.core.namedparam.MapSqlParameterSource parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
        getClass();
        parameters.addValue("length_id", lengthId);
        getClass();
        parameters.addValue("miles", "miles");
        getClass();
        parameters.addValue("kilometers", kilometers);

        return parameters;
    }
}
