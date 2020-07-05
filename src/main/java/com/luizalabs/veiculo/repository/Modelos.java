package com.luizalabs.veiculo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.luizalabs.veiculo.model.Modelo;

public interface Modelos extends JpaRepository<Modelo, Long>{

	@Query("SELECT new Modelo(modelo,marca) FROM Modelo GROUP BY marca, modelo ORDER BY marca DESC, modelo")
	List<Modelo> findAllModified();

	Modelo findByModelo(String modelo);

	List<Modelo> findByMarca(String marca);

	@Transactional
	void deleteByModelo(String modelo); 
}
