package edu.link.jpa.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.link.jpa.SpringDataServerApplication;
import edu.link.jpa.model.Country;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringDataServerApplication.class })
public class CountryServiceIT {

	@Autowired
	private CountryService underTest;

	@Test
	public void readAllCountries() {
		List<Country> countryList = underTest.readAllCountries();

		countryList.stream().forEach(emp -> System.out.println(emp.getName()));

		assertFalse(countryList.isEmpty());
	}

}
