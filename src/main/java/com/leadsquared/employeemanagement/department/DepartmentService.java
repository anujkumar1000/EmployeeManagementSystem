package com.leadsquared.employeemanagement.department;

import com.leadsquared.employeemanagement.dto.department.DepartmentCreateDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentUpdateDTO;
import com.leadsquared.employeemanagement.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository repository;
	private final DepartmentMapper mapper;

	public Mono<DepartmentDTO> create(DepartmentCreateDTO dto) {
		var Department = mapper.departmentCreateDtoTodepartmentPojo(dto);

		return repository.create(Department)
			.map(mapper::departmentPojoTodepartmentDTO);
	}

	public Mono<DepartmentDTO> retrieveByCode(String code) {
		return repository.retrieveByCode(code)
			.map(mapper::departmentPojoTodepartmentDTO);
	}

	public Flux<DepartmentDTO> retrieve() {
		return repository.retrieve()
			.map(mapper::departmentPojoTodepartmentDTO);
	}

	public Mono<DepartmentDTO> update(DepartmentUpdateDTO dto) {
		var department = mapper.departmentUpdateDtoTodepartmentPojo(dto)
			.setCreatedby("anuj")
			.setModifiedby("modifier");
		return repository.update(department)
			.map(mapper::departmentPojoTodepartmentDTO);
	}

	public Mono<Void> delete(Long id) {
		return repository.delete(id);
	}
}