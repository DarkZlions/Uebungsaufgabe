package util;

import java.util.regex.Pattern;

public class Helper {
	public static boolean stringContainDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
