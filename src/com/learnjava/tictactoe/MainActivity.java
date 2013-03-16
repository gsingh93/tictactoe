package com.learnjava.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private boolean playerOneTurn = true;

	private int board[][] = new int[3][3];

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

		int num;
		if (playerOneTurn == true) {
			button.setImageResource(R.drawable.x);
			num = 1;
		} else {
			button.setImageResource(R.drawable.o);
			num = 2;
		}

		if (v.getId() == R.id.button00) {
			board[0][0] = num;
		} else if (v.getId() == R.id.button01) {
			board[0][1] = num;
		} else if (v.getId() == R.id.button02) {
			board[0][2] = num;
		} else if (v.getId() == R.id.button10) {
			board[1][0] = num;
		} else if (v.getId() == R.id.button11) {
			board[1][1] = num;
		} else if (v.getId() == R.id.button12) {
			board[1][2] = num;
		} else if (v.getId() == R.id.button20) {
			board[2][0] = num;
		} else if (v.getId() == R.id.button21) {
			board[2][1] = num;
		} else if (v.getId() == R.id.button22) {
			board[2][2] = num;
		}

		// See if anyone won
		checkGame();

		playerOneTurn = !playerOneTurn;
	}

	private void checkGame() {
		// First row
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
			if (board[0][0] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Second row
		if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
			if (board[1][0] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Third row
		if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
			if (board[2][0] != 0) {
				displayWinDialog();
				return;
			}
		}

		// First column
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
			if (board[0][0] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Second column
		if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
			if (board[0][1] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Third column
		if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
			if (board[0][2] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Top left to bottom right diagonal
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if (board[0][0] != 0) {
				displayWinDialog();
				return;
			}
		}

		// Top right to bottom left diagonal
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if (board[0][2] != 0) {
				displayWinDialog();
				return;
			}
		}
	}

	private void displayWinDialog() {
		String message;
		if (playerOneTurn == true) {
			message = "Player one wins!";
		} else {
			message = "Player two wins!";
		}

		new AlertDialog.Builder(this).setMessage(message).show();
	}
}
