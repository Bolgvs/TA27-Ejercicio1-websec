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

import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedor")
	public List<Proveedor> listarProveedor(){
		return proveedorServiceImpl.listarProveedor();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedor/{id}")
	public Proveedor Proveedor(@PathVariable(name="id") int id) {
		
		Proveedor Proveedor = new Proveedor();
		
		Proveedor = proveedorServiceImpl.proveedor(id);
		
		return Proveedor;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")int id,@RequestBody Proveedor Proveedor) {
		
		Proveedor Proveedorseleccionado = new Proveedor();
		Proveedor Proveedoractualizado = new Proveedor();
		
		Proveedorseleccionado = proveedorServiceImpl.proveedor(id);
		
		Proveedorseleccionado.setNombre(Proveedor.getNombre());
		
		Proveedoractualizado = proveedorServiceImpl.actualizarProveedor(Proveedorseleccionado);
		
		return Proveedoractualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eleiminarProveedor(@PathVariable(name="id")int id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}
	
}