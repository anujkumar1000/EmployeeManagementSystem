package com.leadsquared.employeemanagement.employee

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO
import com.leadsquared.employeemanagement.mapper.EmployeeMapper
import org.jooq.exception.IntegrityConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject
//
class EmployeeRepositorySpecification extends IntegrationTestContainerBase {

	@Subject
	@Autowired
	EmployeeRepository repository

	@Autowired
	EmployeeMapper mapper

	def 'Check Unique Key Constraint on creation'() {
		given:
		Long code = '-201'
		var input1 = mapper.employeeCreateDtoToemployeePojo(new EmployeeCreateDTO(code, 'anuj', "k","kumar","abc@gmail.com"))
		var input2 = mapper.employeeCreateDtoToemployeePojo(new EmployeeCreateDTO(code, 'anuj', "k","kumar","abc@gmail.com"))

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

