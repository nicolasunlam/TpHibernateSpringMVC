package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Continente {
	//Continente (nombre)
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idContinente;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdContinente() {
		return idContinente;
	}

	public void setIdContinente(Long idContinente) {
		this.idContinente = idContinente;
	}
}
