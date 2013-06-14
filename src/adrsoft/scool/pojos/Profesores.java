package adrsoft.scool.pojos;

import java.io.Serializable;

/**
 * Clase mapeadora de los datos de los profesores. Crea objetos Profesores los cuales podemos manipular
 * antes de enviarlos para su almacenamiento en la base de datos.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Profesores implements Serializable{

	/**
	 * Campos
	 */
	private static final long serialVersionUID = 1L;
	private int idprofesor;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String email;
	private String password;
	private int telefono;
	private int centro;
	private int materia;
	private int padrino;
	private int club;
	
	/**
	 * Constructor de objetos de la clase Profesor. Se pasan todos los parametros para poder manejar el objeto.
	 * @param idprofesor = Identificador del profesor.
	 * @param nombre = Nombre.
	 * @param apellidos = Apellidos.
	 * @param dni = Documento de identidad.
	 * @param direccion = Dirección.
	 * @param email = Email de contacto y de login.
	 * @param password = Contraseña
	 * @param telefono = Teléfono.
	 * @param centro = Centro en el que trabaja.
	 * @param materia = Materia que imparte
	 * @param padrino = Booleano que determina si es padrino de algún club o no.
	 * @param club = Club del que es padrino.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	public Profesores(int idprofesor, String nombre, String apellidos,
			String dni, String direccion, String email, String password,
			int telefono, int centro, int materia, int padrino, int club) {
		super();
		this.idprofesor = idprofesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.centro = centro;
		this.materia = materia;
		this.padrino = padrino;
		this.club = club;
	}


	/**
	 * Constructor vacío de la clase.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	public Profesores(){
		
	}

	//Getters y Setters
	public int getIdprofesor() {
		return idprofesor;
	}


	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
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


	public int getMateria() {
		return materia;
	}


	public void setMateria(int materia) {
		this.materia = materia;
	}


	public int getPadrino() {
		return padrino;
	}


	public void setPadrino(int padrino) {
		this.padrino = padrino;
	}


	public int getClub() {
		return club;
	}


	public void setClub(int club) {
		this.club = club;
	}
	
	

}
