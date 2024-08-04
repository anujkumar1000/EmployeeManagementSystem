package com.leadsquared.employeemanagement.project;

import com.leadsquared.employeemanagement.dto.project.ProjectCreateDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectDTO;
import com.leadsquared.employeemanagement.dto.project.ProjectUpdateDTO;
import com.leadsquared.employeemanagement.mapper.ProjectMapper;
import com.leadsquared.employeemanagement.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectRepository repository;
	private final ProjectMapper mapper;

	public Mono<ProjectDTO> create(ProjectCreateDTO dto) {
		var project = mapper.projectCreateDtoToprojectPojo(dto)
			.setCreatedby("anuj").setCreatedOn(LocalDateTime.now());
		return repository.create(project)
			.map(mapper::projectPojoToprojectDTO);
	}

	public Mono<ProjectDTO> retrieveByCode(String code) {
		return repository.retrieveByCode(code)
			.map(mapper::projectPojoToprojectDTO);
	}

	public Flux<ProjectDTO> retrieve() {
		return repository.retrieve()
			.map(mapper::projectPojoToprojectDTO);
	}

	public Mono<ProjectDTO> update(ProjectUpdateDTO dto) {
		var project = mapper.projectUpdateDtoToprojectPojo(dto)
			.setModifiedby("modifier");
		return repository.update(project)
			.map(mapper::projectPojoToprojectDTO);
	}

	public Mono<Void> delete(Long id) {
		return repository.delete(id);
	}
}
