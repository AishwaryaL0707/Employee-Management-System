 package in.newhr.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/*this class returns connection ref object whenever required*/
	public static Connection requestConnection() {
		Connection con=null;
		/*First 2 steps of jdbc has been implemented*/
		String url="jdbc:mysql://localhost:3306/newhr";
		String user="root";
		String password="tiger";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
