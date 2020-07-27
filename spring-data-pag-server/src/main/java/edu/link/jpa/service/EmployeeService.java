package edu.link.jpa.service;

import edu.link.jpa.dto.EmployeeDTO;
import edu.link.jpa.mapper.EmployeeMapper;
import edu.link.jpa.model.Employee;
import edu.link.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private LogAuditService logAuditService;

	@Transactional(readOnly = true)
	public Page<EmployeeDTO> readAllEmployees(Pageable pageable){
		
		Page<Employee> dbResult = employeeRepository.findAll(pageable);

		return dbResult.map(employee -> employeeMapper.employeeToEmployeeDTO(employee)); //  new PageImpl<>(employeeMapper.employeesToEmployeeDTOs(dbResult.getContent()), pageable, dbResult.getTotalElements());
	}

	@Transactional(readOnly = true)
	public EmployeeDTO readOne(Long id){
		Optional<Employee> employee = employeeRepository.findById(id);

		return employeeMapper.employeeToEmployeeDTO(employee.get());
	}

	// We have, here, the transaction management defined at class level - @Transactional
	// Default propagation behavior - Propagation.REQUIRED
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		logAuditService.createAuditEntry("dummy_value", "update");

		Optional<Employee> dbEmployee = employeeRepository.findById(employeeDTO.getId());

		// Observe employee's version
		Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
		Double salary = employee.getSalary();
		Double bonus = employee.getCommission();
		employee.setCommission(bonus/100);
		employee.setSalary(salary + (salary * employee.getCommission()));

		//dbEmployee = null; // See Propagation.REQUIRES_NEW effect

		// Hook for Mapper
		employee.setDepartment(dbEmployee.get().getDepartment());
		employee.setJob(dbEmployee.get().getJob());

		employee = employeeRepository.save(employee);

		return employeeMapper.employeeToEmployeeDTO(employee);
	}
}
