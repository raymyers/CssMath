package com.cadrlife.cssmath;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cadrlife.cssmath.CssMath;

public class CssMathTest {
	@Test
	public void scalarByScalar() {
		assertEquals("6", CssMath.multiply("2", "3"));
		assertEquals("5", CssMath.add("2", "3"));
		assertEquals("3", CssMath.divide("6", "2"));
	}
}
