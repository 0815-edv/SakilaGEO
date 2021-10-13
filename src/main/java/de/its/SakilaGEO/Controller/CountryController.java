/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import de.its.SakilaGEO.Cache.CountryCache;
import de.its.SakilaGEO.Cache.DBCache;
import de.its.SakilaGEO.Country;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import de.its.SakilaGEO.Repository.CountryRepository;

/**
 *
 * @author markus
 */
@RestController
public class CountryController {

    private CountryRepository repo;
    private DBCache cache = new DBCache();
    CountryCache c = new CountryCache();

    public CountryController(CountryRepository repo) {
        this.repo = repo;
        cache.addObserver(c);
    }

    /**
     * Get all Countries from Database
     *
     * @return
     */
    @ApiOperation(value = "Get all Countries from Database")
    @GetMapping(path = "/get/countries", produces = "application/json")
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(c.getAll());
    }

    /**
     * Get Country By ID from Database
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Get Country By ID from Database")
    @GetMapping(path = "/get/country", produces = "application/json")
    public ResponseEntity<Country> getCountryByID(@RequestParam(value = "id", required = true) long id) {
        var countries = c.getCountryByID(id);
        if (countries != null) {
            return ResponseEntity.ok(countries);
        }
        return null;
    }

    /**
     * Add Country to Database
     *
     * @param country
     * @return
     */
    @ApiOperation(value = "Add Country to Database")
    @PostMapping(path = "/set/country")
    public ResponseEntity<String> setCountry(@RequestParam String country) {
        if (c.getCountryByName(country) == null) {
            repo.save(new Country(country));
            cache.notifyObservers();
            return new ResponseEntity<>("Country entity added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Country entity already added.", HttpStatus.CONFLICT);
    }

    /**
     * Delete Country by ID
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Delete Country from Database")
    @DeleteMapping(path = "/del/country")
    public ResponseEntity<String> deleteCountry(@RequestParam(value = "id", required = true) long id) {
        if (c.getCountryByID(id) != null) {
            repo.deleteById(id);
            cache.notifyObservers();
            return new ResponseEntity<>("Country entity deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Country entity not found.", HttpStatus.NOT_FOUND);
    }
    
    /**
     * Update City
     * @param id
     * @param cityName
     * @param countryID
     * @return 
     */
    @ApiOperation(value="Update Country")
    @PatchMapping(path="/update/country")
    public ResponseEntity<String> updateCity(@RequestParam(value = "id", required = true) long id, @RequestParam(required = true) String countryName) {
        var getCountry = c.getCountryByID(id);
        Country update = new Country();
        update.setName(countryName);

        repo.save(getCountry.update(update));
        cache.notifyObservers();
        return new ResponseEntity<>("City entity updated.", HttpStatus.OK);
    }
}
