/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import de.its.SakilaGEO.City;
import de.its.SakilaGEO.Country;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import de.its.SakilaGEO.Repository.CountryRepositpry;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author markus
 */
@RestController
public class CountryController {

    private CountryRepositpry repo;

    public CountryController(CountryRepositpry repo) {
        this.repo = repo;
    }

    /**
     * Get all Countries from Database
     *
     * @return
     */
    @ApiOperation(value = "Get all Countries from Database")
    @GetMapping(path = "/get/countries", produces = "application/json")
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(repo.findAll());
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
        var countries = repo.findById(id);
        if (!countries.isEmpty()) {
            return ResponseEntity.ok(countries.get());
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
        if (repo.findByName(country).isEmpty()) {
            repo.save(new Country(country));
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
        if (!repo.findById(id).isEmpty()) {
            repo.deleteById(id);
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
        var getCity = repo.findById(id).get();
        Country update = new Country();
        update.setName(countryName);

        repo.save(getCity.update(update));
        return new ResponseEntity<>("City entity updated.", HttpStatus.OK);
    }
}
