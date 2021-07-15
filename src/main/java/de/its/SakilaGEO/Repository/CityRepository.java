/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.SakilaGEO.Repository;

import de.its.SakilaGEO.City;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author markus
 */
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
}
