package com.snatik.matches.themes;

import java.util.ArrayList;

public class Themes {

	public static String URI_DRAWABLE = "drawable://";

	public static Theme createAnimalsTheme() {
		Theme theme = new Theme();
		theme.id = 1;
		theme.name = "Animals";
		theme.tileImageUrls = new ArrayList<>();
		// 6 drawables
		for (int i = 1; i <= 6; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("animals_%d", i));
		}
		return theme;
	}

	public static Theme createMarioKartTheme() {
		Theme theme = new Theme();
		theme.id = 2;
		theme.name = "MarioKart";
		theme.tileImageUrls = new ArrayList<>();
		// 8 drawables
		for (int i = 1; i <= 8; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("mariokart_%d", i));
		}
		return theme;
	}
}
