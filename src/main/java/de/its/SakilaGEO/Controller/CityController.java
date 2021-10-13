/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import de.its.SakilaGEO.Cache.CityCache;
import de.its.SakilaGEO.Cache.DBCache;
import de.its.SakilaGEO.City;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import de.its.SakilaGEO.Repository.CityRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author markus
 */
@RestController
public class CityController {

    private CityRepository repo;
    private DBCache cache = new DBCache();
    CityCache c = new CityCache();

    public CityController(CityRepository repo) {
        this.repo = repo;
        cache.addObserver(c);
    }

    /**
     * Get all Cities from Database
     *
     * @return
     */
    @GetMapping(path = "/get/cities", produces = "application/json")
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok(c.getAll());
    }

    /**
     * Get City By ID from Database
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/get/city", produces = "application/json")
    public ResponseEntity<City> getCity(@RequestParam(value = "id", required = true) long id) {
        var city = c.getCityByID(id);
        if (city != null) {
            return ResponseEntity.ok(city);
        }
        return null;
    }
    
    /**
     * Get Cities By Country ID from Database
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/get/cityByID", produces = "application/json")
    public ResponseEntity<City> getCitybyID(@RequestParam(value = "id", required = true) long id) {
        var city = c.getCountryByID(id);
        if (city != null) {
            return ResponseEntity.ok(city);
        }
        return null;
    }

    /**
     * Add City to Database
     *
     * @param cityName
     * @param countryID
     * @return
     */
    @ApiOperation(value = "Add City to Database")
    @PostMapping(path = "/set/city")
    public ResponseEntity<String> setCity(@RequestParam String cityName, @RequestParam long countryID) {       
        if (c.findByName(cityName) == null) {
            repo.save(new City(cityName, countryID));
            cache.notifyObservers();
            return new ResponseEntity<>("City entity added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("City entity already added.", HttpStatus.CONFLICT);
    }

    /**
     * Delete City by ID
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Delete City from Database")
    @DeleteMapping(path = "/del/city")
    public ResponseEntity<String> deleteCity(@RequestParam(value = "id", required = true) long id) {
        if (c.getCityByID(id) != null) {
            repo.deleteById(id);
            cache.notifyObservers();
            return new ResponseEntity<>("City entity deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("City entity not found.", HttpStatus.NOT_FOUND);
    }

    
    /**
     * Update City
     * @param id
     * @param cityName
     * @param countryID
     * @return 
     */
    @ApiOperation(value="Update City")
    @PatchMapping(path="/update/city")
    public ResponseEntity<String> updateCity(@RequestParam(value = "id", required = true) long id, @RequestParam(required = true) String cityName, @RequestParam(required = true) long countryID) {
        var getCity = c.getCityByID(id);
        City update = new City();
        update.setName(cityName);
        update.setCountryID(countryID);

        repo.save(getCity.update(update));
        cache.notifyObservers();
        return new ResponseEntity<>("City entity updated.", HttpStatus.OK);
    }

}
