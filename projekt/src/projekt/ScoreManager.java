package projekt;

public class ScoreManager {

	private int score = 0;
	private int dice;
	private int temporarlyScore = 0;
	private int i_rounds;
	private int tryes;

	public void startRound() {
		tryes = 5;
		temporarlyScore = 0;
	}

	public int dice() {
		dice = (int) ((Math.random() * 6) + 1);
		checkDice();
		return dice;
	}

	public void checkDice() {
		switch (dice) {
		case 1:
		case 3:
		case 5:
			score-=temporarlyScore;
			temporarlyScore = 0;
			tryes = 0;
			break;
		case 2:
		case 4:
		case 6:
			temporarlyScore += dice;
			score+
			tryes -= 1;
		}
	}
	public int get() {
		
	}
}
