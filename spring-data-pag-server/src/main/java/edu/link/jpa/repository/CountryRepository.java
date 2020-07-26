package edu.link.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.link.jpa.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
	
	List<Country> findAll();

}
