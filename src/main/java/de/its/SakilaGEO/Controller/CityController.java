/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import Repository.CityRepo;
import de.its.SakilaGEO.City;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author markus
 */
@RestController
public class CityController {

    private CityRepo repo;
    
    public CityController(CityRepo repo){
        this.repo = repo;
    }
    
    @GetMapping("/get/cities")
    public List<City> getCities() {
        return repo.findAll();
    }
}
