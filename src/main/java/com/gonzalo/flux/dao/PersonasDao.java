package com.gonzalo.flux.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gonzalo.flux.model.Personas;


public interface PersonasDao //extends CrudRepository<Personas, Integer>
{
	
	@Query("SELECT p FROM personas p WHERE" + "\n" +
	"p.nombre = :nombre" + "\n" +
	"p.apellido = :apellido")
	Personas getPersona(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
