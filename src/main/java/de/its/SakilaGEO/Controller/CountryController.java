/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import Repository.CountryRepo;
import de.its.SakilaGEO.Country;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author markus
 */
@RestController
public class CountryController {
    
    private CountryRepo repo = null;
    
    public CountryController(CountryRepo repo){
        this.repo = repo;
    }
    
    @GetMapping("/get/countries")
    public List<Country> getCountries(){
        return repo.findAll();
    }
    
}
