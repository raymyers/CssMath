package com.cadrlife.cssmath;

public class CssMath {
	public static String multiply(String a, String b) {
		return operate(Operator.MULTIPLY, a, b);
	}
	public static String add(String a, String b) {
		return operate(Operator.ADD, a, b);
	}
	public static String subtract(String a, String b) {
		return operate(Operator.SUBTRACT, a, b);
	}
	private static String displayScalar(Double d) {
		return Double.toString(d).replaceFirst("\\.0$", "");
	}
	public static String divide(String a, String b) {
		return operate(Operator.DIVIDE, a, b);
	}
	public static String mod(String a, String b) {
		return operate(Operator.MOD, a, b);
	}
	public static String floor(String a) {
		String scalar = asScalar(a);
		return displayScalar(Math.floor(Double.parseDouble(scalar))) + unitsOf(a);
	}
	private static String unitsOf(String a) {
		return a.replace(asScalar(a), "");
	}
	private static String asScalar(String a) {
		return a.replaceFirst("[A-Z|a-z]+$", "");
	}
	public static String operate(Operator op, String a, String b) {
		if (CssColors.isColor(a) && CssColors.isColor(b)) {
			return CssColors.fromLong(op.apply(CssColors.toLong(a), CssColors.toLong(b)));
		}
		String scalarA = asScalar(a);
		String scalarB = asScalar(b);
		String unitsA = unitsOf(a);
		String unitsB = unitsOf(b);
		try {
			String scalarResult = operateScalar(op, scalarA, scalarB);
			if (unitsA.equals(unitsB)) {
				return scalarResult + unitsA;
			}
			if ("".equals(unitsA)) {
				return scalarResult + unitsB;
			}
			if ("".equals(unitsB)) {
				return scalarResult + unitsA;
			}
			return scalarResult;
		} catch (NumberFormatException e) {
			// OperateScalar failed, these aren't numbers.
			// Fall back on concatentation add semantics;
			if (Operator.ADD == op) {
				return a + b;
			}
			throw e;
		}
		
	}
	private static String operateScalar(Operator op, String a, String b) {
		return displayScalar(op.apply(Double.parseDouble(a), Double.parseDouble(b)));
	}
	private CssMath() {}
	
	
}
