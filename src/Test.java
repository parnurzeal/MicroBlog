import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dao.*;
import datasource.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/RELATER" +
					"?useUnicode=true&characterEncoding=Windows-31J",
					"relater", "password");
			UserDAO dao = new UserDAO(con);
			ArrayList<User> list = dao.selectFriends(1);
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i));
			}

			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){}
		}
		return;
		
	}

}
