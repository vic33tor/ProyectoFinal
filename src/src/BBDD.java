package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public String mostrarDni(String s) {

		String lista = "";

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select DNI from CLIENTES where EMAIL = '"+s+"'");
			while(rs.next()) {
				lista = rs.getString("DNI");
			}
			return lista;

		} catch (SQLException e) {
			e.getStackTrace();
			return null;
		}
	}
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
	
	public boolean darAltaPedido(Pedido p) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("insert into PEDIDOS values(?,SYSDATE,?,?,?)");
			ps.setInt(1, p.getId_pedido());
			ps.setDouble(2, p.getPrecio());
			ps.setString(3, p.getDni_motorista());
			ps.setString(4, p.getDni_cliente()); 
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
	
	public boolean darAltaPedido_Plato(int id_pedido, int id_plato, int cantidad) {

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
			e.printStackTrace();
			alta = false;
			return alta;
		}
		return alta;

	}
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
}
