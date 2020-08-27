package gui;

import java.util.HashMap;
import java.util.Map;

import gui.layouts.BaseLayout;
import gui.layouts.EditCustomerWindowLayout;
import gui.layouts.HomeWindowLayout;

public class WindowHandler {
	public static Map<Window, BaseLayout> WINDOWS = new HashMap<>();
	
	public static Window HOME_WINDOW = register(new Window(900, 800, "Just Muesli", false), new HomeWindowLayout());
	public static Window EDIT_CUSTOMER_DETAILS_WINDOW = register(new Window(700, 600, "Customer Details", false), new EditCustomerWindowLayout());
	
	private static Window register(Window window, BaseLayout layout) {
		window.init(layout);
		WINDOWS.put(window, layout);
		
		return window;
	}
}
