package com.leadsquared.employeemanagement.department

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.department.DepartmentCreateDTO
import com.leadsquared.employeemanagement.mapper.DepartmentMapper
import org.jooq.exception.IntegrityConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject
//
class DepartmentRepositorySpecification extends IntegrationTestContainerBase {

	@Subject
	@Autowired
	DepartmentRepository repository

	@Autowired
	DepartmentMapper mapper

	def 'Check Unique Key Constraint on creation'() {
		given:
		Long code = '-201'
		var input1 = mapper.departmentCreateDtoTodepartmentPojo(new DepartmentCreateDTO(code, 'anuj', "abc@gmail.com"))
		var input2 = mapper.departmentCreateDtoTodepartmentPojo(new DepartmentCreateDTO(code, 'anujk', "abcd@gmail.com"))

		when:
		var result = repository.create(input1).block()

		then:
		result
		result.code == code
		input1.code == code
		input2.code == code

		when:
		result = repository.create(input2).block()

		then:
		thrown IntegrityConstraintViolationException
	}
}
