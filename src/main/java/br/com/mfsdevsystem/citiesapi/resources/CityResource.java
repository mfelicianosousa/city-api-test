package br.com.mfsdevsystem.citiesapi.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.citiesapi.dto.CityDTO;
import br.com.mfsdevsystem.citiesapi.model.City;
import br.com.mfsdevsystem.citiesapi.services.CityService;


@RestController
@RequestMapping("/cities")
public class CityResource {
	

	private CityService cityService;
	
	public CityResource(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping
	public ResponseEntity<Page<CityDTO>> cities(Pageable pageable){
		
		Page<CityDTO> listCity = cityService.findAllPaged(pageable);
		
		return ResponseEntity.ok().body( listCity );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityDTO> getOne(@PathVariable Long id) {
		
		CityDTO dto = cityService.findById( id );
		
		return ResponseEntity.ok().body(dto);
	}
	
}
