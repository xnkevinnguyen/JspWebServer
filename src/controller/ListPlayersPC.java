package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import datasource.UserRDG;
import model.UserModel;
import utils.RequestHelper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ListPlayersPC")
public class ListPlayersPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPlayersPC() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	private JSONArray addPlayer(JSONArray arrayToReturn,UserModel player) {
    	JSONObject userJson = new JSONObject();
    	userJson.put("user_id", player.getUser_id());
		userJson.put("username", player.getFirst_name());
		userJson.put("email", player.getEmail());
		
		arrayToReturn.add(userJson);
		return arrayToReturn;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserRDG userRdg = new UserRDG();
		
		JSONArray arrayResult = new JSONArray();
		ArrayList<UserModel> players = userRdg.findAll();
		
		players.forEach(player -> this.addPlayer(arrayResult,player));
		
		RequestHelper.sendJsonArray(response, arrayResult);
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
