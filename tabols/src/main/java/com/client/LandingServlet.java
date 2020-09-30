package com.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LandingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isUser(req)) {
			resp.sendRedirect("home");
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.include(req, resp);
		}
	}

	private boolean isUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		boolean isLoggedIn = session.getAttribute("user")!=null? (boolean) session.getAttribute("user"): false;
		return isLoggedIn;
	}
}
