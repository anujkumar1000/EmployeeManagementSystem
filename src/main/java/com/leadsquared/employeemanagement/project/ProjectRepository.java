package com.leadsquared.employeemanagement.project;

import com.leadsquared.employeemanagement.jooq.tables.pojos.Project;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.leadsquared.employeemanagement.jooq.Tables.PROJECT;
import static com.leadsquared.employeemanagement.jooq.Tables.TEMP;

@Repository
@RequiredArgsConstructor
 public class ProjectRepository {

	private final DSLContext dsl;
	private final ProjectMapper mapper;

	 public Mono<Project> create(Project input) {
		return Mono.from(dsl
				.insertInto(PROJECT)
				.set(mapper.projectPojoToprojectRecord(input))
				.returningResult(PROJECT.PROJECT_ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	 public Mono<Project> findById(Long id) {
		return Mono.from(dsl
				.selectFrom(PROJECT)
				.where(PROJECT.PROJECT_ID.eq(id))
			)
			.map(r -> r.into(Project.class));
	}

	 public Mono<Project> retrieveByCode(String code) {
		return Mono.from(dsl
				.selectFrom(PROJECT)
				.where(PROJECT.EMAIL.eq(code))
			)
			.map(r -> r.into(Project.class));
	}

	 public Flux<Project> retrieve() {
		return Flux.from(dsl
				.selectFrom(PROJECT)
				.orderBy(PROJECT.PROJECT_ID.asc())
			)
			.map(r -> r.into(Project.class));
	}

	 public Mono<Project> update(Project project) {
		return Mono.from(dsl
				.update(PROJECT)
				.set(PROJECT.PROJECT_NAME, project.getProjectName())
				.where(PROJECT.PROJECT_ID.eq(project.getProjectId()))
				.returningResult(PROJECT.PROJECT_ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	 public Mono<Void> delete(Long id) {
		return Mono.from(dsl
				.deleteFrom(PROJECT)
				.where(PROJECT.PROJECT_NAME.eq(String.valueOf(id)))
			)
			.then(Mono.empty());
	}
}
