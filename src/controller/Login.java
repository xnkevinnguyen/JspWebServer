package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import datasource.UserRDG;
import model.UserModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		UserRDG userRdg = new UserRDG();
		JSONObject json = new JSONObject();
		
		if(email==null || email.isEmpty() || pass==null || pass.isEmpty() ) {
			request.setAttribute("message", "Please enter both a username and a password to login.");
			request.getRequestDispatcher("WEB-INF/jsp/fail.jsp").forward(request, response);
		} else {
			UserModel user = userRdg.findByEmailAndPassword(email, pass);
			if(user != null) {
				request.setAttribute("message", "Successfully logged in.");
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Please check your email or password.");
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
