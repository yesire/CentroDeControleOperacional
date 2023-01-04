package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Coletivo;


@Repository
public interface ColetivoRepository extends JpaRepository<Coletivo, Long> {
	
	Optional<Coletivo> findByPrefixo (String Prefixo);

	Optional<Coletivo> findByPlaca (String placa);

	Optional<Coletivo> findByDoc (String doc);
	
}