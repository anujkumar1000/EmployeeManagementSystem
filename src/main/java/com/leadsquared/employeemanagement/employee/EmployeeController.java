package com.leadsquared.employeemanagement.employee;


import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeDTO;
import com.leadsquared.employeemanagement.dto.employee.EmployeeUpdateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<EmployeeDTO> create(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO) {
		return service.create(employeeCreateDTO);
	}

	@GetMapping("/{code}")
	public Mono<EmployeeDTO> retrieveByCode(@PathVariable String code) {
		return service.retrieveByCode(code);
	}

	@GetMapping
	public Flux<EmployeeDTO> retrieve() {
		return service.retrieve();
	}

	@PatchMapping("/{id}")
	public Mono<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeUpdateDTO dto) {
		return service.update(new EmployeeUpdateDTO(  id,dto.firstName(), dto.middleName()));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}

