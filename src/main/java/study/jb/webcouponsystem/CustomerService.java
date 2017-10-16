package study.jb.webcouponsystem;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Core.Beans.Coupon;
import Core.Beans.CouponType;
import Core.exceptions.CouponSystemException;
import FacadeDAO.CustomerFacade;

@Path("customer")
public class CustomerService {

	@Context 
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	private static CustomerFacade facade = null;

	public CustomerService() {

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("purchasecoupon/{purchasecoupon}")
	public Response purchaseCoupon(@PathParam("purchasecoupon") long id) throws CouponSystemException, SQLException {

		facade = (CustomerFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			Coupon coupon = facade.purchaseCoupon(id);
			WebCoupon webCoupon = new WebCoupon(coupon);

			return Response.ok("You have successfully purchased your coupon " + webCoupon.getTitle()).status(200).build();

		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
			return Response.ok("Unable to purchase coupon, Make sure you fill in ID of existing coupon " +e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allpurchasedcoupons")
	public Response getAllPurchasedCoupons() throws CouponSystemException, SQLException {

		facade = (CustomerFacade) request.getSession().getAttribute("facade");
		Collection<Coupon> allPurchasedCoupons = null;
		Collection<WebCoupon> allWebPurchCoups = null;
		
		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {
			
			allPurchasedCoupons = facade.getAllPurchasedCoupons();
			allWebPurchCoups = WebCoupon.convertToWebCoupons(allPurchasedCoupons);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all purchased coupons. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}

		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(allWebPurchCoups) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();
	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allpurcoupbytype/{allpurcoupbytype}")
	public Response AllPurcCouponByType(@PathParam("allpurcoupbytype") String type)
			throws CouponSystemException, SQLException {

		facade = (CustomerFacade) request.getSession().getAttribute("facade");
		Collection<Coupon> allPurcCoupByType = null;
		Collection<WebCoupon> allWebPurcCoupByType = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			CouponType toCoupType = CouponType.valueOf(type);
			allPurcCoupByType = facade.getAllPurchasedCouponsByType(toCoupType);
			allWebPurcCoupByType = WebCoupon.convertToWebCoupons(allPurcCoupByType);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all purchased coupons by type. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}

		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(allWebPurcCoupByType) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();
	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allpurcoupbyprice/{allpurcoupbyprice}")
	public Response AllPurcCouponByPrice(@PathParam("allpurcoupbyprice") double price)
			throws CouponSystemException, SQLException {

		facade = (CustomerFacade) request.getSession().getAttribute("facade");
		Collection<Coupon> allPurcCoupByPrice = null;
		Collection<WebCoupon> allWebPurcCoupByPrice = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();
		}
		try {

			allPurcCoupByPrice = facade.getAllPurchasedCouponByPrice(price);
			allWebPurcCoupByPrice = WebCoupon.convertToWebCoupons(allPurcCoupByPrice);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all purchased coupons by price. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}

		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(allWebPurcCoupByPrice) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();
	
	}

}