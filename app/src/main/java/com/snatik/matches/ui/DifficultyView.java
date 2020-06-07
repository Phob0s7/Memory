package com.snatik.matches.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DifficultyView extends LinearLayout {

	public DifficultyView(Context context) {
		this(context, null);
	}

	public DifficultyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
	}
}
