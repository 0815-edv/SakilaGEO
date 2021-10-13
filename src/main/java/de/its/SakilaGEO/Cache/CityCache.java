/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Cache;

import de.its.SakilaGEO.City;
import de.its.SakilaGEO.Repository.CityRepository;
import java.util.List;

/**
 *
 * @author BackInBash
 */
public class CityCache implements CacheObserver {

    private CityRepository repo;

    public CityCache(CityRepository repo) {
        this.repo = repo;
    }
    private List<City> allCityCache = repo.findAll();

    public CityCache() {
        
    }

    public List<City> getAll(){
        return allCityCache;
    }
    
    public City getCityByID(long id) {
        if (allCityCache == null) {
            allCityCache = repo.findAll();
        }
        for (var c : allCityCache) {
            if (c.getCityID() == id) {
                return c;
            }
        }
        return null;
    }
    
    public City getCountryByID(long id) {
        if (allCityCache == null) {
            allCityCache = repo.findAll();
        }
        for (var c : allCityCache) {
            if (c.getCountryID() == id) {
                return c;
            }
        }
        return null;
    }
    
    public City findByName(String name){
        if (allCityCache == null) {
            allCityCache = repo.findAll();
        }
        for (var c : allCityCache) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void update() {
        allCityCache = repo.findAll();
    }
}
