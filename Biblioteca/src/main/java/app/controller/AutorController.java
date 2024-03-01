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

import app.entity.Autor;
//import app.entity.Livro;
import app.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Autor autor){

		try {

			String salvar = this.autorService.save(autor);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id,@RequestBody Autor autor){

		try {

			String alterar = this.autorService.update(id, autor);
			return new ResponseEntity<>(alterar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Autor>> listAll(){

		try {

			List<Autor> listar = this.autorService.listAll();
			return new ResponseEntity<>(listar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Autor> findById(@PathVariable long id){

		try {

			Autor autor = this.autorService.findById(id);
			return new ResponseEntity<>(autor, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){

		try {

			String deletar = this.autorService.delete(id);
			return new ResponseEntity<>(deletar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

}
