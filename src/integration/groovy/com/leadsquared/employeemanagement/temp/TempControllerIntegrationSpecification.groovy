package com.leadsquared.employeemanagement.temp

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

class TempControllerIntegrationSpecification extends IntegrationTestContainerBase {
	@Autowired
	private WebTestClient client

	def "Create Temp Entity"() {
		given:
		var apiUrl = '/temp'
		var dto = new TempCreateDTO('-101', 'N-101', 'D-101')

		when:
		var response = client.post()
			.uri(apiUrl)
			.body(Mono.just(dto), TempCreateDTO)
			.exchange()

		then:
		var result = response.expectStatus().isCreated().expectHeader()
			.contentType(MediaType.APPLICATION_JSON)
			.expectBody(TempDTO)
			.returnResult()
			.getResponseBody()
		result
		result.id()
		result.code() == dto.code()
		result.name() == dto.name()
		result.description() == dto.description()
	}
}
