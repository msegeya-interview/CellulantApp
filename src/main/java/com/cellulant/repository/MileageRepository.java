package com.cellulant.repository;

import com.cellulant.constants.ApplicationQueriesHolder;
import com.cellulant.domain.Mileage;
import com.cellulant.mapper.MileageRowMapper;
import com.cellulant.services.CellulantSoapClientService;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Paul Msegeya
 *
 * This is the Repository for Data Extraction from Database
 */
@Repository
public class MileageRepository {

    private static final Logger LOG = Logger.getLogger(MileageRepository.class.getName());

    //====================================================
    //     DEPENDENCY INJECTION POINT
    //===================================================
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationQueriesHolder applicationQueriesHolder;

    @Autowired
    private com.cellulant.MapSqlParameterSource mapSqlParameterSource;

    @Autowired
    private CellulantSoapClientService cellulantSoapClientService;

    //====================================================
    //     CLASS COMPONENT VARIABLES
    //===================================================
    private MileageRowMapper mileageRowMapper;

    private boolean flag;

    private List<Mileage> mileages;

    private Mileage mileage;

    private DataSource ds;

    private String sql;

    private org.springframework.jdbc.core.namedparam.MapSqlParameterSource parameters;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MileageRepository() {
    }

    /**
     * Retrieve All Mileage Data from Database
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Mileage> findAll() {
        return getAll();

    }

    /**
     * *
     * Drop Existing Table before Populating with Data from web service
     */
    public void dropTable() {
        sql = applicationQueriesHolder.getDropTableCommand();
        LOG.info(" DROPING TABLE ....");
        jdbcTemplate.execute(sql);
    }

    /**
     * Dynamically Create Table
     */
    public void createTable() {
        sql = applicationQueriesHolder.getCreateTableCommand();
        LOG.info(" CREATING TABLE ....");
        jdbcTemplate.execute(sql);
    }

    public void updateTimeStamp(Timestamp timestamp) {
        sql = "UPDATE   mileage SET  date_modified='" + timestamp + "' WHERE date_modified IS NULL";
        LOG.info(" UPATING TIMESTAMP ....");
        jdbcTemplate.execute(sql);
    }

    /**
     * Retrieve all Records from database
     *
     * @return
     */
    private List<Mileage> getAll() {
        sql = applicationQueriesHolder.getAllQuery();
        parameters = mapSqlParameterSource.getBindingParametersNoArgs();
        mileageRowMapper = new MileageRowMapper();
        mileages = jdbcTemplate.query(sql, mileageRowMapper);
        LOG.log(Level.INFO, "MILEAGES LIST {0}", mileages);
        return mileages;
    }

    /**
     * Get Mileage Data by lengthId
     *
     * @param lengthId
     * @return
     */
    public Mileage getMileageByLengthId(String lengthId) {
        if (lengthId != null) {
            sql = applicationQueriesHolder.getQueryByLengthId();
            parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
            parameters.addValue("length_id", lengthId);
            mileageRowMapper = new MileageRowMapper();
            mileage = ((Mileage) namedParameterJdbcTemplate.queryForObject(sql, parameters, mileageRowMapper));
        } else {
            throw new NullPointerException("Length Column can not be null");
        }

        return mileage;
    }

    /**
     * Get Mileage Data by Miles
     *
     * @param miles
     * @return
     */
    public Mileage getMileageByMiles(String miles) {
        if (miles != null) {
            sql = applicationQueriesHolder.getQueryByMiles();
            parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
            parameters.addValue("miles", miles);
            mileageRowMapper = new MileageRowMapper();
            mileage = ((Mileage) namedParameterJdbcTemplate.queryForObject(sql, parameters, mileageRowMapper));
        } else {
            throw new NullPointerException("Miles Column can not be null");
        }

        return mileage;
    }

    /**
     * Get Mileage Data by Kilometers
     *
     * @param kilometer
     * @return
     * @throws java.lang.Exception
     */
    public Mileage getMileageByKilometer(String kilometer) throws Exception {
        if (kilometer != null) {
            sql = applicationQueriesHolder.getQueryByKilometers();
            parameters = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
            parameters.addValue("kilometers", kilometer);

            mileageRowMapper = new MileageRowMapper();
            mileage = ((Mileage) namedParameterJdbcTemplate.queryForObject(sql, parameters, mileageRowMapper));
        } else {
            new NullPointerException("Kilometer Clumn can not be null");
        }

        return mileage;
    }

    public void insert(Mileage mileage) {
        //mileage = new Mileage(Long.valueOf(Long.MIN_VALUE), "", "", Timestamp.from(Instant.MIN));
        createTable();
        if (mileage != null) {

            try {
                LOG.log(Level.INFO, "lengthId ==>{0}" + "\n" + "Miles ==>{1}" + "\n" + "Kilometers ==>{2}" + "\n" + "date_modified ==>{3}\n", new Object[]{mileage.getLength_id(), mileage.getMiles(), mileage.getKilometers(), mileage.getDate_modified()});
                sql = "INSERT INTO mileage(length_id,miles,kilometers,date_modified)  VALUES(" + mileage.getLength_id() + ",+" + mileage.getMiles() + "," + mileage.getKilometers() + "," + mileage.getDate_modified() + ")";
                parameters = mapSqlParameterSource.getBindingParametersAllArgs(mileage.getLength_id(), mileage.getMiles(), mileage.getKilometers(), mileage.getDate_modified());
                mileageRowMapper = new MileageRowMapper();
                LOG.info("INSERTING  MILEAGE DATA TO DATABASE");

                jdbcTemplate.update(sql);
            } catch (NullPointerException nullPointerException) {
                nullPointerException.getLocalizedMessage();
            }
        } else {
            throw new NullPointerException("Mileage Object is Null please revisit the class " + MileageRepository.class + " and Fix the error ");
        }
    }

    public void showTable() {
        sql = "SHOW TABLES";
        jdbcTemplate.execute(sql);

    }

    public void update(Long lengthId, String mileage, String kilometers) {
        if (lengthId != null) {
            this.mileage = getMileageByLengthId(mileage);
            updateGivenLengthId(this.mileage, lengthId, kilometers);
        } else if (mileage != null) {
            this.mileage = getMileageByMiles(mileage);
            updateGivenLengthId(this.mileage, lengthId, kilometers);
        } else {
            throw new NullPointerException(" You provided null values for mileage =" + mileage + " , lengthId  = " + lengthId);
        }
    }

    private void updateGivenLengthId(Mileage mileage, Long lengthId, String kilometers) {
        if (mileage != null) {
            sql = applicationQueriesHolder.getInsertQuery();
            parameters = mapSqlParameterSource.getBindingParameterLengthId(lengthId, kilometers);
            mileageRowMapper = new MileageRowMapper();
            int i = namedParameterJdbcTemplate.update(sql, parameters);
        } else {
            throw new NullPointerException("Mileage Object is Null please revisit the class " + MileageRepository.class + " and Fix the error ");
        }
    }

    private void updateGivenMiles(Mileage mileage, String miles, String kilometers) {
        if (mileage != null) {
            sql = applicationQueriesHolder.getUpateKilometersQueryForAgivenMiles();
            parameters = mapSqlParameterSource.getBindingParameterMiles(miles, kilometers);
            mileageRowMapper = new MileageRowMapper();
            int i = namedParameterJdbcTemplate.update(sql, parameters);
        } else {
            throw new NullPointerException("Mileage Object is Null please revisit the class " + MileageRepository.class + " and Fix the error ");
        }
    }

    private String calculateMiles(Long i) {
        String result = "";
        if (i != null) {
            result = String.valueOf(i * 10L);
        } else {
            throw new NullPointerException("Provided Null value for varible i =" + i);
        }

        return result;
    }

    private Double doubleConversion(String input) {
        return Double.valueOf(input);
    }
}
