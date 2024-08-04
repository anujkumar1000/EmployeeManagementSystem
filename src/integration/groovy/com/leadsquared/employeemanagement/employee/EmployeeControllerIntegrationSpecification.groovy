package com.leadsquared.employeemanagement.employee

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.employee.EmployeeCreateDTO
import com.leadsquared.employeemanagement.dto.employee.EmployeeDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

class EmployeeControllerIntegrationSpecification extends IntegrationTestContainerBase {
	@Autowired
	private WebTestClient client

	def "Create Employee Entity"() {
		given:
		var apiUrl = '/employee'
		var dto = new EmployeeCreateDTO(10, "anuj", "k","kumar","abc@gmail.com")

		when:
		var response = client.post()
			.uri(apiUrl)
			.body(Mono.just(dto), EmployeeCreateDTO)
			.exchange()

		then:
		var result = response.expectStatus().isCreated().expectHeader()
			.contentType(MediaType.APPLICATION_JSON)
			.expectBody(EmployeeDTO)
			.returnResult()
			.getResponseBody()
		result
		result.employeeId()
		result.firstName()== dto.firstName()
		result.middleName()==dto.middleName()
		result.lastName()==dto.lastName()
		result.email()==dto.email()

	}
}
