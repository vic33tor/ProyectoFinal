package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDD {

	private final String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private Connection conexion;
	private String login = "Proyecto";
	private String contraseña = "Proyecto";
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;


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

	public String mostrarPlatos() {

		PreparedStatement ps;
		String lista = "";

		try {
			ps = conexion.prepareStatement("select * from PLATOS_BEBIDAS where TIPO = 'COMIDA'");
			rs = ps.executeQuery();

			while (rs.next()) {

				lista += "Nombre del plato " + rs.getString(3) + " Precio = " + rs.getDouble(2) + "\n";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "La lista no se ha podido cargar";
		}

		return lista;
	}

	public String mostrarBebidas() {

		PreparedStatement ps;
		String lista = "";

		try {
			ps = conexion.prepareStatement("select * from PLATOS_BEBIDAS where TIPO = 'BEBIDA'");
			rs = ps.executeQuery();

			while (rs.next()) {

				lista += "Nombre de la bebida " + rs.getString(3) + " Precio = " + rs.getDouble(2) + "\n";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "La lista no se ha podido cargar";
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

	public boolean añadirPlato_Bebida(Plato p) {

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

	public boolean eliminarPlato_Bebida(Integer id_plato) {

		boolean alta = false;

		PreparedStatement ps;
		try {

			ps = conexion.prepareStatement("delete PLATOS_BEBIDAS where ID_PLATO = (?)");
			ps.setInt(1, id_plato);
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

	public boolean modificarPrecio(Integer id_plato, Double precio_nuevo) {

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
}
