package migrations;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finder.MigrationsQueries;

/**
 * Servlet implementation class HelloWorldTS
 */
@WebServlet("/DatabaseReset")
public class DatabaseReset extends HttpServlet {
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
    public DatabaseReset() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void migrateTables(Connection con) {
    	MigrationsQueries mq = new MigrationsQueries();
		
		try {
			PreparedStatement ps = con.prepareStatement(mq.createUsersTable());
			ps.executeUpdate();
			ps = con.prepareStatement(mq.createDeckTable());
			ps.executeUpdate();
			ps = con.prepareStatement(mq.createGameTable());
			ps.executeUpdate();
			ps = con.prepareStatement(mq.createChallengesTable());
			ps.executeUpdate();
			ps = con.prepareStatement(mq.createCardsTable());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/Soen387?user=root&password=root");

			//Use this elsewhere to access the database connection
			//instead of passing it all the time
			myCon.set(con);
			
			migrateTables(con);
			
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
		doGet(request, response);
		
	}

}