package com.leadsquared.employeemanagement.temp;
//
import com.leadsquared.employeemanagement.jooq.tables.pojos.Temp;
import com.leadsquared.employeemanagement.temp.TempMapper;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.leadsquared.employeemanagement.jooq.Tables.TEMP;

@Repository
@RequiredArgsConstructor
class TempRepository {

	private final DSLContext dsl;
	private final TempMapper mapper;

	Mono<Temp> create(Temp input) {
		return Mono.from(dsl
				.insertInto(TEMP)
				.set(mapper.tempPojoToTempRecord(input))
				.returningResult(TEMP.ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	Mono<Temp> findById(Long id) {
		return Mono.from(dsl
				.selectFrom(TEMP)
				.where(TEMP.ID.eq(id))
			)
			.map(r -> r.into(Temp.class));
	}

	Mono<Temp> retrieveByCode(String code) {
		return Mono.from(dsl
				.selectFrom(TEMP)
				.where(TEMP.CODE.eq(code))
			)
			.map(r -> r.into(Temp.class));
	}

	Flux<Temp> retrieve() {
		return Flux.from(dsl
				.selectFrom(TEMP)
				.orderBy(TEMP.NAME.asc())
			)
			.map(r -> r.into(Temp.class));
	}

	Mono<Temp> update(Temp temp) {
		return Mono.from(dsl
				.update(TEMP)
				.set(TEMP.NAME, temp.getName())
				.set(TEMP.DESCRIPTION, temp.getDescription())
				.where(TEMP.CODE.eq(temp.getCode()))
				.returningResult(TEMP.ID)
			)
			.flatMap(id -> findById(id.value1()));
	}

	Mono<Void> delete(String code) {
		return Mono.from(dsl
				.deleteFrom(TEMP)
				.where(TEMP.CODE.eq(code))
			)
			.then(Mono.empty());
	}
}
