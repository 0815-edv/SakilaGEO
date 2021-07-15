/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import de.its.SakilaGEO.Country;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import de.its.SakilaGEO.Repository.CountryRepositpry;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @ApiOperation(value = "Add Country to Database")
    @PostMapping(path = "/set/country")
    public ResponseEntity<String> setCountry(@RequestParam String country) {
        if (repo.findByName(country).isEmpty()) {
            repo.save(new Country(country));
            return new ResponseEntity<>("Country entity added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Country entity already added.", HttpStatus.CONFLICT);
    }
}
