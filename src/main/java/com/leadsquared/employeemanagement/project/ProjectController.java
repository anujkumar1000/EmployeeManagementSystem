package com.leadsquared.employeemanagement.project;

import com.leadsquared.employeemanagement.dto.project.ProjectCreateDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectUpdateDTO;
import com.leadsquared.employeemanagement.project.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ProjectDTO> create(@Valid @RequestBody ProjectCreateDTO projectCreateDTO) {
		return service.create(projectCreateDTO);
	}

	@GetMapping("/{code}")
	public Mono<ProjectDTO> retrieveByCode(@PathVariable String code) {
		return service.retrieveByCode(code);
	}

	@GetMapping
	public Flux<ProjectDTO> retrieve() {
		return service.retrieve();
	}

	@PatchMapping("/{id}")
	public Mono<ProjectDTO> update(@PathVariable Long id, @RequestBody ProjectUpdateDTO dto) {
		return service.update(new ProjectUpdateDTO( id, dto.projectName(), dto.description()));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}

