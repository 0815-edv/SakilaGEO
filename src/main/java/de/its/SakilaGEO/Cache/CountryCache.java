/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Cache;

import de.its.SakilaGEO.Country;
import de.its.SakilaGEO.Repository.CountryRepository;
import java.util.List;

/**
 *
 * @author BackInBash
 */
public class CountryCache implements CacheObserver {

    private CountryRepository repo;

    public CountryCache(CountryRepository repo) {
        this.repo = repo;
    }
    private List<Country> allCountryCache = repo.findAll();

    public CountryCache() {
        
    }
    
    public List<Country> getAll(){
        return allCountryCache;
    }

    public Country getCountryByID(long id) {
        if (allCountryCache == null) {
            allCountryCache = repo.findAll();
        }
        for (var c : allCountryCache) {
            if (c.getCountry_id() == id) {
                return c;
            }
        }
        return null;
    }
    
    public Country getCountryByName(String name) {
        if (allCountryCache == null) {
            allCountryCache = repo.findAll();
        }
        for (var c : allCountryCache) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void update() {
        allCountryCache = repo.findAll();
    }
}
