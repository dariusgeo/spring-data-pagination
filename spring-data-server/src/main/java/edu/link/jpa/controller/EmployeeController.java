package edu.link.jpa.controller;

import edu.link.jpa.dto.EmployeeDTO;
import edu.link.jpa.service.EmployeeService;
import edu.link.jpa.util.AppPageRequest;
import edu.link.jpa.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path="/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PutMapping
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		if (employeeDTO.getId() == null){
			return new ResponseEntity<>(null,  HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO),  HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<EmployeeDTO>> getAll(/*@RequestParam("_page") int page, @RequestParam("_size") int size,*/
													Pageable pageable) throws URISyntaxException {

		Page<EmployeeDTO> result = employeeService.readAllEmployees(pageable);
		
		if(result.isEmpty()){
		   return new ResponseEntity<>(null, PaginationUtil.generateEmptyPaginationHttpHeaders(pageable, "/api/employees/all"),
				   HttpStatus.NO_CONTENT);
		}

		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(result, "/api/employees/all");
	    return new ResponseEntity<>(result.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeDTO> getById(/*@RequestParam("id") Long id*/ @PathVariable(name = "id") Long id) {

		EmployeeDTO result = employeeService.readOne(id);

		if (result == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
