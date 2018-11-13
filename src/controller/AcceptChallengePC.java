package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import datasource.ChallengeRDG;
import enums.ChallengeStatus;

/**
 * Servlet implementation class Login
 */
@WebServlet("/AcceptChallengePC")
public class AcceptChallengePC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptChallengePC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			JSONParser parser = new JSONParser();
			String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
			JSONObject jsonData = (JSONObject) parser.parse(body);
			
			long challenge_id = (long) jsonData.get("challenge_id");
			
			ChallengeRDG challengeRdg = new ChallengeRDG();
			challengeRdg.update(ChallengeStatus.ACCEPTED, challenge_id);
		}catch(Exception e) {
			e.printStackTrace();
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
