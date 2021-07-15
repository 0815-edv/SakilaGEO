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

    @GetMapping("/get/countries")
    public List<Country> getCountries() {
        return repo.findAll();
    }

}
