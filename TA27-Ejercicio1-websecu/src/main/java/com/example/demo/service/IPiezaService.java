package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {
	
	public List<Pieza> listarPieza(); 
	
	public Pieza guardarPieza(Pieza piezas);
	
	public Pieza pieza(int id); 
	
	public Pieza actualizarPieza(Pieza pieza); 
	
	public void eliminarPieza(int id);
	
}
