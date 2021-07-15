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
public class Country {
    private int country_id;
    private String name;

    public Country(int country_id, String name) {
        this.country_id = country_id;
        this.name = name;
    }

    public Country() {
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
