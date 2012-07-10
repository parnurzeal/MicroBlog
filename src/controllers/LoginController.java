package controllers;

import java.io.IOException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import datasource.ConnectionManager;

import beans.User;

public class LoginController {
	private LoginController(){}
	public static String login(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nextPage = "/WEB-INF/jsp/Error.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("GODI");
		if(username!=null && password!=null ){
			
			System.out.println("Checked the password");
			Connection con = null;
			try{
				User tmpU = new User(-1,username,"",password);
				con = ConnectionManager.getConnection();
				UserDAO uDAO = new UserDAO(con);
				if(uDAO.checkPassword(tmpU)){
					HttpSession session = request.getSession(true);
					session.setAttribute("user", tmpU);
					System.out.println("Login: "+ tmpU.getUserID() + ": "+tmpU.getUsername());
					
					nextPage = RelationController.getRelations(request, response);;
				}else{
					nextPage = "/index.jsp";
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(Exception e){}
			}
		}
		return nextPage;
	}
	
}
