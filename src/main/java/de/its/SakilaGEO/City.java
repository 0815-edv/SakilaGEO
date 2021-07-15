/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO;

/**
 *
 * @author flori
 */
public class City {
    private int cityID;
    private String name;
    private int countryID;

    public City(int cityID, String name, int countryID) {
        this.cityID = cityID;
        this.name = name;
        this.countryID = countryID;
    }

    public City() {
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
    
    
}
