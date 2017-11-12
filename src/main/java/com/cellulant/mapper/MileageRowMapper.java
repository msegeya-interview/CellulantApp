package com.cellulant.mapper;

import com.cellulant.domain.Mileage;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Paul Msegeya
 * 
 * This is a database Mapping Class
 */

public class MileageRowMapper
        implements RowMapper<Mileage> {

    private final String length_id = "length_id";
    private final String miles = "miles";
    private final String kilometers = "kilometers";
    private final String date_modified = "date_modified";

    public MileageRowMapper() {
    }

    public Mileage mapRow(ResultSet rs, int i) throws SQLException {
        Mileage mileage = new Mileage();

        mileage.setDate_modified(rs.getTimestamp("date_modified"));
        mileage.setLength_id(Long.valueOf(rs.getLong("length_id")));
        mileage.setMiles(rs.getString("miles"));
        mileage.setKilometers(rs.getString("kilometers"));

        return mileage;
    }
}
