package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	public String save(Editora editora) {

		this.editoraRepository.save(editora);

		return editora.getNome() + "Editora salva";
	}

	public String update(long id, Editora editora) {

		editora.setId(id);
		this.editoraRepository.save(editora);

		return "Editora salva com sucesso";
	}

	public List<Editora> listAll(){

		return this.editoraRepository.findAll();

	}

	public Editora findById(long id) {

		Editora editora = this.editoraRepository.findById(id).get();

		return editora;

	}

	public String delete(long id) {

		this.editoraRepository.deleteById(id);

		return "Deletado com sucesso";
	}
}
