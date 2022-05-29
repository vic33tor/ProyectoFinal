package src;
import java.sql.Date;
import java.time.LocalDate;

/**
 * clase de los pedidos 
 * @author víctor
 *
 */
public class Pedido {

	private Integer id_pedido;

	private LocalDate fecha;

	private Double precio;
	
	private String dni_motorista;
	
	private String dni_cliente;
	

	public Pedido(Integer id_pedido, LocalDate localDate, Double precio, String dni_motorista, String dni_cliente) {
		super();
		this.id_pedido = id_pedido;
		this.fecha = localDate;
		this.precio = precio;
		this.dni_motorista = dni_motorista;
		this.dni_cliente = dni_cliente;
	}
	
	
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getDni_motorista() {
		return dni_motorista;
	}


	public void setDni_motorista(String dni_motorista) {
		this.dni_motorista = dni_motorista;
	}


	public String getDni_cliente() {
		return dni_cliente;
	}


	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	



	

}