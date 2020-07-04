package edu.link.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="countries")
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cty_seq_gen")
	@SequenceGenerator(name="cty_seq_gen", sequenceName="countries_seq", allocationSize = 1)
	private String countryId;
	
	@Column(name="country_name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "region_id")
	private Region region;

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}

