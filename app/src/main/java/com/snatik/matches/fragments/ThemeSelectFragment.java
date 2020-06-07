package com.snatik.matches.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.ThemeSelectedEvent;
import com.snatik.matches.themes.Theme;
import com.snatik.matches.themes.Themes;

public class ThemeSelectFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(Shared.context).inflate(R.layout.theme_select_fragment, container, false);
		View animals = view.findViewById(R.id.theme_animals_container);

		final Theme themeAnimals = Themes.createAnimalsTheme();

		animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));
			}
		});

		animateShow(animals);

		return view;
	}
	private void animateShow(View view) {
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.start();
	}
}
