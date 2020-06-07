package com.snatik.matches.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.StartEvent;
import com.snatik.matches.utils.Utils;

public class MenuFragment extends Fragment {

	private Button mStartGameButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.menu_fragment, container, false);
		mStartGameButton = (Button) view.findViewById(R.id.button);
		mStartGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// animate title from place and navigation buttons from place
				animateAllAssetsOff(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						Shared.eventBus.notify(new StartEvent());
					}
				});
			}
		});

		return view;
	}

	protected void animateAllAssetsOff(AnimatorListenerAdapter adapter) {
		// start button
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.addListener(adapter);
		animatorSet.start();
	}
}
