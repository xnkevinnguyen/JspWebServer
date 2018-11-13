package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import datasource.DeckRDG;
import datasource.UserRDG;
import model.DeckModel;
import model.UserModel;
import utils.RequestHelper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/PlayerDetailsPC")
public class PlayerDetailsPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerDetailsPC() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		JSONParser parser = new JSONParser();
		String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		JSONObject jsonData = (JSONObject) parser.parse(body);
		
		long currentUserID = (long) request.getSession().getAttribute("user_id");
		
		JSONObject jsonResult = new JSONObject();
		
		long deck_id = (long) jsonData.get("deck_id");
		
		DeckRDG deckRDG = new DeckRDG();
		
		DeckModel deckResult = deckRDG.findUserWithDeckId(deck_id);
		UserRDG userRDG = new UserRDG();
		UserModel user = userRDG.findById(deckResult.getUser_id());
		
		
		jsonResult.put("user_id", user.getUser_id());
		jsonResult.put("firstname", user.getFirst_name());
		jsonResult.put("email", user.getEmail());
		
		if(currentUserID == user.getUser_id()) {
			jsonResult.put("currentlyLoggedIn", true);
		}else {
			jsonResult.put("currentlyLoggedIn", false);
		}
		
		RequestHelper.sendJsonObject(response, jsonResult);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
