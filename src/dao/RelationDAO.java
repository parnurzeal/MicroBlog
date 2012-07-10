package dao;

import java.util.*;
import java.sql.*;

import beans.Relation;
import beans.User;

public class RelationDAO extends GenericDAO{
	public RelationDAO(Connection con){
		super(con);
	}
	public int insertRelation(Relation r) throws SQLException{
		
		String sql = "INSERT INTO RELATIONS (ownerid, message,relatedate) VALUES(?,?,?)";
		PreparedStatement pstmt = con_.prepareStatement(sql);
		pstmt.setInt(1,r.getOwnerID());
		pstmt.setString(2,r.getMessage());
		pstmt.setTimestamp(3, r.getRelateDate());
		int cnt = pstmt.executeUpdate();
		
		return cnt;
		
//		String sql="INSERT INTO RELATIONS VALUES(null," 
//					+ r.getOwnerID() + " ," 
//					+"'" + r.getMessage() +"'," 
//					+ "'"+ r.getRelateDate()+ "')";
//			Statement stmt = con_.createStatement();
//			int cnt = stmt.executeUpdate(sql);
//			System.out.println("IN RELATION::::::");
//			System.out.println(sql);
//		return cnt;
		
	}
	
	public ArrayList<Relation> selectAll(int userID) throws SQLException{
		String sql="SELECT * FROM USERS WHERE USERID="+userID;
		
		Statement stmt = con_.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		User tmpU = null;
		if(rs.next()){
			tmpU = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}else{
			return null;
		}
		
		sql="SELECT * FROM RELATIONS WHERE OWNERID="+userID;
		stmt = con_.createStatement();
		rs = stmt.executeQuery(sql);
		ArrayList<Relation> list= new ArrayList<Relation>();
		while (rs.next()){
			Relation tmpR = new Relation(rs.getInt(1),userID,
					tmpU.getUsername(),tmpU.getPassword(),
					rs.getString(3),rs.getTimestamp(4));
			list.add(tmpR);
		}
		
		return list;
	}
	
	
	
	
}
