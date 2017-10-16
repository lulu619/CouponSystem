package study.jb.webcouponsystem;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import Core.Beans.Coupon;
import Core.Beans.CouponType;

@XmlRootElement
public class WebCoupon implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes
	private long id;
	private String title;
	private String startDate;
	private String endDate;
	private int amount;
	private String type;
	private String message;
	private double price;
	private String image;

	public WebCoupon() {

	}

	public WebCoupon(Coupon coupon) {
		super();
		this.id = coupon.getId();
		this.title = coupon.getTitle();
		this.startDate = coupon.getStartDate().toString();
		this.endDate = coupon.getEndDate().toString();
		this.amount = coupon.getAmount();
		this.type = coupon.getType().toString();
		this.message = coupon.getMessage();
		this.price = coupon.getPrice();
		this.image = coupon.getImage();
	}

	public Coupon convertToCoupon() throws ParseException {
		Coupon result = new Coupon(this.id, this.title, this.convertStrToDate(startDate),
				this.convertStrToDate(endDate), this.amount, CouponType.valueOf(this.type), this.message, this.price,
				this.image);

		return result;
	}

	public static Collection<Coupon> convertToCoupons(Collection<WebCoupon> list) throws ParseException {
		Collection<Coupon> result = new ArrayList<>();
		for (WebCoupon c : list) {
			result.add(c.convertToCoupon());
		}
		return result;
	}

	public static Collection<WebCoupon> convertToWebCoupons(Collection<Coupon> list) {
		Collection<WebCoupon> result = new ArrayList<>();
		for (Coupon c : list) {
			result.add(new WebCoupon(c));
		}
		return result;
	}

	public Date convertStrToDate(String strToDate) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date1 = sdf.parse(strToDate);
		java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

		return sqlDate;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// toString
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", type=" + type + ", message=" + message + ", price=" + price + ", image="
				+ image + "]";
	}

}
