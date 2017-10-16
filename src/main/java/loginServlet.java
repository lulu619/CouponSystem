
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Core.Beans.ClientType;
import Core.exceptions.CouponSystemException;
import CouponSystem.CouponSystem;
import Facade.CouponClientFacade;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("usertype");

		try {
			CouponClientFacade facade = CouponSystem.getInstance().login(userName, password,
					ClientType.valueOf(userType));

			if (facade != null) {

				switch (userType) {

				case "ADMIN":
					HttpSession session = request.getSession();
					session.setAttribute("facade", facade);
					session.setMaxInactiveInterval(60);

					response.sendRedirect("http://localhost:8080/webcouponsystem/Admin/adminMain.html");

					break;

				case "COMPANY":

					HttpSession session1 = request.getSession();
					session1.setAttribute("facade", facade);
					session1.setMaxInactiveInterval(60);

					response.sendRedirect("http://localhost:8080/webcouponsystem/Company/companyMain.html");

					break;

				case "CUSTOMER":

					HttpSession session2 = request.getSession();
					session2.setAttribute("facade", facade);
					session2.setMaxInactiveInterval(60);

					response.sendRedirect("http://localhost:8080/webcouponsystem/Customer/customerMain.html");

					break;
				}

			} else {

				response.sendRedirect(
						"http://localhost:8080/webcouponsystem/Login/ErrorPage.html");
			}
		} catch (

		CouponSystemException e) {
			 e.getMessage();

		} catch (SQLException e) {
			e.getMessage();
		}

	}
}
