package edu.link.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.link.jpa.dto.EmployeeDTO;
import edu.link.jpa.model.Employee;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface EmployeeMapper {

//	@Mapping(source = "job.id", target = "jobId")
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	List<EmployeeDTO> employeesToEmployeeDTOs(List<Employee> employees);

//	@Mapping(source = "jobId", target = "job.id")
	Employee employeeDTOToEmployee(EmployeeDTO employee);
	
	List<Employee> employeeDTOsToEmployees(List<EmployeeDTO> employees);

}
