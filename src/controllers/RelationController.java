package controllers;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Relation;
import beans.User;
import dao.RelationDAO;
import dao.UserDAO;
import datasource.ConnectionManager;

public class RelationController {
	public static String getRelations(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			RelationDAO rDAO = new RelationDAO(con);
			UserDAO uDAO = new UserDAO(con);
			
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");
			System.out.println("GET Relation "+ tmpU.getUserID() + ": "+tmpU.getUsername());
			
			ArrayList<User> friendList = uDAO.selectFriends(tmpU.getUserID());
			ArrayList<Relation> relationList = new ArrayList<Relation>();
			/* friend message */
			for(int i = 0;i<friendList.size();i++){
				System.out.println("checking " + friendList.get(i).getNickname());
				ArrayList<Relation> tmpList = rDAO.selectAll(friendList.get(i).getUserID());
				if(tmpList!=null)
					relationList.addAll(tmpList);
			}
			/* own message */
			ArrayList<Relation> ownList = rDAO.selectAll(tmpU.getUserID());
			if(ownList!=null)
				relationList.addAll(ownList);
			
			session.setAttribute("relationList", relationList);
			nextPage = "/WEB-INF/jsp/Menu.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){}
		}
		return nextPage;
	}
	public static String relate(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			String msg = request.getParameter("message");
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");
			java.util.Date date= new java.util.Date();
			Timestamp curTime = new Timestamp(date.getTime());
			if (!msg.equals("")){
				msg = msg.replace("<", "&lt;");
				msg = msg.replace(">","&gt;");
				msg = msg.replace("'","&quot;");
				
				Relation new_rela = new Relation(0,tmpU.getUserID(),tmpU.getUsername(),
												tmpU.getPassword(),msg,curTime);
				RelationDAO rDAO = new RelationDAO(con);
				rDAO.insertRelation(new_rela);
			}
			nextPage = "/WEB-INF/jsp/Menu.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){}
		}
		return nextPage;
	}
}
