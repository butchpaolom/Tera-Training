package com.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.User;

public class MainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isUser = new User(username, password).checkMember();
		HttpSession session = req.getSession();
		session.setAttribute("user", isUser);
		session.setAttribute("username", username);
		resp.sendRedirect("home");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isUser(req)) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			req.setAttribute("error", "Check username and password");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	private boolean isUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		boolean isLoggedIn = session.getAttribute("user")!=null? (boolean) session.getAttribute("user"): false;
		return isLoggedIn;
	}
}
