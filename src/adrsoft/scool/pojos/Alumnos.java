package adrsoft.scool.pojos;

import java.io.Serializable;

public class Alumnos implements Serializable{
	
	private int idalumno;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String email;
	private String password;
	private int telefono;
	private int centro;
	private String curso;
	private int club;
	
	public Alumnos(){
		
	}
	
	public Alumnos(int id, String nom, String ape, String dni, String dire, String mail, String pass, int tele, int centro, String cur, int clu){
		this.idalumno = id;
		this.nombre = nom;
		this.apellidos = ape;
		this.dni = dni;
		this.direccion = dire;
		this.email = mail;
		this.password = pass;
		this.telefono = tele;
		this.centro = centro;
		this.curso = cur;
		this.club = clu;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCentro() {
		return centro;
	}

	public void setCentro(int centro) {
		this.centro = centro;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getClub() {
		return club;
	}

	public void setClub(int club) {
		this.club = club;
	}
	
	public String toString(){
		return "id: " + idalumno + " - Nombre: "+ nombre + " Apellidos: " + apellidos;
		
	}
	
	

}
