package es.studium.EjercicioClasePerro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainPerro {

	static final String CONNECTOR = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/ad_tema2?autoReconnect=true&useSSL=false";
	static final String LOGIN = "root";
	static final String PASS = "Studium2018;";

	public static void main(String[] args) {

		createTablePerros();
		insertPerro(1, "Labrador", "mediano", 2, "canela");
	}

	public static void createTablePerros() {

		
		
		String sentencia = "CREATE TABLE IF NOT EXISTS ad_tema2.perros (idPerro INT NOT NULL, razaPerro VARCHAR(45) NOT NULL, tamanoPerro VARCHAR(45) NOT NULL, edadPerro INT(2) NOT NULL, colorPerro VARCHAR(45) NOT NULL, PRIMARY KEY (idPerro));";

		try {
			Class.forName(CONNECTOR);
			Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
			
			connect.createStatement().executeUpdate(sentencia);

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
		}
	}

	public static void insertPerro(int id, String raza, String tam, int edad, String color) {

		String sentencia = "INSERT INTO perros VALUES('" + id + "', '" + raza + "', '" + tam + "', '" + edad + "', '" + color + "');";
		System.out.println(sentencia);
		try {
			Class.forName(CONNECTOR);
			Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
			
			connect.createStatement().executeUpdate(sentencia);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertPerro(Perro perro) {
		
		MainPerro.insertPerro(perro.getId(), perro.getRaza(), perro.getTamano(), perro.getEdad(), perro.getColor());
	}
	
	public static Perro getPerro(Integer id) {
		
		String sentencia = "SELECT * FROM perros WHERE idPerro = '" + id + "';";
		Perro resultado = new Perro();
		
		try {
			Class.forName(CONNECTOR);
			Connection connect = DriverManager.getConnection(URL, LOGIN, PASS);
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			
			if (rs.first()) {
				
				resultado = new Perro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
}