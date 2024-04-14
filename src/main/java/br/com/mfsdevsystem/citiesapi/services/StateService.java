package br.com.mfsdevsystem.citiesapi.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsystem.citiesapi.dto.StateDTO;
import br.com.mfsdevsystem.citiesapi.model.State;
import br.com.mfsdevsystem.citiesapi.repository.StateRepository;
import br.com.mfsdevsystem.citiesapi.services.exceptions.ResourceNotFoundException;


@Service
public class StateService {

	private StateRepository stateRepository;
	
	public StateService( StateRepository stateRepository ) {
		this.stateRepository = stateRepository;
	}

	@Transactional(readOnly = true)
	public Page<StateDTO> findAllPaged( Pageable pageable ){
		Page<State> listState = stateRepository.findAll( pageable );
		return listState.map(x-> new StateDTO(x));
	}
	
	@Transactional(readOnly = true)
	public StateDTO findById( Long id ) {
		
		Optional<State> obj = stateRepository.findById(id);
		State entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not Found"));
		return new StateDTO( entity );
	}
	
}
