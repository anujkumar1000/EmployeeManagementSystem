package com.leadsquared.employeemanagement.temp

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import org.jooq.exception.IntegrityConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject
//
class TempRepositorySpecification extends IntegrationTestContainerBase {

	@Subject
	@Autowired
	TempRepository repository

	@Autowired
	TempMapper mapper

	def 'Check Unique Key Constraint on creation'() {
		given:
		var code = '-201'
		var input1 = mapper.tempCreateDtoToTempPojo(new TempCreateDTO(code, 'N-201', 'D-201'))
		var input2 = mapper.tempCreateDtoToTempPojo(new TempCreateDTO(code, 'N-202', 'D-202'))

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
