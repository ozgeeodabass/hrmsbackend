package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
