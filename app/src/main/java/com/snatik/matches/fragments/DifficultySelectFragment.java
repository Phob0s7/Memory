package com.snatik.matches.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.DifficultySelectedEvent;
import com.snatik.matches.themes.Theme;
import com.snatik.matches.ui.DifficultyView;

public class DifficultySelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);
        Theme theme = Shared.engine.getSelectedTheme();

        DifficultyView difficulty1 = (DifficultyView) view.findViewById(R.id.difficultyView);
        setOnClick(difficulty1, 1);

        DifficultyView difficulty2 = (DifficultyView) view.findViewById(R.id.difficultyView2);
        setOnClick(difficulty2, 2);

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
