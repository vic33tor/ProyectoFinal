package src;
import java.sql.Date;

public class Motorista {

	private String dni_motorista;

	private String nombre;

	private Date fecha_ingreso;

	private Boolean activo;



	public Motorista(String dni_motorista, String nombre, Date fecha_ingreso, Boolean activo) {
		this.dni_motorista = dni_motorista;
		this.nombre = nombre;
		this.fecha_ingreso = fecha_ingreso;
		this.activo = activo;
	}

	public String getDni_motorista() {
		return dni_motorista;
	}

	public void setDni_motorista(String dni_motorista) {
		this.dni_motorista = dni_motorista;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

	public void Llevar_pedido(Pedido ped) {
		activo = false;
		//DUDA CON ATRIBUTO ACTIVO
		//DUDA CON OBJETO MOTORISTA
	}

}