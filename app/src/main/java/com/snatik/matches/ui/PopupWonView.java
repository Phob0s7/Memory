package com.snatik.matches.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.BackGameEvent;
import com.snatik.matches.model.GameState;
import com.snatik.matches.utils.Clock;
import com.snatik.matches.utils.Clock.OnTimerCount;
import com.snatik.matches.utils.FontLoader;
import com.snatik.matches.utils.FontLoader.Font;

public class PopupWonView extends RelativeLayout {

	private TextView mTime;
	private TextView mScore;
	private ImageView mBackButton;
	private Handler mHandler;

	public PopupWonView(Context context) {
		this(context, null);
	}

	public PopupWonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.popup_won_view, this, true);
		mTime = findViewById(R.id.time_bar_text);
		mScore = findViewById(R.id.score_bar_text);
		mBackButton = findViewById(R.id.button_back);
		FontLoader.setTypeface(context, new TextView[] { mTime, mScore }, Font.GROBOLD);
		mHandler = new Handler();
		mBackButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		});
	}

	public void setGameState(final GameState gameState) {
		int min = gameState.remainedSeconds / 60;
		int sec = gameState.remainedSeconds - min * 60;
		mTime.setText(" " + String.format("%02d", min) + ":" + String.format("%02d", sec));
		mScore.setText("" + 0);

		mHandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				animateScoreAndTime(gameState.remainedSeconds, gameState.achievedScore);
			}
		}, 500);
	}

	private void animateScoreAndTime(final int remainedSeconds, final int achievedScore) {
		final int totalAnimation = 1200;

		Clock.getInstance().startTimer(totalAnimation, 35, new OnTimerCount() {

			@Override
			public void onTick(long millisUntilFinished) {
				float factor = millisUntilFinished / (totalAnimation * 1f); // 0.1
				int scoreToShow = achievedScore - (int) (achievedScore * factor);
				int timeToShow = (int) (remainedSeconds * factor);
				int min = timeToShow / 60;
				int sec = timeToShow - min * 60;
				mTime.setText(" " + String.format("%02d", min) + ":" + String.format("%02d", sec));
				mScore.setText("" + scoreToShow);
			}

			@Override
			public void onFinish() {
				mTime.setText(" " + String.format("%02d", 0) + ":" + String.format("%02d", 0));
				mScore.setText("" + achievedScore);
			}
		});
	}
}
