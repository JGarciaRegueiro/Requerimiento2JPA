package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="soldados")
public class Soldado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String rango;
	
	@ManyToMany(mappedBy="soldados", cascade = CascadeType.PERSIST)
	private List<General> generales;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_regimiento", referencedColumnName = "id")
	private Regimiento regimiento;
	
	@OneToOne
	@JoinColumn(name="id")
	private Equipamiento equipamiento;

	public Soldado() {
		super();
	}

	public Soldado(String nombre, String rango) {
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

	public List<General> getGenerales() {
		return generales;
	}

	public void setGenerales(List<General> generales) {
		this.generales = generales;
	}

	public Regimiento getRegimiento() {
		return regimiento;
	}

	public void setRegimiento(Regimiento regimiento) {
		this.regimiento = regimiento;
	}

	public Equipamiento getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(Equipamiento equipamiento) {
		this.equipamiento = equipamiento;
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
		if (!(obj instanceof Soldado))
			return false;
		Soldado other = (Soldado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Soldado [id=" + id + ", nombre=" + nombre + ", rango=" + rango + ", generales=" + generales
				+ ", regimiento=" + regimiento + ", equipamiento=" + equipamiento + "]";
	}
	
	

}
