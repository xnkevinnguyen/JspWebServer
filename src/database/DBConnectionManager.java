package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldTS
 */
@WebServlet("/DBConnectionManager")
public class DBConnectionManager extends HttpServlet {
	//We pass around the database connection in a threadlocal so 
	//we have an easier time accessing it elsewhere
	public static ThreadLocal<Connection> myCon;
	
	private static final long serialVersionUID = 1L;
       
    @Override
    public void init(javax.servlet.ServletConfig config) throws ServletException {
    	 myCon = new ThreadLocal<Connection>();
    };
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConnectionManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//Run this on your database
		//You need to log into hex-server15-ev7421.concordia.ca using ssh
		//ssh -u USERNAME hex-server15-ev7421.concordia.ca
		//
		// Or something like that for putty.
		//
		
		//use the provided username and password
		//connect to your mysql database with the same username and password
		//mysql -u USERNAME -p USERNAME
		//give it the password here
		//
		//Use the following
		//CREATE TABLE t2person (first_name VARCHAR(20), last_name VARCHAR(20));
		//INSERT INTO t2person VALUES("Fred","Durst");
		
		// You need to set up a tunnel to this server as encs blocks 3306
		// ssh -fNg -L 3306:localhost:3306 USERNAME@hex-server15-ev7421.concordia.ca
		//
		// On putty in windows figure it out from that
		//
		
		//Starting connections
		Connection con = null;
		try {
			out.println("<html><body>");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			con = DriverManager.getConnection("jdbc:mysql://localhost/Soen387?user=root&password=root");

			//Use this elsewhere to access the database connection
			//instead of passing it all the time
			myCon.set(con);
			
			String query = "SELECT email FROM users";
			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, request.getParameter("name"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				out.println("Hello " + rs.getString("email"));
				
			} else {
				out.println("<h1>It's gone wrong!</h1>");
				out.println("We can't find any user with the name parameter you passed... if you passed one.");
			}
			
			out.println("</body></html>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			myCon.remove();
			try {con.close();} catch(Exception e){}
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}