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

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Livro livro){
		
		try {
			
			String salvar = this.livroService.save(livro);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id,@RequestBody Livro livro){
		
		try {
			
			String alterar = this.livroService.update(id, livro);
			return new ResponseEntity<>(alterar, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll(){
		
		try {
			
			List<Livro> listar = this.livroService.listAll();
			return new ResponseEntity<>(listar, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> fingById(@PathVariable long id){
		
		try {
			
			Livro livro = this.livroService.findById(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		
		try {
			
			String deletar = this.livroService.delete(id);
			return new ResponseEntity<>(deletar, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
 }
