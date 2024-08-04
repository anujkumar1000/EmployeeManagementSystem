package com.leadsquared.employeemanagement.project

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO
import com.leadsquared.employeemanagement.dto.project.ProjectCreateDTO
import com.leadsquared.employeemanagement.mapper.EmployeeMapper
import com.leadsquared.employeemanagement.mapper.ProjectMapper
import org.jooq.exception.IntegrityConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject
//
class ProjectRepositorySpecification extends IntegrationTestContainerBase{

	@Subject
	@Autowired
	ProjectRepository repository

	@Autowired
	ProjectMapper mapper

	def 'Check Unique Key Constraint on creation'() {
		given:
		Long code = '-201'
		var input1 = mapper.projectCreateDtoToprojectPojo(new ProjectCreateDTO(code, 'anuj', "abc@gmail.com","kumar","4455"))
		var input2 = mapper.projectCreateDtoToprojectPojo(new ProjectCreateDTO(code, 'anuj', "abc@gmail.com","kumar","4444"))

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


