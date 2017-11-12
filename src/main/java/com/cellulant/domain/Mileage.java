package com.cellulant.domain;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mileage implements Serializable {

    @Id
    private Long length_id;
    private String miles;
    private String kilometers;
    private Timestamp date_modified;

    @ConstructorProperties({"length_id", "miles", "kilometers", "date_modified"})
    public Mileage(Long length_id, String miles, String kilometers, Timestamp date_modified) {
        this.length_id = length_id;
        this.miles = miles;
        this.kilometers = kilometers;
        this.date_modified = date_modified;
    }

    public void setLength_id(Long length_id) {
        this.length_id = length_id;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public void setDate_modified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Mileage)) {
            return false;
        }
        Mileage other = (Mileage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$length_id = getLength_id();
        Object other$length_id = other.getLength_id();
        if (this$length_id == null ? other$length_id != null : !this$length_id.equals(other$length_id)) {
            return false;
        }
        Object this$miles = getMiles();
        Object other$miles = other.getMiles();
        if (this$miles == null ? other$miles != null : !this$miles.equals(other$miles)) {
            return false;
        }
        Object this$kilometers = getKilometers();
        Object other$kilometers = other.getKilometers();
        if (this$kilometers == null ? other$kilometers != null : !this$kilometers.equals(other$kilometers)) {
            return false;
        }
        Object this$date_modified = getDate_modified();
        Object other$date_modified = other.getDate_modified();
        return this$date_modified == null ? other$date_modified == null : this$date_modified.equals(other$date_modified);
    }

    protected boolean canEqual(Object other) {
        return other instanceof Mileage;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $length_id = getLength_id();
        result = result * 59 + ($length_id == null ? 43 : $length_id.hashCode());
        Object $miles = getMiles();
        result = result * 59 + ($miles == null ? 43 : $miles.hashCode());
        Object $kilometers = getKilometers();
        result = result * 59 + ($kilometers == null ? 43 : $kilometers.hashCode());
        Object $date_modified = getDate_modified();
        result = result * 59 + ($date_modified == null ? 43 : $date_modified.hashCode());
        return result;
    }

    public String toString() {
        return "Mileage(length_id=" + getLength_id() + ", miles=" + getMiles() + ", kilometers=" + getKilometers() + ", date_modified=" + getDate_modified() + ")";
    }

    public Long getLength_id() {
        return length_id;
    }

    public String getMiles() {
        return miles;
    }

    public String getKilometers() {
        return kilometers;
    }

    public Timestamp getDate_modified() {
        return date_modified;
    }

    public Mileage() {
    }
}
