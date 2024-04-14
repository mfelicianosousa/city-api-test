package br.com.mfsdevsystem.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.citiesapi.model.State;

public interface StateRepository extends JpaRepository<State, Long> {
}
