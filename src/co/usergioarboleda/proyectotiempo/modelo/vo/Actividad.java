package co.usergioarboleda.proyectotiempo.modelo.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="correo")
	private Usuario usuario;

	public Actividad() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}