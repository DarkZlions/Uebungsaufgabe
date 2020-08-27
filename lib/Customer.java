package lib;

public class Customer {
	private final String name;
	private final String address;
	private final String zipCity;
	private final String Country;
	private final String phone;
	private final String email;
	
	public Customer(String name, String address, String zipCity, String country, String phone, String email) {
		this.name = name;
		this.address = address;
		this.zipCity = zipCity;
		Country = country;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCity() {
		return zipCity;
	}

	public String getCountry() {
		return Country;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
}
