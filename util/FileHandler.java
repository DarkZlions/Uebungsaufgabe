package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import lib.Customer;

public class FileHandler {
	public static final String WINDOW_PROPERTIES_FILE_PATH = "window_properties.wp";
	public static final String COUNTRY_FILE_PATH = "countries.txt";
	public static final String CUSTOMER_FILE_NAME = "\\customer.data";
	public static final String CUSTOMER_FILE_PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + CUSTOMER_FILE_NAME;

	public static void writeToWindowProperties(String input) throws IOException {
		ClassLoader loader = FileHandler.class.getClassLoader();
		File property_file = new File(WINDOW_PROPERTIES_FILE_PATH);
		FileWriter writer = new FileWriter(property_file.getAbsoluteFile());
		PrintWriter printer = new PrintWriter(writer);

		printer.printf("%s", input.getBytes());
		printer.close();
	}

	public static Object[] readFileCountryFile() throws IOException {
		InputStream stream = FileHandler.class.getClassLoader().getResourceAsStream(COUNTRY_FILE_PATH);
		InputStreamReader ir = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(ir);
		String line;
		List<String> output = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			output.add(line);
		}
		

		return output.toArray();
	}
	
	public static List<Customer> readCustomerData() throws IOException {
		File file = new File(CUSTOMER_FILE_PATH);
		if (!file.exists()) return new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		List<String> content = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			content.add(line);
		}
		
		for (int i = 0; i < content.size() / 6; i++ ) {
			Customer c = new Customer(content.get(i * 6 + 0), content.get(i * 6 + 1), content.get(i * 6 + 2),
					content.get(i * 6 + 3), content.get(i * 6 + 4), content.get(i * 6 + 5));
			customerList.add(c);
		}
		
		return customerList;
	}
	
	public static void writeToCustomerData(Customer customerIn) throws IOException {
		File file = new File(CUSTOMER_FILE_PATH);
		if (!file.exists()) file.createNewFile();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		List<String> content = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			content.add(line);
		}
		FileWriter writer = new FileWriter(file, false);
		PrintWriter printer = new PrintWriter(writer);
		
		for (String str : content) {
			printer.printf("%s" + "%n", str);			
		}

		
		printer.printf("%s" + "%n", customerIn.getName());
		printer.printf("%s" + "%n", customerIn.getAddress());
		printer.printf("%s" + "%n", customerIn.getZipCity());
		printer.printf("%s" + "%n", customerIn.getCountry());
		printer.printf("%s" + "%n", customerIn.getPhone());
		printer.printf("%s" + "%n", customerIn.getEmail());
		printer.close();
	}
}
