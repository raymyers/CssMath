package com.cadrlife.cssmath;

public class CssMath {
	public static String multiply(String a, String b) {
		return operateScalar(Operator.MULTIPLY, a, b);
	}
	public static String add(String a, String b) {
		return operateScalar(Operator.ADD, a, b);
	}
	private static String displayScalar(Double d) {
		return Double.toString(d).replaceFirst("\\.0$", "");
	}
	public static String divide(String a, String b) {
		return operateScalar(Operator.DIVIDE, a, b);
	}
	public static String mod(String a, String b) {
		return operateScalar(Operator.MOD, a, b);
	}
	private static String operateScalar(Operator op, String a, String b) {
		return displayScalar(op.apply(Double.parseDouble(a), Double.parseDouble(b)));
	}
	private CssMath() {}
	
	
}
