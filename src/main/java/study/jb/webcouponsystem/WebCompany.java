package study.jb.webcouponsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import Core.Beans.Company;

@XmlRootElement
public class WebCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes
	private long id;
	private String compName;
	private String password;
	private String email;

	public WebCompany() {

	}

	public WebCompany(Company company) {
		super();
		this.id = company.getId();
		this.compName = company.getCompName();
		this.password = company.getPassword();
		this.email = company.getEmail();
	}

	public Company convertToCompany() {
		Company result = new Company(this.id, this.compName, this.password, this.email);

		return result;
	}

	public static Collection<Company> convertToCompanies(Collection<WebCompany> list) {
		Collection<Company> result = new ArrayList<>();
		for (WebCompany c : list) {
			result.add(c.convertToCompany());
		}
		return result;
	}

	public static Collection<WebCompany> convertToWebCompanies(Collection<Company> list) {
		Collection<WebCompany> result = new ArrayList<>();
		for (Company c : list) {
			result.add(new WebCompany(c));
		}
		return result;
	}

	// get the WebCompany ID
	public long getId() {
		return id;
	}

	// set the WebCompany ID
	public void setId(long id) {
		this.id = id;
	}

	// get the WebCompany Name
	public String getCompName() {
		return compName;
	}

	// set WebCompany name
	public void setCompName(String compName) {
		this.compName = compName;
	}

	// get the WebCompany password
	public String getPassword() {
		return password;
	}

	// set WebCompany password
	public void setPassword(String password) {
		this.password = password;
	}

	// get WebCompany email
	public String getEmail() {
		return email;
	}

	// set WebCompany email
	public void setEmail(String email) {
		this.email = email;
	}

	// toString
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email + "]";
	}

}