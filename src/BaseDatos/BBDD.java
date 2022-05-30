package BaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import src.Cliente;
import src.Ingrediente;
import src.Pedido;
import src.Plato;
/**
 * Clase para acceder a la base de datos
 * @author víctor
 *
 */
public class BBDD {

	private final String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private Connection conexion;
	private String login = "Proyecto";
	private String contraseña = "Proyecto";
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;

	public static Cliente c;
	public static Pedido p;
	public static Plato plato;
	public static Integer contador = 1;


	public BBDD(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, login, contraseña);
			if(conexion!=null) {
				System.out.println("Conexión con la base de datos correcta");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrar() {
		try {
			if (conexion!=null)
				conexion.close();
			System.out.println("Conexión cerrada con la BD");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return devuelve una lista de todos los platos de la base de datos
	 */
	public ArrayList <String> mostrarNombrePlatos() {

		PreparedStatement ps;
		ArrayList <String> lista = new ArrayList <String>();

		try {
			ps = conexion.prepareStatement("select NOMBRE from PLATOS_BEBIDAS where TIPO = 'COMIDA'");
			rs = ps.executeQuery();

			while (rs.next()) {

				lista.add(rs.getString(1));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return lista;
	}
	/**
	 * 
	 * @return devuelve una lista de todos los platos y bebidas de la base de datos
	 */
	public ArrayList <String> mostrarPlatos_Bebidas() {

		PreparedStatement ps;
		ArrayList <String> lista = new ArrayList <String>();
		try {
			ps = conexion.prepareStatement("select NOMBRE from PLATOS_BEBIDAS");
			rs = ps.executeQuery();

			while (rs.next()) {

				lista.add(rs.getString(1));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return lista;
	}
	/**
	 * 
	 * @param c un objeto de la clase cliente
	 * @return devuelve un boolean que indica si se ha insertado el cliente en la base de datos o no
	 */
	public boolean darAltaCliente(Cliente c) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into CLIENTES values(?,?,?,?)");
			ps.setString(1, c.getDni_cliente());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getDireccion());
			ps.setString(4, c.getContraseña());
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param p un objeto de la clase plato
	 * @return devuelve un boolean que indica si se ha insertado el plato o la bebida en la base de datos o no
	 */
	public boolean anhadirPlato_Bebida(Plato p) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into PLATOS_BEBIDAS values(?,?,?,?)");
			ps.setInt(1, p.getId_plato());
			ps.setDouble(2, p.getPrecio());
			ps.setString(3, p.getNombre());
			ps.setString(4, p.getTipo());
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param n el nombre del plato a eliminar
	 * @return devuelve un boolean que indica si se ha borrado el plato de la base de datos o no
	 */
	public boolean eliminarPlato_Bebida(String n) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("delete PLATOS_BEBIDAS where NOMBRE = (?)");
			ps.setString(1, n);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han borrado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param n el nombre del ingrediente a eliminar
	 * @return devuelve un boolean que indica si se ha borrado el ingrediente de la base de datos o no
	 */
	public boolean eliminarIngrediente(String n) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("delete INGREDIENTES where NOMBRE = (?)");
			ps.setString(1, n);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han borrado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param id_plato el id del plato a cambiar
	 * @param precio_nuevo el precio a cambiar
	 * @return devuelve un boolean que indica si se ha modificado el precio del plato en la base de datos o no
	 */
	public boolean modificarPrecio(int id_plato, Double precio_nuevo) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("update PLATOS_BEBIDAS set PRECIO = (?) where ID_PLATO = (?)");
			ps.setDouble(1, precio_nuevo);
			ps.setInt(2, id_plato);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han modificado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param s el email del cliente 
	 * @return devuelve un boolean que indica si el email existe en la base de datos
	 */
	public boolean mostrarEmail(String s) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select EMAIL from CLIENTES where EMAIL = '"+s+"'");
			while(rs.next()) {
				lista = rs.getString("EMAIL");
			}
			if(lista.equals(s)) {
				return true;
			}else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}
	}


	/**
	 * 
	 * @param s el email del cliente
	 * @param c la contraseña del cliente
	 * @return devuelve un boolean que indica si ese email tiene esa contraseña en la base de datos
	 */
	public boolean mostrarContraseña(String s, String c) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select CONTRASEÑA from CLIENTES where EMAIL = '"+s+"'");
			while(rs.next()) {
				lista = rs.getString("CONTRASEÑA");
			}
			if(lista.equals(c)) {
				return true;
			}else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}
	}
	/**
	 * 
	 * @param s el email del cliente
	 * @return devuelve el dni del cliente 
	 */
	public String mostrarDni(String s) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select DNI_CLIENTE from CLIENTES where EMAIL = '"+s+"'");
			while(rs.next()) {
				lista = rs.getString("DNI_CLIENTE");
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param s el email del cliente
	 * @return devuelve la direccion del cliente
	 */
	public String mostrarDireccion(String s) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select DIRECCION from CLIENTES where EMAIL = '"+s+"'");
			while(rs.next()) {
				lista = rs.getString("DIRECCION");
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param c la contraseña del administrador
	 * @return devuelve un boolean que indica si la contraseña es la del administrador en la base de datos
	 */
	public boolean mostrarContraseñaAdmin(String c) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select CONTRASEÑA from ADMINISTRADOR where CONTRASEÑA = '"+c+"'");
			while(rs.next()) {
				lista = rs.getString("CONTRASEÑA");
			}
			if(lista.equals(c)) {
				return true;
			}else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}


	}
	/**
	 * 
	 * @param c la contraseña del administrador
	 * @return devuleve el dni del administrador 
	 */
	public String mostrarDniAdmin(String c) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select DNI_ADMIN from ADMINISTRADOR where CONTRASEÑA = '"+c+"'");
			while(rs.next()) {
				lista = rs.getString("DNI_ADMIN");
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @return devuelve el id de plato mas alto + 1
	 */
	public int mostrarMAXID_PLATO() {

		int id = 0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select MAX(ID_PLATO) from PLATOS_BEBIDAS");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id +1;


		} catch (SQLException e) {
			e.getStackTrace();
			return 1;
		}
	}
	/**
	 * 
	 * @return devuelve el id de ingrediente mas alto + 1
	 */
	public int mostrarMAXID_Ingrediente() {

		int id = 0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select MAX(ID_INGREDIENTE) from INGREDIENTES");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id +1;


		} catch (SQLException e) {
			e.getStackTrace();
			return 1;
		}
	}
	/**
	 * 
	 * @param i un objeto de la clase ingrediente
	 * @return devuelve un boolean que indica si se ha insertado el ingrediente en la base de datos
	 */
	public boolean anhadirIngrediente(Ingrediente i) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into INGREDIENTES values(?,?,?)");
			ps.setInt(1, i.getId_ingrediente());
			ps.setString(2, i.getNombre());
			ps.setDouble(3, i.getCantidad());
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param i id del ingrediente
	 * @param p id del plato
	 * @param c cantidad que lleva ese plato de ese ingrediente
	 * @return devuelve un boolean que indica si se ha realizado el insert en la tabla plato_ingrediente en la base de datos
	 */
	public boolean darAltaPLATO_INGRED(int i,int p, String c) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into PLATO_INGREDIENTE values(?,?,?)");
			ps.setInt(1, Integer.valueOf(i));
			ps.setInt(2, p);
			ps.setDouble(3, Double.valueOf(c));
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param p nombre del plato
	 * @return devuelve el id del plato
	 */
	public int mostrarID_Plato(String p) {

		int id = 0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select ID_PLATO from PLATOS_BEBIDAS where NOMBRE = '"+p+"'");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id;


		} catch (SQLException e) {
			e.getStackTrace();
			return 0;
		}
	}
	/**
	 * 
	 * @param i nombre del ingrediente
	 * @return devuelve el id del ingrediente
	 */
	public int mostrarID_Ingrediente(String i) {

		int id = 0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select ID_INGREDIENTE from INGREDIENTES where NOMBRE = '"+i+"'");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id;


		} catch (SQLException e) {
			e.getStackTrace();
			return 0;
		}
	}
	/**
	 * 
	 * @param p id del plato
	 * @return devuelve un boolean que indica si se ha hecho el delete en la tabla plato_ingrediente en la base de datos
	 */
	public boolean eliminarPlato_Ingrediente(int p) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("delete PLATO_INGREDIENTE where ID_PLATO ='"+p+"'");
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han borrado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param s nombre del plato
	 * @return devuelve el precio del plato
	 */
	public Double mostrarPrecio(String s) {

		Double precio = 0.0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select PRECIO from PLATOS_BEBIDAS where NOMBRE = '"+s+"'");
			while(rs.next()) {
				precio = rs.getDouble("PRECIO");
			}
			return precio;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param i id del plato
	 * @return devuelve una lista de nombres de ingredientes que estan en el plato
	 */
	public ArrayList <String> mostrarINGREDIENTES_PLATO(int i) {

		ArrayList <String> lista = new ArrayList <String>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT NOMBRE FROM INGREDIENTES JOIN PLATO_INGREDIENTE ON INGREDIENTES.ID_INGREDIENTE = PLATO_INGREDIENTE.ID_INGREDIENTE WHERE ID_PLATO = '"+i+"'");
			while(rs.next()) {
				lista.add(rs.getString("NOMBRE"));
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param s nombre del plato
	 * @return devuelve si es un plato o una bebida
	 */
	public String mostrarTipo(String s) {

		String tipo = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select TIPO from PLATOS_BEBIDAS where NOMBRE = '"+s+"'");
			while(rs.next()) {
				tipo = rs.getString("TIPO");
			}
			return tipo;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param n nombre del plato
	 * @return devuelve un objeto plato
	 */
	public Plato mostrarTodo_Plato(String n) {

		PreparedStatement ps;
		Plato pl = null;

		try {
			ps = conexion.prepareStatement("select * from PLATOS_BEBIDAS where NOMBRE = '"+n+"'");
			rs = ps.executeQuery();


			while (rs.next()) {


				pl = new Plato(rs.getInt(1),rs.getString(3),rs.getDouble(2),rs.getString(4), contador);


			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return pl;
	}
	/**
	 * 
	 * @param p objeto de la clase pedido
	 * @return devuelve un boolean que indica si se ha insertado el pedido en la base de datos
	 */
	public boolean anhadirPedido(Pedido p) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into PEDIDOS values(?,?,?,?,?)");
			ps.setInt(1, p.getId_pedido());
			ps.setDate(2, Date.valueOf(p.getFecha()));
			ps.setDouble(3, p.getPrecio());
			ps.setString(4, p.getDni_motorista());
			ps.setString(5, p.getDni_cliente());
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @return devuelve el dni de motorista que menos pedidos lleva realizados
	 */
	public String mostrarDni_motorista() {

		String DNI = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select DNI_MOTORISTA from MOTORISTAS order by NUM_PEDIDOS DESC");
			while(rs.next()) {
				DNI = rs.getString("DNI_MOTORISTA");
			}
			return DNI;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @return devuelve el id de pedido mas alto + 1
	 */
	public int mostrarMAXID_PEDIDO() {

		int id = 0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select MAX(ID_PEDIDO) from PEDIDOS");
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id +1;


		} catch (SQLException e) {
			e.getStackTrace();
			return 1;
		}
	}
	/**
	 * 
	 * @param id_pedido id del pedido
	 * @param id_plato id del plato
	 * @param cantidad cantidad de ese plato en el pedido
	 * @return devuelve un boolean que indica si se ha insertado el pedido y el plato en la base de datos
	 */
	public boolean anhadirPedido_Plato(int id_pedido, int id_plato, int cantidad) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into PEDIDO_PLATO values(?,?,?)");
			ps.setInt(1, id_pedido);
			ps.setInt(2, id_plato);
			ps.setInt(3, cantidad);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param cantidad_ingrediente cantidad que se va a restar del ingrediente
	 * @param id_ingrediente id del ingrediente
	 * @return devuelve un boolean que indica si se ha realizado el update en la base de datos
	 */
	public boolean modificarCantidad(Double cantidad_ingrediente,int id_ingrediente) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("update INGREDIENTES set CANTIDAD = CANTIDAD - (?) where ID_INGREDIENTE = (?)");
			ps.setDouble(1, cantidad_ingrediente);
			ps.setInt(2, id_ingrediente);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han modificado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param id_plato id del plato
	 * @param id_ingrediente id del ingrediente
	 * @return devuelve la cantidad que hay del ingrediente en el plato
	 */
	public Double mostrarCantidadIngrediente(int id_plato,int id_ingrediente) {

		Double cantidad = 0.0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select CANTIDAD_INGREDIENTE from PLATO_INGREDIENTE where ID_INGREDIENTE = '"+id_ingrediente+"' and ID_PLATO = '"+id_plato+"'");
			while(rs.next()) {
				cantidad = rs.getDouble("CANTIDAD_INGREDIENTE");
			}
			return cantidad;

		} catch (SQLException e) {
			e.getStackTrace();
			return 0.0;
		}
	}
	/**
	 * 
	 * @param dni dni del motorista
	 * @return devuelve un boolean que indica si se han modificado el numero de pedidos del motorista
	 */
	public boolean modificarNum_pedidos(String dni) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("update MOTORISTAS set NUM_PEDIDOS = NUM_PEDIDOS+(?) where DNI_MOTORISTA = (?)");
			ps.setInt(1, 1);
			ps.setString(2, dni);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han modificado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param id_ingrediente id del ingrediente
	 * @return devuelve la cantidad de ese ingrediente existente en la base de datos
	 */
	public Double mostrarCantidadIngredienteAlmacen(int id_ingrediente) {

		Double cantidad = 0.0;

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select CANTIDAD from INGREDIENTES where ID_INGREDIENTE = '"+id_ingrediente+"'");
			while(rs.next()) {
				cantidad = rs.getDouble("CANTIDAD");
			}
			return cantidad;

		} catch (SQLException e) {
			e.getStackTrace();
			return 0.0;
		}
	}
	/**
	 * 
	 * @param cantidad_ingrediente la cantidad que se va a comprar
	 * @param id_ingrediente el id del ingrediente
	 * @return devueleve un boolean que indica si se ha realizado el update del ingrediente
	 */
	public boolean ComprarIngrediente(Double cantidad_ingrediente,int id_ingrediente) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("update INGREDIENTES set CANTIDAD = (?) where ID_INGREDIENTE = (?)");
			ps.setDouble(1, cantidad_ingrediente);
			ps.setInt(2, id_ingrediente);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han modificado los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
	/**
	 * 
	 * @param i dni del cliente
	 * @return devuelve una lista de los pedidos del cliente
	 */
	public ArrayList <String> mostrarPedido(String i) {

		ArrayList <String> lista = new ArrayList <String>();
		String pedido = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT ID_PEDIDO, FECHA, PRECIO FROM PEDIDOS WHERE DNI_CLIENTE = '"+i+"'");
			while(rs.next()) {
				pedido = String.valueOf(rs.getInt("ID_PEDIDO"))+","+String.valueOf(rs.getDate("FECHA"))+","+String.valueOf(rs.getDouble("PRECIO"));
				lista.add(pedido);
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param id id del pedido
	 * @return devuelve una lista de los platos de ese pedido
	 */
	public ArrayList <String> mostrarPlato(int id) {

		ArrayList <String> lista = new ArrayList <String>();
		String plato ="";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT NOMBRE, PRECIO FROM PLATOS_BEBIDAS JOIN PEDIDO_PLATO ON PLATOS_BEBIDAS.ID_PLATO = PEDIDO_PLATO.ID_PLATO WHERE ID_PEDIDO = '"+id+"'");

			while (rs.next()) {
				plato = rs.getString("NOMBRE")+","+String.valueOf(rs.getDouble("PRECIO"));
				lista.add(plato);


			}
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
