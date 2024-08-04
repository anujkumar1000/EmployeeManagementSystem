package com.leadsquared.employeemanagement.project

import com.leadsquared.employeemanagement.IntegrationTestContainerBase
import com.leadsquared.employeemanagement.dto.project.ProjectCreateDTO
import com.leadsquared.employeemanagement.dto.project.ProjectDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

import java.time.LocalDateTime

class ProjectControllerIntegrationSpecification extends IntegrationTestContainerBase {
	@Autowired
	private WebTestClient client

	def "Create Project Entity"() {
		given:
		var apiUrl = '/project'
		var dto = new ProjectCreateDTO("db", "abc@gmail.com","anuj", LocalDateTime.now())

		when:
		var response = client.post()
			.uri(apiUrl)
			.body(Mono.just(dto), ProjectDTO)
			.exchange()

		then:
		var result = response.expectStatus().isCreated().expectHeader()
			.contentType(MediaType.APPLICATION_JSON)
			.expectBody(ProjectDTO)
			.returnResult()
			.getResponseBody()

		result
		result.projectName()==dto.projectName()
		result.email()==dto.email()
		result.createdby()==dto.createdby()
//		result.createdOn()==dto.createdOn()

	}
}
