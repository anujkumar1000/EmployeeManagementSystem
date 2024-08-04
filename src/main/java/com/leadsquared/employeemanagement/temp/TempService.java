package com.leadsquared.employeemanagement.temp;
//
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TempService {

	private final TempRepository repository;
	private final TempMapper mapper;

	public Mono<TempDTO> create(TempCreateDTO dto) {
		var temp = mapper.tempCreateDtoToTempPojo(dto)
			.setCreatedBy("creator");
		return repository.create(temp)
			.map(mapper::tempPojoToTempDTO);
	}

	public Mono<TempDTO> retrieveByCode(String code) {
		return repository.retrieveByCode(code)
			.map(mapper::tempPojoToTempDTO);
	}

	public Flux<TempDTO> retrieve() {
		return repository.retrieve()
			.map(mapper::tempPojoToTempDTO);
	}

	public Mono<TempDTO> update(TempUpdateDTO dto) {
		var temp = mapper.tempUpdateDtoToTempPojo(dto)
			.setModifiedBy("modifier");
		return repository.update(temp)
			.map(mapper::tempPojoToTempDTO);
	}

	public Mono<Void> delete(String code) {
		return repository.delete(code);
	}
}
