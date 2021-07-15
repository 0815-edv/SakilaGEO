/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import de.its.SakilaGEO.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author markus
 */
public interface CityRepo extends JpaRepository<City, Long>{
    
}
