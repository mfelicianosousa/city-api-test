package br.com.mfsdevsystem.citiesapi.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.citiesapi.dto.StateDTO;
import br.com.mfsdevsystem.citiesapi.services.StateService;

@RestController
@RequestMapping("/states")
public class StateResource {
	
    private StateService stateService;
	
	public StateResource(StateService stateService) {
		this.stateService = stateService;
	}

	@GetMapping
	public ResponseEntity<Page<StateDTO>> states(Pageable pageable){
		
		Page<StateDTO> listState = stateService.findAllPaged(pageable);
		
		return ResponseEntity.ok().body( listState );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateDTO> getOne(@PathVariable Long id) {
		
		StateDTO dto = stateService.findById( id );
		
		return ResponseEntity.ok().body(dto);
	}

}
