package aiss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BottonRegister extends HttpServlet {
    private static final long serialVersionUID = -6818025976353856770L;


public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String accessToken = (String) req.getSession().getAttribute("Spotify-token");
    if (accessToken != null && !"".equals(accessToken)) {
        req.getRequestDispatcher("/index.html").forward(req, resp);
    	} 
    else {
        req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp);
    }
}

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            doGet(req, resp);
        }

}