package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaService bibliotecaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca){
		
		try {
			
			String salvar = this.bibliotecaService.save(biblioteca);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
		@PutMapping("/update/{id}")
		public ResponseEntity<String> update(@PathVariable long id, @RequestBody Biblioteca biblioteca){
			
			try {
				
				String alterar = this.bibliotecaService.update(id, biblioteca);
				return new ResponseEntity<>(alterar, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		}
		
		@GetMapping("/listAll")
		public ResponseEntity<List<Biblioteca>> listAll(){
			
			try {
				
				List<Biblioteca> listar = this.bibliotecaService.listAll();
				return new ResponseEntity<>(listar, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		}
		
		@GetMapping("/findById/{id}")
		public ResponseEntity<Biblioteca> findById(@PathVariable long id){
			
			try {
				
				Biblioteca biblioteca = this.bibliotecaService.findById(id);
				return new ResponseEntity<>(biblioteca, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable long id){
			
			try {
				
				String deletar = this.bibliotecaService.delete(id);
				return new ResponseEntity<>(deletar, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			
		}
}
