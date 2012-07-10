package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDAO;
import datasource.ConnectionManager;

public class UserController {
	public static String registerConfirm(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		if(username!=null && password!=null && nickname!=null && 
				!username.equals("") && !password.equals("") && !nickname.equals("")){
			System.out.println(username+password+nickname);
			nextPage = "/WEB-INF/jsp/RegisterConfirm.jsp";
		}
		return nextPage;
	}
	public static String registerCommit(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		if(username!=null && password!=null && nickname!=null && 
				!username.equals("") && !password.equals("") && !nickname.equals("")){
			Connection con = null;
			System.out.println(username+password+nickname);
			try{
				User tmpU = new User(-1,username,nickname,password);
				con = ConnectionManager.getConnection();
				UserDAO uDAO = new UserDAO(con);
				if(uDAO.registerUser(tmpU)!=0){
					nextPage = "/WEB-INF/jsp/Menu.jsp";
					HttpSession session = request.getSession(true);
					session.setAttribute("user", tmpU);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){}
			}
		}
		System.out.println("test");
		return nextPage;
	}
	public static String listFriends(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			UserDAO uDAO = new UserDAO(con);
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");

			ArrayList<User> list = uDAO.selectFriends(tmpU.getUserID());
			session.setAttribute("list", list);
			nextPage = "/WEB-INF/jsp/friendList.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){}
		}
		return nextPage;
	}
	
	public static String newFriend(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			UserDAO uDAO = new UserDAO(con);
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");
			System.out.println("HERE");
			ArrayList<User> list = uDAO.selectNonFriends(tmpU.getUserID());
			System.out.println("YES HERE");
			session.setAttribute("nonFriendList", list);
			nextPage = "/WEB-INF/jsp/NewFriend.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){}
		}
		return nextPage;
	}
	
	public static String addNewFriend(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			UserDAO uDAO = new UserDAO(con);
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");
			String friendUserID = request.getParameter("UserID");
			uDAO.addFriend(tmpU.getUserID(),Integer.parseInt(friendUserID));
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
	
	
	
	public static String excludeFriend(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			UserDAO uDAO = new UserDAO(con);
			HttpSession session = request.getSession(true);
			User tmpU = (User)session.getAttribute("user");
			String friendUserID = request.getParameter("UserID");
			System.out.println("USERID: " + tmpU.getUserID() +" friendUserID: "+friendUserID);
			uDAO.excludeFriend(tmpU.getUserID(),Integer.parseInt(friendUserID));
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
