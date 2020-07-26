package edu.link.jpa.model;
///*package jpa.training.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "phones")
//public class Phone {
//	
//	@Id
//	@Column(name = "phone_id")
//	private Long phoneId;
////	
////	@OneToOne(fetch= FetchType.LAZY, mappedBy = "phone")
////	private Employee employee;
////	
//	
//	@OneToOne(fetch = FetchType.LAZY)
//	@MapsId
//	private Employee employee;
//	
//	private String number;
//	private Integer internalExtension;
//	
//	public Long getPhoneId() {
//		return phoneId;
//	}
//	public void setPhoneId(Long phoneId) {
//		this.phoneId = phoneId;
//	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	public String getNumber() {
//		return number;
//	}
//	public void setNumber(String number) {
//		this.number = number;
//	}
//	public Integer getInternalExtension() {
//		return internalExtension;
//	}
//	public void setInternalExtension(Integer internalExtension) {
//		this.internalExtension = internalExtension;
//	}
//	
//	
//}