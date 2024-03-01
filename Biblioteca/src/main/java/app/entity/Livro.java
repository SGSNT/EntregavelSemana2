package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String issn;
	private String titulo;
	private String sinopse;
	private Integer ano;
	private Integer numPag;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Editora editora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Biblioteca biblioteca;
	
	@ManyToMany
	@JoinTable(
			
				name="livro_autor",
				joinColumns = @JoinColumn(name="livro_id"),
				inverseJoinColumns = @JoinColumn(name="autor_id")
			  
			)
	
	private List<Autor> autores;
	
}
