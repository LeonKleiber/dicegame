package projekt;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	private List<GameMainGui> gameMainGuiList = new ArrayList<GameMainGui>();
	private int totalRounds;
	private String[] playerNames;
	private Color[] playerBackgrounds;
	private Color[] playerForegrounds;

	public PlayerManager(int rounds, String[] playerNames, Color[] playerBackgrounds, Color[] playerForegrounds) {
		totalRounds = rounds;
		this.playerNames = playerNames;
		this.playerBackgrounds = playerBackgrounds;
		this.playerForegrounds = playerForegrounds;

	}

	public void startGame() {
		for (int i = 0; i < this.playerNames.length; i++) {
			GameMainGui gg = new GameMainGui(playerNames, playerBackgrounds[i], playerForegrounds[i], i, totalRounds);
			gg.startRound();
			gg.setVisible(true);
			gameMainGuiList.add(gg);
		}
	}
}
