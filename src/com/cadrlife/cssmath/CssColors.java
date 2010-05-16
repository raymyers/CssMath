package com.cadrlife.cssmath;

import com.google.common.collect.ImmutableBiMap;

public class CssColors {
	private static ImmutableBiMap<String, String> colorToHex = ImmutableBiMap.<String,String>builder()
		.put("aqua", "#00ffff") // cyan
		.put("black", "#000000")
		.put("blue", "#0000ff")
		.put("fuchsia", "#ff00ff")
		.put("gray", "#808080")
		.put("green", "#008000")
		.put("lime", "#00ff00")
		.put("maroon", "#800000")
		.put("navy", "#000080")
		.put("olive", "#808000")
		.put("purple", "#800080")
		.put("red", "#ff0000")
		.put("silver", "#c0c0c0")
		.put("teal", "#008080")
		.put("white", "#ffffff")
		.put("yellow","#ffff00")
		.build();
	private static ImmutableBiMap<String, String> hexToColor = colorToHex.inverse();
	public static boolean isColor(String color) {
		System.err.println(color + " isColor? " + (isHexColor(color) || isNamedColor(color)));
		return isHexColor(color) || isNamedColor(color);
	}
	public static boolean isNamedColor(String color) {
		return colorToHex.containsKey(color.toLowerCase());
	}
	public static boolean isHexColor(String color) {
		return isShortHexColor(color) || isLongHexColor(color);
	}
	public static boolean isLongHexColor(String color) {
		return color.matches("#[0-9|a-f|A-F]+") && color.length() == 7;
	}
	public static boolean isShortHexColor(String color) {
		return color.matches("#[0-9|a-f|A-F]+") && color.length() == 4 ;
	}
	public static String normalize(String color) {
		color = color.toLowerCase();
		if (isShortHexColor(color)) {
			color = shortHexColorToLong(color);
		}
		if (hexToColor.containsKey(color)) {
			color = hexToColor.get(color);
		}
		return color;
	}
	public static String toLongHexColor(String color) {
		if (isShortHexColor(color)) {
			return shortHexColorToLong(color);
		}
		if (colorToHex.containsKey(color)) {
			return colorToHex.get(color);
		}
		return color;
	}
	
	public static Long toLong(String color) {
		return Long.parseLong(toLongHexColor(color).replaceFirst("^#", ""), 16);
	}
	
	public static String fromLong(long d) {
		return normalize(String.format("#%6x", d));
	}
	public static void main(String[] args) {
		System.err.println(fromLong(4));
	}
	public static String shortHexColorToLong(String color) {
		return String.format("#%s%s%s%s%s%", color.charAt(1), color.charAt(1), color.charAt(2), color.charAt(2), color.charAt(3), color.charAt(3));
	}
	private CssColors() {}

}
