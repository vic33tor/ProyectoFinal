package src;
import java.sql.Date;


public class Pedido {

	private Integer id_pedido;

	private Date fecha;

	private Double precio;
	
	private String dni_motorista;
	
	private String dni_cliente;
	

	public Pedido(Integer id_pedido, Date fecha, Double precio, String dni_motorista, String dni_cliente) {
		super();
		this.id_pedido = id_pedido;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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