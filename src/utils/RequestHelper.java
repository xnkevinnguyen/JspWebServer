package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RequestHelper {

	public static void sendJsonArray(HttpServletResponse response,JSONArray arrayResult) {
		try {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(arrayResult);
		out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendJsonObject(HttpServletResponse response,JSONObject obj) {
		try {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(obj);
		out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
