package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="generales")
public class General {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String rango;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="generalessoldados",
	  joinColumns = {@JoinColumn(name="id_general", referencedColumnName = "id")},
	  inverseJoinColumns = {@JoinColumn(name="id_soldado", referencedColumnName ="id")})
	private List<Soldado> soldados;

	public General() {
		super();
	}

	public General(String nombre, String rango) {
		super();
		this.nombre = nombre;
		this.rango = rango;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public List<Soldado> getSoldados() {
		return soldados;
	}

	public void setSoldados(List<Soldado> soldados) {
		this.soldados = soldados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof General))
			return false;
		General other = (General) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "General [id=" + id + ", nombre=" + nombre + ", rango=" + rango + ", soldados=" + soldados
				+ "]";
	}

	
}
