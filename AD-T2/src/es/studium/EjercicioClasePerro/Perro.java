package es.studium.EjercicioClasePerro;

public class Perro {

	private Integer id;
	private String raza;
	private String tamano;
	private Integer edad;
	private String color;
	
	
	public Perro (Integer id, String raza, String tamano, Integer edad, String color) {
		
		this.id = id;
		this.raza = raza;
		this.tamano = tamano;
		this.edad = edad;
		this.color = color;
				
	}
	
	public Perro() {
		
		id = -1;
		raza = "";
		tamano = "";
		edad = -1;
		color = "";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getTamano() {
		return tamano;
	}


	public void setTamano(String tamano) {
		this.tamano = tamano;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public void insertPerro() {
		
		MainPerro.insertPerro(this.getId(), this.getRaza(), this.getTamano(), this.getEdad(), this.getColor());
	}
}


