package com.snatik.matches.themes;

import java.util.ArrayList;
import android.graphics.Bitmap;
import com.snatik.matches.common.Shared;
import com.snatik.matches.utils.Utils;

public class Themes {

	public static String URI_DRAWABLE = "drawable://";

	public static Theme createAnimalsTheme() {
		Theme theme = new Theme();
		theme.id = 1;
		theme.name = "Animals";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_animals";
		theme.tileImageUrls = new ArrayList<String>();

		for (int i = 1; i <= 6; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("animals_%d", i));
		}
		return theme;
	}

	public static Bitmap getBackgroundImage(Theme theme) {
		String drawableResourceName = theme.backgroundImageUrl.substring(Themes.URI_DRAWABLE.length());
		int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
		Bitmap bitmap = Utils.scaleDown(drawableResourceId, Utils.screenWidth(), Utils.screenHeight());
		return bitmap;
	}
}
