package com.cellulant.constants;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Paul Msegeya
 */
@Component
public class ApplicationQueriesHolder {

    //====================================================
    //     HOLDS APPLICATION QUERIES
    //===================================================
    private final String createTableCommand = "CREATE TABLE IF NOT EXISTS  mileage ( \n"
            + "   length_id BIGINT NOT NULL, \n"
            + "   miles VARCHAR(50) NOT NULL, \n"
            + "   kilometers VARCHAR(20) NOT NULL, \n"
            + "   date_modified VARCHAR(35), \n"
            + ")";

    private final String dropTableCommand = "DROP  TABLE IF  EXISTS  mileage";

    private final String showTableCommand = "SHOW TABLE";

    private final String allQuery = "SELECT  * FROM MILEAGE";

    private final String queryByKilometers = "SELECT  * FROM MILEAGE  WHERE kilometers=:kilometers";

    private final String queryByMiles = "SELECT  * from mileage  WHERE miles=:miles";

    private final String queryByLengthId = "SELECT  * from mileage  WHERE length_id=:lengt_id";
    
    private final String updateModifiedDate = "UPDATE   mileage SET  date_modified=:date_modified WHERE miles=:miles";

    private final String upateKilometersQueryForAgivenMiles = "UPDATE   mileage SET  kilometers=:kilometers WHERE miles=:miles";

    private final String upateKilometersQueryForAgivenLengthId = "UPDATE   mileage SET  kilometers=:kilometers WHERE length_id=:length_id";

    private final String insertQuery = " INSERT INTO mileage(length_id,miles,kilometers,date_modified)  VALUES (:length_id,:miles,:kilometers,:date_modified)";

    public ApplicationQueriesHolder() {
    }

    public String getCreateTableCommand() {
        return createTableCommand;
    }

    public String getDropTableCommand() {
        return dropTableCommand;
    }

    public String getShowTableCommand() {
        return showTableCommand;
    }

    public String getAllQuery() {
        return allQuery;
    }

    public String getQueryByKilometers() {
        return queryByKilometers;
    }

    public String getQueryByMiles() {
        return queryByMiles;
    }

    public String getQueryByLengthId() {
        return queryByLengthId;
    }

    public String getUpateKilometersQueryForAgivenMiles() {
        return upateKilometersQueryForAgivenMiles;
    }

    public String getUpateKilometersQueryForAgivenLengthId() {
        return upateKilometersQueryForAgivenLengthId;
    }

    public String getInsertQuery() {
        return insertQuery;
    }

}
