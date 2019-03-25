package projekt;

public class ScoreManager {

	private int score = 0;
	private int dice;
	private int temporarlyScore;
	private int tryes;
	private int position;

	public void startRound() {
		setTryes(5);
		setTemporarlyScore(0);
	}

	public int dice() {
		dice = (int) ((Math.random() * 6) + 1);
		checkDice();
		return dice;
	}

	public void checkDice() {
		this.setPosition(5-this.getTryes()); 
		if (dice%2==0) {
			setTemporarlyScore(getTemporarlyScore() + dice);
			this.setScore(this.getScore() + dice);
			setTryes(getTryes() - 1);
		}else{
			this.setScore(this.getScore() - this.getTemporarlyScore());
			setTemporarlyScore(0);
			setTryes(0);

		}
	}

	private void setPosition(int position) {
		this.position =position;
		
	}

	public void setTryes(int tryes) {
		this.tryes=tryes;
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTryes() {
		return tryes;
	}

	private  int getTemporarlyScore() {
		return temporarlyScore;
	}

	public void setTemporarlyScore(int temporarlyScore) {
		this.temporarlyScore = temporarlyScore;
	}

	public int getPosition() {
		return position;
	}

	public void endRound() {
		setTryes(0);
	}

}
