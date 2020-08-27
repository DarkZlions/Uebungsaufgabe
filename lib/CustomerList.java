package lib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.FileHandler;

public class CustomerList {
	private static List<Customer> customerList;
	
	public static void loadList() {
		customerList = new ArrayList<>();
		try {
			customerList = FileHandler.readCustomerData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Customer c : customerList) {
			System.out.println(c.getName());
		}
	}
	
	public static void addCustomer(Customer customer) {
		if (customerList.contains(customer)) return;
		try {
			FileHandler.writeToCustomerData(customer);
			customerList.add(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
