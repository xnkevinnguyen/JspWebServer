package controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import datasource.ChallengeRDG;
import utils.RequestHelper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ChallengePlayerPC")
public class ChallengePlayerPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChallengePlayerPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		JSONParser parser = new JSONParser();
		String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		JSONObject jsonData = (JSONObject) parser.parse(body);
		
		JSONObject jsonResult = new JSONObject();
		
	
		
		
		long challengerUser_id = (long) request.getSession().getAttribute("user_id");
		long challengeeUser_id = (long) jsonData.get("challengeeId");
		
		if(challengerUser_id == challengeeUser_id) {
			jsonResult.put("success", false);
			jsonResult.put("message", "You cannot challenge yourself!");
		}else {
			ChallengeRDG challengeRdg = new ChallengeRDG();
			
			boolean result = challengeRdg.insert(challengerUser_id, challengeeUser_id);
			if(result) {
				jsonResult.put("success", true);
				jsonResult.put("message", "Challenge has been created!");
			}else {
				jsonResult.put("success", false);
				jsonResult.put("message", "An error has occured :(");
			}
			
		}
		
		
		
		RequestHelper.sendJsonObject(response, jsonResult);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
