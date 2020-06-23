package com.snatik.matches.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.DifficultySelectedEvent;
import com.snatik.matches.ui.DifficultyView;

public class DifficultySelectFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);
		DifficultyView difficulty1 = view.findViewById(R.id.select_difficulty_1);
		DifficultyView difficulty2 = view.findViewById(R.id.select_difficulty_2);
		setOnClickFacile(difficulty1, 1);
		setOnClickMoyen(difficulty2, 2);
		return view;
	}

	private void setOnClickFacile(View view, final int difficulty1) {
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new DifficultySelectedEvent(difficulty1));
			}
		});
	}

	private void setOnClickMoyen(View view, final int difficulty2) {
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new DifficultySelectedEvent(difficulty2));
			}
		});
	}
}
