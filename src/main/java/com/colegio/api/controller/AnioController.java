package com.colegio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.api.service.AnioService;
import com.colegio.api.entity.Anio;


@RestController
//esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@RequestMapping("/api")
public class AnioController {
	@Autowired
	private AnioService anioService;
	
	public AnioController() {
		
	}
	
	@GetMapping("/")
	public String home(Model model) {
		return "Hola Mundo de Spring MVC.!!!";
	}
	
	/*Este método se hará cuando por una petición 
	 * GET (como indica la anotación) se llame a la url 
	 * http://127.0.0.1:8080/api/anios 
	*/
	@GetMapping("/anios")
	public List<Anio> findAll() {
		return anioService.findAll();
	}
	
	/*Este método se hará cuando por una petición 
	 * GET (como indica la anotación) se llame a la url 
	 * + el id de un usuario
	 * http://127.0.0.1:8080/api/anios/edit/1 
	*/
	
	@GetMapping("anios/edit/{id}")
	public Anio getAnio(@PathVariable int id) {
		Anio a = anioService.findById(id);
		if(a == null) {
			throw new RuntimeException("ID año no encontrado");
		}
		return a;
	}
	
	/*Este método se hará cuando por una 
	 * petición POST (como indica la anotación) 
	 * se llame a la url
	 * http://127.0.0.1:8080/api/anios/  */
	
	@PostMapping("/anios")
	public Anio addAnio(@RequestBody Anio a) {
		a.setId(0);
		anioService.save(a);
		return a;
	}
	
	/*Este método se hará cuando por una petición PUT 
	 * (como indica la anotación) 
	 * se llame a la url
	 * http://127.0.0.1:8080/api/users/  
	*/
	@PutMapping("/anios")
	public Anio updateAnio(@RequestBody Anio a) {
		anioService.save(a);
		return a;
	}
	
	/* Este método se hará cuando por una 
	 * petición DELETE (como indica la anotación) 
	 * se llame a la url + id del usuario
	 * http://127.0.0.1:8080/api/anios/delete/1  
	*/
	
	@DeleteMapping("/anios/delete/{id}")
	public String deleteAnio(@PathVariable int id) {
		Anio a = anioService.findById(id);
		if(a == null) {
			throw new RuntimeException("Año no encontrado");
		}
		anioService.deleteById(id);
		return "Año Fue Eliminado - " + id; 
	}
	
	

	
}
