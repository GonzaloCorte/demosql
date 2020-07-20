package com.gonzalo.flux.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gonzalo.flux.model.Personas;

@SpringBootApplication
public class Main implements CommandLineRunner{

	@Autowired
	PersonasDao dao;
	Personas p;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Main.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		p = dao.getPersona("Norberto", "Gutierrez");
		
		System.out.println(p.getNombre());
	}

}
