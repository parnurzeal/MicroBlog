package dao;

import java.util.*;
import java.sql.*;

import javax.sql.*;
import beans.User;

public class UserDAO extends GenericDAO{
	public UserDAO(Connection con){
		super(con);
	}
	public int registerUser(User u) throws SQLException{

		String sql = "INSERT INTO USERS VALUES(null, ?,?,?)";
		PreparedStatement pstmt = con_.prepareStatement(sql);
		pstmt.setString(1,u.getUsername());
		pstmt.setString(2,u.getNickname());
		pstmt.setString(3, u.getPassword());
		int cnt = pstmt.executeUpdate();
		
		int retval =0;
		ResultSet rs = pstmt.executeQuery("select last_insert_id()");
		if (rs.next()) {
			retval = rs.getInt(1);
			u.setUserID(retval);
		}

		return cnt;
		
		/*String sql="INSERT INTO USERS VALUES(null," 
						+"'" + u.getUsername() + "' ,"
						+"'" + u.getNickname() + "' ,"
						+"'" + u.getPassword() +"')";
		Statement stmt = con_.createStatement();
		int cnt = stmt.executeUpdate(sql);
		
		int retval =0;
		ResultSet rs = stmt.executeQuery("select last_insert_id()");
		if (rs.next()) {
			retval = rs.getInt(1);
			u.setUserID(retval);
		}
		return cnt;*/
	}
	public boolean checkPassword(User u) throws SQLException{
		String sql="SELECT PASSWORD, USERID,NICKNAME FROM USERS WHERE USERNAME='"+u.getUsername()+"'";
		Statement stmt = con_.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		if(rset.next()){
			String getPassword = rset.getString(1);
			if(getPassword.equals(u.getPassword())){
				u.setUserID(rset.getInt(2));
				u.setNickname(rset.getString(3));
				return true;
			}
		}
		return false;
	}
	public ArrayList<User> selectFriends(int userID) throws SQLException{

		ArrayList<User> list = new ArrayList<User>();
		String sql = "select Users.UserID, Users.Username, Users.Nickname, Users.Password " +
				"from friendships join users " +
				"on friendships.holdeeID=users.userid " +
				"where holderID="+userID;
		Statement stmt = con_.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			User tmpU = new User(rset.getInt(1), rset.getString(2), rset.getString(3),rset.getString(4));
			list.add(tmpU);
		}
		return list;
	}
	public ArrayList<User> selectNonFriends(int userID) throws SQLException{
		ArrayList<User> friendList = new ArrayList<User>();
		String sql = "select Users.UserID, Users.Username, Users.Nickname, Users.Password " +
				"from friendships join users " +
				"on friendships.holdeeID=users.userid " +
				"where holderID="+userID;
		Statement stmt = con_.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			User tmpU = new User(rset.getInt(1), rset.getString(2), rset.getString(3),rset.getString(4));
			friendList.add(tmpU);
		}
		System.out.println("3");
		ArrayList<User> allList= new ArrayList<User>();
		String sql2 = "SELECT * FROM users";
		Statement stmt2 = con_.createStatement();
		ResultSet rset2 = stmt.executeQuery(sql2);
		while(rset2.next()){
			User tmpU = new User(rset2.getInt(1), rset2.getString(2), rset2.getString(3),rset2.getString(4));
			allList.add(tmpU);
		}
		System.out.println("4");
		ArrayList<User> nonFriendList = new ArrayList<User>();
		for(int i = 0;i<allList.size();i++){
			boolean have = false;
			for(int j=0;j<friendList.size();j++){
				if(allList.get(i).getUserID()==friendList.get(j).getUserID()){
					have = true;
					break;
				}
			}
			if(!have) nonFriendList.add(allList.get(i));
		}
		for(int i = 0;i<nonFriendList.size();i++){
			if(nonFriendList.get(i).getUserID()==userID){
				nonFriendList.remove(i);
			}
		}
		return nonFriendList;
	}
	public void addFriend(int myID, int friendID) throws SQLException{
		String sql = "INSERT INTO FRIENDSHIPS VALUES(?,?)";
		PreparedStatement pstmt = con_.prepareStatement(sql);
		pstmt.setInt(1,myID);
		pstmt.setInt(2,friendID);
		int cnt = pstmt.executeUpdate();
		
		/*String sql="INSERT INTO FRIENDSHIPS VALUES(" 
			+ myID + "," +  friendID + ")";
		Statement stmt = con_.createStatement();
		int cnt = stmt.executeUpdate(sql);*/
		
		
		
	}
	public void excludeFriend(int myID, int friendID) throws SQLException{
		String sql="DELETE FROM FRIENDSHIPS WHERE HOLDERID=" 
			+ myID + " AND HOLDEEID=" +  friendID ;
		Statement stmt = con_.createStatement();
		int cnt = stmt.executeUpdate(sql);
		System.out.println("finish excludefriends");
	
	}
}

