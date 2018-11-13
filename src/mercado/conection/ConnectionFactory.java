package mercado.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bdmercado";
	private static final String USER = "root";
	private static final String PASS = "123456";
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(URL, USER, PASS);
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		
	}
		
}
