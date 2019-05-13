package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pais {
	//Pais (nombre, habitantes, idioma, capital, continente)
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPais;

	private String nombre;

	private Long habitantes;
	private String idioma;

	@OneToOne
	private Ciudad capital;

	@ManyToOne(cascade={CascadeType.ALL} , fetch = FetchType.LAZY)
	private Continente continente;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Long habitantes) {
		this.habitantes = habitantes;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Ciudad getCapital() {
		return capital;
	}
	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}
	public Continente getContinente() {
		return continente;
	}
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

}
