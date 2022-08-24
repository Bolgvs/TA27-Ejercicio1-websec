package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorService {

	public List<Proveedor> listarProveedor();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor proveedor(int id);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(int id);
	
}
