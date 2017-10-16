package study.jb.webcouponsystem;

import java.sql.SQLException;
import java.text.ParseException;
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

import Core.Beans.Coupon;
import Core.Beans.CouponType;
import Core.exceptions.CouponSystemException;
import FacadeDAO.CompanyFacade;

@Path("company")
public class CompanyService {

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;
	private CompanyFacade facade = null;

	public CompanyService() {

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createcoupon")
	public Response createCoupon(WebCoupon webCoupon) throws CouponSystemException, SQLException, ParseException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			Coupon coupon = webCoupon.convertToCoupon();
			facade.createCoupon(coupon);
			
			return Response.ok("You have successfully created your coupon " + coupon.getTitle()).status(200).build();

		} catch (CouponSystemException e) {
			
			return Response.ok("Unable to create coupon, Make sure fill all fields and that there is no coupon with the same ID.  " + e.getMessage()).status(500).build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("deletecoupon/{deletecoupon}")
	public Response deleteCoupon(@PathParam("deletecoupon") long id) throws CouponSystemException, SQLException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			Coupon coupon = facade.getCoupon(id);
			facade.deleteCoupon(coupon);
			
			return Response.ok("You have successfully deleted your coupon " + coupon.getTitle()).status(200).build();

		} catch (CouponSystemException e) {
			
			return Response.ok("Unable to delete coupon, Make sure you enter ID of an existing coupon. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updatecoupon/{updatecoupon}")
	public Response updateCoupon(@PathParam("updatecoupon") long id, WebCoupon webCoupon)
			throws CouponSystemException, SQLException, ParseException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");
		
		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			
			if (webCoupon.getId() == id) {
				Coupon coupon = facade.getCoupon(id);

				coupon.setTitle(webCoupon.getTitle());
				coupon.setStartDate(webCoupon.convertStrToDate(webCoupon.getStartDate()));
				coupon.setEndDate(webCoupon.convertStrToDate(webCoupon.getEndDate()));
				coupon.setAmount(webCoupon.getAmount());
				coupon.setType(CouponType.valueOf(webCoupon.getType()));
				coupon.setMessage(webCoupon.getMessage());
				coupon.setPrice(webCoupon.getPrice());
				coupon.setImage(webCoupon.getImage());
				facade.updateCoupon(coupon);
				
				return Response.ok("You have successfully updated your coupon " + coupon.getTitle()).status(200).build();
			}
		} catch (CouponSystemException e) {

			return Response.ok("Unable to update coupon, Make sure that you do not update the coupon's title or ID. " + e.getMessage()).status(500).build();
		}
		return Response.ok("Unable to update coupon, Make sure that you do not update the coupon's title or ID. ").status(500).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcoupon/{getcoupon}")
	public Response getCoupon(@PathParam("getcoupon") long id) throws CouponSystemException, SQLException {

        facade = (CompanyFacade) request.getSession().getAttribute("facade");
		WebCoupon webCoupon = null;
        
		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			Coupon coupon = facade.getCoupon(id);
			webCoupon = new WebCoupon(coupon);
			
		} catch (CouponSystemException e) {

			return Response.ok("Unable to get coupon, Make sure you enter ID of an existing coupon. " + e.getMessage(), MediaType.TEXT_HTML).build();
		}
		return Response.ok(webCoupon, MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallcoupons")
	public Response getAllCoupons() throws CouponSystemException, SQLException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");
		Collection<WebCoupon> webCoupons = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {
			
			Collection<Coupon> coupons = facade.getAllCoupon();
			webCoupons = WebCoupon.convertToWebCoupons(coupons);
		
		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all coupons. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(webCoupons) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allcoupbytype/{allcoupbytype}")
	public Response getCouponsByType(@PathParam("allcoupbytype") String type)
			throws CouponSystemException, SQLException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");
		Collection<WebCoupon> webCouponsByType = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {

			CouponType toCoupType = CouponType.valueOf(type);
			Collection<Coupon> couponsByType = facade.getCouponByType(toCoupType);
		    webCouponsByType = WebCoupon.convertToWebCoupons(couponsByType);

		} catch (CouponSystemException e) {

			return Response.ok("Unable to get all coupons. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(webCouponsByType) {};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getallcoupbyprice/{getallcouponbyprice}")
	public Response getCouponsByPrice(@PathParam("getallcouponbyprice") double coupPrice)
			throws CouponSystemException, SQLException {

		facade = (CompanyFacade) request.getSession().getAttribute("facade");
		Collection<WebCoupon> webCouponsByPrice = null;

		if (facade == null) {

			return Response.ok("Cannot accept requests. Please login again.").status(500).build();

		}
		try {

			Collection<Coupon> coupsByPrice = facade.getCouponByPrice(coupPrice);
			webCouponsByPrice = WebCoupon.convertToWebCoupons(coupsByPrice);

		} catch (

		CouponSystemException e) {

			return Response.ok("Unable to get all coupons. " + e.getMessage(), MediaType.TEXT_HTML).status(500).build();
		}
		GenericEntity<Collection<WebCoupon>> entity = new GenericEntity<Collection<WebCoupon>>(webCouponsByPrice) {
		};
		return Response.ok(entity, MediaType.APPLICATION_JSON).status(200).build();

	}

}