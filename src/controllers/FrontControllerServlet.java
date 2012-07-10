package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.LoginController;

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getPathInfo();
		String nextPage = null;
		System.out.println(path);
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("user")==null){
			//request.setAttribute("error", "Session TIME OUT!");
			//nextPage = "/WEB-INF/jsp/Error.jsp";
			if("/Login".equals(path)){
				nextPage = LoginController.login(request, response);
				System.out.println(path);
				System.out.println(nextPage);
			}else if("/Register".equals(path)){
				nextPage = "/WEB-INF/jsp/Register.jsp";
			}else if("/RegisterConfirm".equals(path)){
				nextPage = UserController.registerConfirm(request, response);
			}else if("/RegisterCommit".equals(path)){
				nextPage = UserController.registerCommit(request,response);
			}else{
				nextPage = "/index.jsp";
				System.out.println(path);
			}
		}else{
			if("/Logout".equals(path)){
				session.invalidate();
				nextPage = "/index.jsp";
			}else if("/Main".equals(path)){
				System.out.println("In Main");
				nextPage = RelationController.getRelations(request, response);
				//nextPage = "/WEB-INF/jsp/Menu.jsp";
			}else if("/Relate".equals(path)){
				nextPage = RelationController.relate(request, response);
			}else if("/ListFriends".equals(path)){
				nextPage = UserController.listFriends(request, response);
			}else if("/NewFriends".equals(path)){
				nextPage = UserController.newFriend(request, response);
				//nextPage = "/WEB-INF/jsp/ActorAddForm.jsp";
			}else if("/CommitNewFriend".equals(path)){
				nextPage = UserController.addNewFriend(request, response);
				//nextPage = ActorAddController.perform(request, response);
			}else if("/ExcludeFriend".equals(path)){
				nextPage = UserController.excludeFriend(request, response);
				
			}else{
				session.invalidate();
				request.setAttribute("error", "Incorrect URL!");
				nextPage = "/WEB-INF/jsp/Error.jsp";
			}
		}
		System.out.println("NEXT PAGE: "+nextPage);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
