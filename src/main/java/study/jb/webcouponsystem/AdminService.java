package study.jb.webcouponsystem;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Core.Beans.Company;
import Core.Beans.Customer;
import Core.exceptions.CouponSystemException;
import FacadeDAO.AdminFacade;

@Path("admin")
public class AdminService {

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;
	private static AdminFacade facade = null;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createcompany")
	public Response createCompany(WebCompany webCompany) throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {

			Company company = webCompany.convertToCompany();
			facade.createCompany(company);

			return Response.ok("You have successfully created your company " + company.getCompName()).status(200)
					.build();

		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
			return Response.ok("Unable to create company, Make sure fill all fields and that there is no company with the same ID  " + e.getMessage()).status(500).build();
		}

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("deletecompany/{deletecompany}")
	public Response deleteCompany(@PathParam("deletecompany") long id) throws CouponSystemException, SQLException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			Company company = facade.getCompany(id);
			facade.deleteCompany(company);

			return Response.ok("You have successfully deleted your company " + company.getCompName()).status(200).build();

		} catch (CouponSystemException e) {

			return Response.ok("Unable to delete company, And make sure you enter the ID of an existing company " + e.getMessage()).status(500).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updatecompany/{updatecompany}")
	public Response updateCompany(@PathParam("updatecompany") long id, WebCompany webCompany)
			throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {
			if (webCompany.getId() == id) {
				Company company = facade.getCompany(id);
				company.setCompName(webCompany.getCompName());
				company.setPassword(webCompany.getPassword());
				company.setEmail(webCompany.getEmail());
				facade.updateCompany(company);

				return Response.ok("You have successfully updated your company " + company.getCompName()).status(200)
						.build();
			}
		} catch (CouponSystemException e) {

			return Response.ok("Unable to update company, Make sure that you do not update the company's name or ID " + e.getMessage()).status(500).build();
		}
		return Response.ok("Unable to update company, Make sure that you do not update the company's name or ID ").status(500).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcompany/{getcompany}")
	public Response getComapny(@PathParam("getcompany") long id) throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		WebCompany webCompany = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			Company company = facade.getCompany(id);
			webCompany = new WebCompany(company);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get company, Make sure you enter ID of an existing company " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		return Response.ok(webCompany, MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallcompanies")
	public Response allCompanies() throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");
		Collection<WebCompany> webCompanies = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			Collection<Company> allCompanies = facade.getAllCompanies();
			webCompanies = WebCompany.convertToWebCompanies(allCompanies);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all companies. " + e.getMessage(), MediaType.TEXT_HTML).status(500)
					.build();
		}
		GenericEntity<Collection<WebCompany>> entity = new GenericEntity<Collection<WebCompany>>(webCompanies) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createcustomer")
	public Response createCustomer(WebCustomer webCustomer) throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login .").status(500).build();
		}
		try {

			Customer customer = webCustomer.convertToCustomer();
			facade.createCustomer(customer);
			return Response.ok("You have successfully created your customer " + customer.getCustName()).status(200)
					.build();

		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
			return Response.ok("Unable to create customer, Make sure you fill in all the fields and you don't enter the same ID to an existing customer " + e.getMessage()).status(500).build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("deletecustomer/{deletecustomer}")
	public Response deleteCustomer(@PathParam("deletecustomer") long id) throws CouponSystemException, SQLException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		} else {

			try {
				Customer customer = facade.getCustomer(id);
				facade.deleteCustomer(customer);
				return Response.ok("You have successfully deleted your customer, Make sure you insert ID of an existing customer  " + customer.getCustName()).status(200).build();

			} catch (CouponSystemException e) {
				System.out.println(e.getMessage());
				return Response.ok("Unable to delete customer. " + e.getMessage()).status(500).build();
			}
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updatecustomer/{updatecustomer}")
	public Response updateCustomer(@PathParam("updatecustomer") long id, WebCustomer webCustomer)
			throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {
			if (webCustomer.getId() == id) {
				Customer customer = facade.getCustomer(id);
				customer.setCustName(webCustomer.getCustName());
				customer.setPassword(webCustomer.getPassword());
				facade.updateCustomer(customer);

				return Response.ok("You have successfully updated your customer " + customer.getCustName()).status(200)
						.build();

			}
		} catch (CouponSystemException e) {

			return Response.ok("Unable to update customer, Make sure that you do not update the customer's name or ID " + e.getMessage()).status(500).build();
		}
		return Response.ok("Unable to update customer, Make sure that you do not update the customer's name or ID ").status(500).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcustomer/{getcustomer}")
	public Response getCustomer(@PathParam("getcustomer") long id) throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");
		WebCustomer webCustomer = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			Customer customer = facade.getCustomer(id);
			webCustomer = new WebCustomer(customer);
		} catch (CouponSystemException e) {

			return Response.ok("Unable to get customer, Make sure you enter ID of an existing customer  " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		return Response.ok(webCustomer, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallcustomers")
	public Response getAllCustomers() throws CouponSystemException {

		facade = (AdminFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}

		Collection<Customer> allCustomers = null;
		Collection<WebCustomer> webCustomers = null;

		try {

			allCustomers = facade.getAllCustomers();
			webCustomers = WebCustomer.convertToWebCustomers(allCustomers);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all customers. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}

		GenericEntity<Collection<WebCustomer>> entity = new GenericEntity<Collection<WebCustomer>>(webCustomers) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();
	}

}