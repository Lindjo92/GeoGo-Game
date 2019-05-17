package gameLogicSP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gameLogicMP.GameControllerMP;

public class CountDownTimer {

	private GameControllerSP controllerSP;
	private GameControllerMP controllerMP;

	private Timer countDownTimer;
	private TimerListener timerListener;
	private int countdown;
	private int timeSec;
	private boolean isGameTimer;

	//time = 16
	public CountDownTimer(GameControllerSP controller, int time) {
		this.controllerSP = controller;
		

		timerListener = new TimerListener();
		countDownTimer = new Timer(1000, timerListener);
		countdown = time;
		timeSec = time;
	}
	//game: time 16, Results: time 11
	public CountDownTimer(GameControllerMP controller, int time, boolean isGameTimer) {
		this.controllerMP = controller;
		this.isGameTimer = isGameTimer;

		timerListener = new TimerListener();
		countDownTimer = new Timer(1000, timerListener);
		countdown = time;
		timeSec = time;
	}

	public void startTimer() {
		countdown = timeSec;
		countDownTimer.restart();
	}

	public void stopTimer() {
		countDownTimer.stop();
	}

	public int getCountDown() {
		return countdown;
	}

	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (countdown <= 0) {
				stopTimer();
			} else {
				countdown -= 1;
				
				if(controllerSP == null) {
					if(isGameTimer) {
						controllerMP.updateGameTimer(countdown);
					}
					else {
						controllerMP.updateResultsTimer(countdown);
					}
				}
				else {
					controllerSP.updateGameTimer(countdown);
				}
			}
		}
	}
}