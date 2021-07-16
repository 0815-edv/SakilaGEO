/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author flori
 */
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityID;
    private String name;
    private long countryID;

    public City(long cityID, String name, long countryID) {
        this.cityID = cityID;
        this.name = name;
        this.countryID = countryID;
    }

    public City(String name, long countryID) {
        this.name = name;
        this.countryID = countryID;
    }

    public City() {
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (!(o instanceof City)) {
            return false;
        }
        var compare = (City) o;
        if (this.getName().equals(compare.getName())) {
            if (this.countryID == compare.countryID) {
                return true;
            }
        }
        return isEqual;
    }
    
    public City update(City update){
        if(!this.getName().equals(update.getName())){
            this.setName(update.getName());
            this.setCountryID(update.countryID);
        }
        return this;
    }

}
