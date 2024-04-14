package br.com.mfsdevsystem.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.citiesapi.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
