package com.leadsquared.employeemanagement.config;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JooqConfig {

	private final ConnectionFactory connectionFactory;

	@Bean
	public DSLContext dslContext() {
		return DSL.using(connectionFactory).dsl();
	}
}
