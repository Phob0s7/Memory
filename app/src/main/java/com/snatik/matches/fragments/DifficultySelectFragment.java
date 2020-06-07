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
		setOnClick(difficulty1, 1);

		return view;
	}

	private void setOnClick(View view, final int difficulty) {
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new DifficultySelectedEvent(difficulty));
			}
		});
	}
}
