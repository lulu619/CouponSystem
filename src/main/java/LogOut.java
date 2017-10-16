
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogOut() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		HttpSession session = request.getSession();
		if (session == null) {

			response.sendRedirect("http://localhost:8080/webcouponsystem/Login/login.html");
			System.out.println("You are successfully log out1 !");
		} else {
			session.removeAttribute("facade");
			session.invalidate();
			response.sendRedirect("http://localhost:8080/webcouponsystem/Login/login.html");
			System.out.println("You are successfully log out2 !");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
