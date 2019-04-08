package co.usergioarboleda.proyectotiempo.modelo.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String correo;

	private String contrasena;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="usuario")
	private List<Actividad> actividads;

	public Usuario() {
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividads().add(actividad);
		actividad.setUsuario(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividads().remove(actividad);
		actividad.setUsuario(null);

		return actividad;
	}

}