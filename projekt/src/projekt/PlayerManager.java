package projekt;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	private List<GameMainGui> gmgl = new ArrayList<GameMainGui>();
	private int totalRounds;
	private String[] playerNames;
	private Color[] playerBackgrounds;
	private Color[] playerForegrounds;
	private RoundManager rm;
	private int iRounds = 0;
	private int[] evilNums;

	public PlayerManager(int rounds, String[] playerNames, Color[] playerBackgrounds, Color[] playerForegrounds, int[] evilNums) {
		totalRounds = rounds;
		this.evilNums=evilNums;
		this.playerNames = playerNames;
		this.playerBackgrounds = playerBackgrounds;
		this.playerForegrounds = playerForegrounds;

	}

	public void startGame() {
		rm = new RoundManager(playerNames.length, totalRounds, this, iRounds);
		for (int i = 0; i < this.playerNames.length; i++) {
			GameMainGui gg = new GameMainGui(playerNames, playerBackgrounds[i], playerForegrounds[i], i, totalRounds,
					rm, evilNums);
			gg.setVisible(true);
			gmgl.add(gg);
		}
		startRound();
	}

	public void startRound() {
		iRounds = rm.setFinnishedRoundCount(0);
		for (int i = 0; i < this.playerNames.length; i++) {
			gmgl.get(i).startRound(iRounds);
		}
	}

	public void startResult() {
		int[] scores = new int[playerNames.length];
		iRounds = rm.setFinnishedRoundCount(0);
		for (int i = 0; i < this.playerNames.length; i++) {
			scores[i] = gmgl.get(i).getScore();
		}
		Result r1= new Result(scores,playerNames);
		r1.createResultWindow();
	}
}
