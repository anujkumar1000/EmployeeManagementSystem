package com.leadsquared.employeemanagement.temp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {

	private final TempService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<TempDTO> create(@Valid @RequestBody TempCreateDTO tempCreateDTO) {
		return service.create(tempCreateDTO);
	}

	@GetMapping("/{code}")
	public Mono<TempDTO> retrieveByCode(@PathVariable String code) {
		return service.retrieveByCode(code);
	}

	@GetMapping
	public Flux<TempDTO> retrieve() {
		return service.retrieve();
	}

	@PatchMapping("/{code}")
	public Mono<TempDTO> update(@PathVariable String code, @RequestBody TempUpdateDTO dto) {
		return service.update(new TempUpdateDTO(code, dto.name(), dto.description()));
	}

	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable String code) {
		return service.delete(code);
	}
}
