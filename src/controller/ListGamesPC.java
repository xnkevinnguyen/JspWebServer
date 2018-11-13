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

import datasource.GameRDG;
import datasource.UserRDG;
import model.GameModel;
import model.UserModel;
import utils.RequestHelper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ListGamesPC")
public class ListGamesPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListGamesPC() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	private JSONArray addGame(JSONArray arrayToReturn,GameModel game) {
    	JSONObject userJson = new JSONObject();
    	userJson.put("game_id", game.getGame_id());
		userJson.put("challenger_deck_id", game.getChallenger_deck());
		userJson.put("challengee_deck_id", game.getChallengee_deck());
		
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
		GameRDG gameRdg = new GameRDG();
		
		JSONArray arrayResult = new JSONArray();
		ArrayList<GameModel> games = gameRdg.findAll();
		
		games.forEach(game -> this.addGame(arrayResult,game));
		
		RequestHelper.sendJsonArray(response, arrayResult);
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
