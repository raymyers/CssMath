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
	
	@Test
	public void scalarByUnit_multiply() {
		assertEquals("6cm", CssMath.multiply("2", "3cm"));
		assertEquals("6cm", CssMath.multiply("2cm", "3"));
	}
	
	@Test
	public void scalarByUnit_add() {
		assertEquals("5em", CssMath.add("2", "3em"));
		assertEquals("5em", CssMath.add("2em", "3"));
	}
	
	@Test
	public void matchingUnit_add() {
		assertEquals("7cm", CssMath.add("4cm", "3cm"));
		assertEquals("6.3px", CssMath.add("6px", ".3px"));
	}
	
	@Test
	public void floor() {
		assertEquals("6", CssMath.floor("6"));
		assertEquals("6", CssMath.floor("6.25"));
		assertEquals("6", CssMath.floor("6.0"));
		assertEquals("6px", CssMath.floor("6.0px"));
		assertEquals("6px", CssMath.floor("6.25px"));
	}
}
