package br.com.mfsdevsystem.citiesapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsystem.citiesapi.dto.CountryDTO;
import br.com.mfsdevsystem.citiesapi.model.Country;
import br.com.mfsdevsystem.citiesapi.repository.CountryRepository;
import br.com.mfsdevsystem.citiesapi.services.exceptions.ResourceNotFoundException;


@Service
public class CountryService {

	private CountryRepository countryRepository;
	
	public CountryService( CountryRepository countryRepository ) {
		this.countryRepository = countryRepository;
	}

	@Transactional(readOnly = true)
	public Page<CountryDTO> findAllPaged( Pageable pageable ){
		Page<Country> listCountry = countryRepository.findAll( pageable );
		return listCountry.map(x-> new CountryDTO(x));
	}
	
	@Transactional(readOnly = true)
	public CountryDTO findById( Long id ) {
		
		Optional<Country> obj = countryRepository.findById(id);
		Country entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not Found"));
		return new CountryDTO( entity );
	}
	
}
