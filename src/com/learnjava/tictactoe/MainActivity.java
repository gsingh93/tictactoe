package com.learnjava.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private int turn = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void buttonClicked(View v) {
		ImageButton button = (ImageButton) v;

		if (turn % 2 == 0) {
			button.setImageResource(R.drawable.x);
			turn++;
		} else {
			button.setImageResource(R.drawable.o);
			turn++;
		}
	}
}
