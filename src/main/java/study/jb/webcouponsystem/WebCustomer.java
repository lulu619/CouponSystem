package study.jb.webcouponsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import Core.Beans.Customer;

@XmlRootElement
public class WebCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String custName;
	private String password;

	public WebCustomer() {

	}

	public WebCustomer(Customer customer) {
		super();
		this.id = customer.getId();
		this.custName = customer.getCustName();
		this.password = customer.getPassword();
	}

	public Customer convertToCustomer() {
		Customer result = new Customer(this.id, this.custName, this.password);

		return result;
	}

	public static Collection<Customer> convertToCustomers(Collection<WebCustomer> list) {
		Collection<Customer> result = new ArrayList<>();
		for (WebCustomer c : list) {
			result.add(c.convertToCustomer());
		}
		return result;
	}

	public static Collection<WebCustomer> convertToWebCustomers(Collection<Customer> list) {
		Collection<WebCustomer> result = new ArrayList<>();
		for (Customer c : list) {
			result.add(new WebCustomer(c));
		}
		return result;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WebCustomer [id=" + id + ", custName=" + custName + ", password=" + password + "]";
	}

}