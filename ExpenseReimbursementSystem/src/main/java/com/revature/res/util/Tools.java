package com.revature.res.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	public static String getPrintedCurrentDate() {
		
		Date currentDate = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMM-dd z HH:mm:ss");
		
		return format1.format(currentDate).toString();
	}
}
