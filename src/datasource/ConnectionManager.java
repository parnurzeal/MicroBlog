package datasource;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class ConnectionManager{
	public static Connection getConnection() throws SQLException{
		Connection con = null;
		try{
			Context ctx = new InitialContext();
			DataSource dc = (DataSource)ctx.lookup("java:comp/env/jdbc/RelaterDB");
            con = dc.getConnection();
		}catch(NamingException e){
			throw new SQLException(e.getMessage() + ":Database is not correct.");
		}
		return con;
	}
}
