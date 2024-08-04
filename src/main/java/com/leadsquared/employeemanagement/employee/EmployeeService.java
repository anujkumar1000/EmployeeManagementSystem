package com.leadsquared.employeemanagement.employee;

import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeUpdateDTO;
import com.leadsquared.employeemanagement.mapper.EmployeeMapper;
import com.leadsquared.employeemanagement.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository repository;
	private final EmployeeMapper mapper;

	public Mono<EmployeeDTO> create(EmployeeCreateDTO dto) {
		var employee = mapper.employeeCreateDtoToemployeePojo(dto);
		return repository.create(employee)
			.map(mapper::employeePojoToemployeeDTO);
	}

	public Mono<EmployeeDTO> retrieveByCode(String code) {
		return repository.retrieveByCode(code)
			.map(mapper::employeePojoToemployeeDTO);
	}

	public Flux<EmployeeDTO> retrieve() {
		return repository.retrieve()
			.map(mapper::employeePojoToemployeeDTO);
	}

	public Mono<EmployeeDTO> update(EmployeeUpdateDTO dto) {
		var department = mapper.employeeUpdateDtoToemployeePojo(dto)
			.setModifiedby("modifier");
		return repository.update(department)
			.map(mapper::employeePojoToemployeeDTO);
	}

	public Mono<Void> delete(Long id) {
		return repository.delete(id);
	}
}

