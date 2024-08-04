package com.leadsquared.employeemanagement.employee;

import com.leadsquared.employeemanagement.jooq.tables.pojos.Employee;
import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static com.leadsquared.employeemanagement.jooq.Tables.EMPLOYEE;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

	private final DSLContext dsl;
	private final EmployeeMapper mapper;

	 public Mono<Employee> create(Employee input) {
		return Mono.from(dsl
				.insertInto(EMPLOYEE)
				.set(mapper.employeePojoToemployeeRecord(input))
				.returningResult(EMPLOYEE.EMPLOYEE_ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	public  Mono<Employee> findById(Long id) {
		return Mono.from(dsl
				.selectFrom(EMPLOYEE)
				.where(EMPLOYEE.EMPLOYEE_ID.eq(id))
			)
			.map(r -> r.into(Employee.class));
	}

	 public Mono<Employee> retrieveByCode(String code) {
		return Mono.from(dsl
				.selectFrom(EMPLOYEE)
				.where(EMPLOYEE.EMAIL.eq(code))
			)
			.map(r -> r.into(Employee.class));
	}

	 public Flux<Employee> retrieve() {
		return Flux.from(dsl
				.selectFrom(EMPLOYEE)
				.orderBy(EMPLOYEE.FIRST_NAME.asc())
			)
			.map(r -> r.into(Employee.class));
	}

	 public Mono<Employee> update(Employee employee) {
		return Mono.from(dsl
				.update(EMPLOYEE)
				.set(EMPLOYEE.FIRST_NAME, employee.getFirstName())
				.where(EMPLOYEE.EMPLOYEE_ID.eq(employee.getEmployeeId()))
				.returningResult(EMPLOYEE.EMPLOYEE_ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	 public Mono<Void> delete(Long id) {
		return Mono.from(dsl
				.deleteFrom(EMPLOYEE)
				.where(EMPLOYEE.LAST_NAME.eq(String.valueOf(id)))
			)
			.then(Mono.empty());
	}
}

