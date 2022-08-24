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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/pieza")
	public List<Pieza> listarPieza(){
		return piezaServiceImpl.listarPieza();
	}
	
	
	@PostMapping("/pieza")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/pieza/{id}")
	public Pieza Pieza(@PathVariable(name="id") int id) {
		
		Pieza Pieza = new Pieza();
		
		Pieza = piezaServiceImpl.pieza(id);
		
		return Pieza;
	}
	
	@PutMapping("/pieza/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza Pieza) {
		
		Pieza Piezaseleccionado = new Pieza();
		Pieza Piezaactualizado = new Pieza();
		
		Piezaseleccionado = piezaServiceImpl.pieza(id);
		
		Piezaseleccionado.setNombre(Pieza.getNombre());
		
		Piezaactualizado = piezaServiceImpl.actualizarPieza(Piezaseleccionado);
		
		return Piezaactualizado;
	}
	
	@DeleteMapping("/pieza/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		piezaServiceImpl.eliminarPieza(id);
	}
}