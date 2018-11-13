package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datasource.UserRDG;
import model.UserModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		UserModel user = null;
		
		UserRDG userRdg = new UserRDG();
		
		if(name==null || email==null || email.isEmpty() || pass==null || pass.isEmpty() ) {
			request.setAttribute("message", "Please enter both a username and a password to login.");
			request.getRequestDispatcher("WEB-INF/jsp/fail.jsp").forward(request, response);
		} else {
			if(!userRdg.isEmailTaken(email)) {
				user = userRdg.insert(name, email, pass);
				if(user != null) {
					request.setAttribute("message", "Successfully created user.");
					request.getSession(true).setAttribute("login", email);
					request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Please check your email or password.");
					request.getRequestDispatcher("WEB-INF/jsp/fail.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", "The email is already taken! Please try with a different one.");
				request.getRequestDispatcher("WEB-INF/jsp/fail.jsp").forward(request, response);
			}
			
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
