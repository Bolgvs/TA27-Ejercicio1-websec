package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministros(){
		return suministraServiceImpl.listarSuministros();
	}
	
	
	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	
	@GetMapping("/suministra/{id}")
	public Suministra Suministra(@PathVariable(name="id") int id) {
		
		Suministra Suministra = new Suministra();
		
		Suministra =suministraServiceImpl.suministra(id);
		
		return Suministra;
	}
	
	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")int id,@RequestBody Suministra suministra) {
		
		Suministra Suministraseleccionado= new Suministra();
		Suministra Suministraactualizado= new Suministra();
		
		Suministraseleccionado= suministraServiceImpl.suministra(id);
		
		
		Suministraseleccionado.setPieza(suministra.getPieza());
		Suministraseleccionado.setProveedor(suministra.getProveedor());
		Suministraseleccionado.setPrecio(suministra.getPrecio());
		
		Suministraactualizado = suministraServiceImpl.actualizarSuministra(Suministraseleccionado);
		
		return Suministraactualizado;
	}
	
	@DeleteMapping("/suministra/{id}")
	public void eleiminarSuministra(@PathVariable(name="id")int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}
