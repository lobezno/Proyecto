package adrsoft.scool.model;

public class Alumno {
	
	/*
	 * Campos
	 */
	
	private int idalumno;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private String curso;
	private int club;
	

	/*
	 * Constructores
	 */
	
	public Alumno(){}
	
	public Alumno(int id, String nom, String ape, String dire, int tel, String cur, int clu){
		this.idalumno = id;
		this.nombre = nom;
		this.apellidos = ape;
		this.direccion = dire;
		this.telefono = tel;
		this.curso = cur;
		this.club = clu;
	}
	
	/*
	 * Getters y Setters
	 */

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
	
	@Override
	public String toString(){
		return apellidos;
		
	}
	

}
