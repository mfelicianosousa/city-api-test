package br.com.mfsdevsystem.citiesapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsystem.citiesapi.dto.CityDTO;
import br.com.mfsdevsystem.citiesapi.model.City;
import br.com.mfsdevsystem.citiesapi.repository.CityRepository;
import br.com.mfsdevsystem.citiesapi.services.exceptions.ResourceNotFoundException;


@Service
public class CityService {

	private CityRepository cityRepository;
	
	public CityService( CityRepository cityRepository ) {
		this.cityRepository = cityRepository;
	}

	@Transactional(readOnly = true)
	public Page<CityDTO> findAllPaged( Pageable pageable ){
		Page<City> listCity = cityRepository.findAll( pageable );
		return listCity.map(x-> new CityDTO(x));
	}
	
	@Transactional(readOnly = true)
	public CityDTO findById( Long id ) {
		
		Optional<City> obj = cityRepository.findById(id);
		
		
		City entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not Found"));
		return new CityDTO( entity );
	}
	
}
