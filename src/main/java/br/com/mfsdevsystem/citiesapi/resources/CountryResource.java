package br.com.mfsdevsystem.citiesapi.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.citiesapi.dto.CountryDTO;
import br.com.mfsdevsystem.citiesapi.model.Country;
import br.com.mfsdevsystem.citiesapi.services.CountryService;


@RestController
@RequestMapping("/countries")
public class CountryResource {
	

	private CountryService countryService;
	
	public CountryResource(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping
	public ResponseEntity<Page<CountryDTO>> countries(Pageable pageable){
		
		Page<CountryDTO> listCountry = countryService.findAllPaged(pageable);
		
		return ResponseEntity.ok().body( listCountry );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CountryDTO> getOne(@PathVariable Long id) {
		
		CountryDTO dto = countryService.findById( id );
		
		return ResponseEntity.ok().body(dto);
	}
	
}
