/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author markus
 */
@RestController
public class CountryController {
    @GetMapping("/get/countries")
    public Object getCountries(){
        return null;
    }
    
}
