package com.revature.res.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ToolsTest {

	@Test
	final void testGetPrintedCurrentDate() {
		String date = Tools.getPrintedCurrentDate();
		assertNotNull(date);
	}

}
