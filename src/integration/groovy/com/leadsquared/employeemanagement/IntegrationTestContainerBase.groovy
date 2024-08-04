package com.leadsquared.employeemanagement

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.TestPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.lifecycle.Startables
import org.testcontainers.spock.Testcontainers
import org.testcontainers.utility.DockerImageName
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(
	classes = App,
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = [
		'spring.flyway.enabled=true',
		'spring.flyway.baseline-on-migrate=true',
		'spring.flyway.clean-disabled=false',
		'spring.flyway.clean-on-validation-error=true',
		'spring.flyway.create-schemas=true'
	]
)
@AutoConfigureWebTestClient
@Testcontainers
@TestPropertySource(locations = "classpath:application.yml")
abstract class IntegrationTestContainerBase extends Specification {
	@LocalServerPort
	protected int localServerPort

	private static final flywaySchemas = 'test'

	@Shared
	static final MySQLContainer mySQL = new MySQLContainer<>(DockerImageName.parse('mysql:8.3.0'))
		.withUsername('root')
		.withPassword('secret_password')
		.withDatabaseName(flywaySchemas)
		.withCommand('--log_bin_trust_function_creators=1 --default-authentication-plugin=mysql_native_password')
		.withCreateContainerCmdModifier { cmd -> cmd.getHostConfig().withCpuPercent(95) }
		.withTmpFs([
			'/var/lib/mysql': 'rw,noexec,nosuid',
			'/tmp/'         : 'rw,noexec,nosuid'
		])

	static {
		Startables.deepStart(mySQL).join()
	}

	@DynamicPropertySource
	static void overrideProperties(DynamicPropertyRegistry registry) {
		// MySQL
		// flyway
		registry.add('spring.flyway.url', mySQL::getJdbcUrl)
		registry.add('spring.flyway.user', mySQL::getUsername)
		registry.add('spring.flyway.password', mySQL::getPassword)
		registry.add('spring.flyway.schemas', () -> flywaySchemas)

		// app
		registry.add('spring.r2dbc.url', () -> mySQL.getJdbcUrl().replace('jdbc', 'r2dbc'))
		registry.add('spring.r2dbc.username', mySQL::getUsername)
		registry.add('spring.r2dbc.password', mySQL::getPassword)
	}
}
