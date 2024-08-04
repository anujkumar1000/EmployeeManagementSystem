package com.leadsquared.employeemanagement.department

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.department.DepartmentCreateDTO
import com.leadsquared.employeemanagement.dto.department.DepartmentDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

class DepartmentControllerIntegrationSpecification extends IntegrationTestContainerBase {
	@Autowired
	private WebTestClient client

	def "Create Department Entity"() {
		given:
		var apiUrl = '/department'
		var dto = new DepartmentCreateDTO(10, "anuj", 'abc@gmail.com')

		when:
		var response = client.post()
			.uri(apiUrl)
			.body(Mono.just(dto), DepartmentCreateDTO)
			.exchange()

		then:
		var result = response.expectStatus().isCreated().expectHeader()
			.contentType(MediaType.APPLICATION_JSON)
			.expectBody(DepartmentDTO)
			.returnResult()
			.getResponseBody()
		result
		result.departmentId()
		result.departmentName()== dto.departmentName()
		result.email()==dto.email()

	}
}
