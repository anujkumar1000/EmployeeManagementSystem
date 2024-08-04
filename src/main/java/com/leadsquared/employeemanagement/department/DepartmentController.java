package com.leadsquared.employeemanagement.department;


import com.leadsquared.employeemanagement.dto.department.DepartmentCreateDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentDTO;
import com.leadsquared.employeemanagement.dto.department.DepartmentUpdateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<DepartmentDTO> create(@Valid @RequestBody DepartmentCreateDTO departmentCreateDTO) {
		return service.create(departmentCreateDTO);
	}

	@GetMapping("/{code}")
	public Mono<DepartmentDTO> retrieveByCode(@PathVariable String code) {
		return service.retrieveByCode(code);
	}

	@GetMapping
	public Flux<DepartmentDTO> retrieve() {
		return service.retrieve();
	}

	@PatchMapping("/{id}")
	public Mono<DepartmentDTO> update(@PathVariable Long id , @RequestBody DepartmentUpdateDTO dto) {
		return service.update(new DepartmentUpdateDTO(id,dto.departmentName(), dto.email()));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}