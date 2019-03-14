package dev;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DemoRedis extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		InetAddress addr = InetAddress.getLocalHost();
		req.setAttribute("ip", addr.getHostAddress());
		session = req.getSession();
		List<String> phrases = (List<String>) session.getAttribute("phrases");

		if (phrases != null) {
			req.setAttribute("phrases", phrases);
		} else {
			phrases = new ArrayList<>();
			session.setAttribute("phrases", phrases);
		}
		req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String phrase = req.getParameter("phrase");
		session = req.getSession();
		List<String> phrases = (List<String>) session.getAttribute("phrases");

		if (phrases != null) {
			phrases.add(phrase);
			session.setAttribute("phrases", phrases);
		} else {
			phrases = new ArrayList<>();
			phrases.add(phrase);
			session.setAttribute("phrases", phrases);
		}

		req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
	}
}
