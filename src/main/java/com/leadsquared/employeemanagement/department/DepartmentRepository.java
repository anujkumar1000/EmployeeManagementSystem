package com.leadsquared.employeemanagement.department;

import com.leadsquared.employeemanagement.jooq.tables.pojos.Department;
import com.leadsquared.employeemanagement.mapper.DepartmentMapper;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.leadsquared.employeemanagement.jooq.Tables.DEPARTMENT;



@Repository
@RequiredArgsConstructor
public class DepartmentRepository {
	private final DSLContext dsl;
	private final DepartmentMapper mapper;



   public  Mono<Department> create(Department input) {
		return Mono.from(dsl
				.insertInto(DEPARTMENT)
				.set(mapper.departmentPojoTodepartmentRecord(input))
				.returningResult(DEPARTMENT.DEPARTMENT_ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	public  Mono<Department> findById(Long id) {
		return Mono.from(dsl
				.selectFrom(DEPARTMENT)
				.where(DEPARTMENT.DEPARTMENT_ID.eq(id))
			)
			.map(r -> r.into(Department.class));
	}

	 public Mono<Department> retrieveByCode(String code) {
		return Mono.from(dsl
				.selectFrom(DEPARTMENT)
				.where(DEPARTMENT.EMAIL.eq(code))
			)
			.map(r -> r.into(Department.class));
	}

	public  Flux<Department> retrieve() {
		return Flux.from(dsl
				.selectFrom(DEPARTMENT)
				.orderBy(DEPARTMENT.DEPARTMENT_NAME.asc())
			)
			.map(r -> r.into(Department.class));
	}

	public  Mono<Department> update(Department department) {
		return Mono.from(dsl
				.update(DEPARTMENT)
				.set(DEPARTMENT.DEPARTMENT_NAME	, department.getDepartmentName())
				.where(DEPARTMENT.DEPARTMENT_ID.eq(department.getDepartmentId()))
				.returningResult(DEPARTMENT.DEPARTMENT_ID)
			)
			.flatMap(id -> findById( id.value1()));
	}



	public  Mono<Void> delete(Long id) {
		return Mono.from(dsl
				.deleteFrom(DEPARTMENT)
				.where(DEPARTMENT.DEPARTMENT_ID.eq(id))
			)
			.then(Mono.empty());
	}


}

