package com.revature.res.util;

public class Validation {
	public static boolean isValidPhone(String phone) {
		boolean b = false;
		if(phone.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
			b = true;
		}
		return b;
	}
}
