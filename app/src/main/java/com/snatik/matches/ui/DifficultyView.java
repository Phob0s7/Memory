package com.snatik.matches.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.snatik.matches.R;

public class DifficultyView extends LinearLayout {

	private ImageView mTitle;

	public DifficultyView(Context context) {
		this(context, null);
	}

	public DifficultyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.difficult_view, this, true);
		setOrientation(LinearLayout.VERTICAL);
		mTitle = (ImageView) findViewById(R.id.title);
	}
}
