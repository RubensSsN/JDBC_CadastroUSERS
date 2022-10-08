package normal_package;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {

	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "Eustompoojovi345";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro_pessoas";
	
	public static Connection createConnectionToMySQL() throws Exception {

		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conexão obetida com sucesso!");
			con.close();
		}
	}

}
