package com.project.SpringProject;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController 
{
	public ArrayList<Elemento> lista = new ArrayList<Elemento>();
	Elemento elem;
	
		
	@GetMapping()
	public String getUser()
	{
		
		String todo="[ ";
		Iterator<Elemento> it = lista.iterator();
		
		while(it.hasNext())
		{
			elem = it.next();
			todo += elem.toString()+",";
		}
		int size = todo.length();
		todo = todo.substring(0, size-1);
		todo += " ]";
		
		
		
		return todo;
	}
	
		
	@PostMapping("/registrar")
	public void createUser(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion)
	{
		Elemento el = new Elemento(nombre, descripcion);
	 	lista.add(el);
	}
	
}

