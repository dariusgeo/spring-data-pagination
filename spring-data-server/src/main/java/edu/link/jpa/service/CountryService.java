package edu.link.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.link.jpa.model.Country;
import edu.link.jpa.repository.CountryRepository;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional(readOnly = true)
	public List<Country> readAllCountries() {

		return countryRepository.findAll();
	}

}
