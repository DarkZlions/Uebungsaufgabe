package gui.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Window;
import gui.WindowHandler;
import lib.Customer;
import lib.CustomerList;
import util.FileHandler;
import util.Helper;

public class EditCustomerWindowLayout extends BaseLayout {
	private String title, subTitle;
	private JLabel titleLabel, subTitleLabel;
	private JButton saveButton, backButton;
	private JLabel nameLabel, addressLabel, zipCityLabel, countryLabel, phoneLabel, emailLabel;
	private JComboBox countryMenu;
	private JPanel inputPanel, titlePanel, buttonPanel;
	private JTextField nameField, addressField, zipCityField, phoneField, emailField;

	@Override
	public void init(Window window) {
		Container contentPanel = window.getContentPane();
		/*
		 * Initialize title
		 */
		title = "Just Muesli";
		subTitle = "Customer Details";
		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font(Font.SANS_SERIF, 1, 40));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subTitleLabel = new JLabel(subTitle);
		subTitleLabel.setFont(new Font(Font.SANS_SERIF, 1, 20));
		subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
		titlePanel.add(titleLabel);
		titlePanel.add(subTitleLabel);
		contentPanel.add(titlePanel, BorderLayout.PAGE_START);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPanel.add(Box.createHorizontalGlue());
		saveButton = new JButton("Save");
		backButton = new JButton("Back to MainMenu");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				EditCustomerWindowLayout layout = (EditCustomerWindowLayout) WindowHandler.WINDOWS
						.get(WindowHandler.EDIT_CUSTOMER_DETAILS_WINDOW);
				layout.reset();
				WindowHandler.HOME_WINDOW.setVisible(true);
			}
		});
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditCustomerWindowLayout layout = (EditCustomerWindowLayout) WindowHandler.WINDOWS
						.get(WindowHandler.EDIT_CUSTOMER_DETAILS_WINDOW);
				layout.save();
			}
		});
		buttonPanel.add(saveButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPanel.add(backButton);
		contentPanel.add(buttonPanel, BorderLayout.PAGE_END);

		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(6, 2));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(60, 100, 120, 20));
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField();
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		addressLabel = new JLabel("Address: ");
		addressField = new JTextField();
		inputPanel.add(addressLabel);
		inputPanel.add(addressField);
		zipCityLabel = new JLabel("Zip / City: ");
		zipCityField = new JTextField();
		inputPanel.add(zipCityLabel);
		inputPanel.add(zipCityField);
		countryLabel = new JLabel("Country: ");
		inputPanel.add(countryLabel);
		try {
			countryMenu = new JComboBox(FileHandler.readFileCountryFile());
			inputPanel.add(countryMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		phoneLabel = new JLabel("Phone: ");
		phoneField = new JTextField();
		inputPanel.add(phoneLabel);
		inputPanel.add(phoneField);
		emailLabel = new JLabel("Email: ");
		emailField = new JTextField();
		inputPanel.add(emailLabel);
		inputPanel.add(emailField);
		contentPanel.add(inputPanel, BorderLayout.WEST);

	}

	private void save() {
		String name = nameField.getText();
		if (name.length() < 5 || name == null) {
			nameField.setForeground(Color.red);
			nameField.setText("Invalid Name, use at least 5 characters.");
			return;
		}

		String address = addressField.getText();
		if (address.length() < 5) {
			zipCityField.setForeground(Color.red);
			addressField.setText("Invalid Address, use at least 5 characters.");
			return;
		}

		String zipCity = zipCityField.getText();
		if (!(Helper.stringContainDigit(zipCity.substring(0, 3)))) {
			zipCityField.setForeground(Color.red);
			zipCityField.setText("Invalid Zip, the first four digit must be a zip code.");
			return;
		} else if (zipCity.length() < 5) {
			zipCityField.setForeground(Color.red);
			zipCityField.setText("Invalid City, the address must contain a least 5 characters.");
			return;
		}

		String country = null;
		try {
			country = (String) FileHandler.readFileCountryFile()[countryMenu.getSelectedIndex()];

		} catch (IOException e) {
			e.printStackTrace();
		}

		String phone = phoneField.getText();
		if (phone.charAt(0) != '+' && phone.length() < 10) {
			phoneField.setForeground(Color.red);
			phoneField.setText("Invalid phone number, must contains at least 10 character or a '+'.");
			return;
		}

		String email = emailField.getText();

		if (!Helper.isValid(email)) {
			emailField.setForeground(Color.red);
			emailField.setText("Invalid email address");
			return;
		}

		Customer newCustomer = new Customer(name, address, zipCity, country, phone, email);
		CustomerList.addCustomer(newCustomer);
	}

	public void reset() {
		resetField(nameField);
		resetField(addressField);
		resetField(zipCityField);
		resetField(phoneField);
		resetField(emailField);
		countryMenu.setSelectedIndex(0);
	}

	private void resetField(JTextField field) {
		field.setText(null);
		field.setForeground(Color.black);
	}
}
