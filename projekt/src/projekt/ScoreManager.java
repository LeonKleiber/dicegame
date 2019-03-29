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
		this.setPosition(5-this.getTryes()); 
		setTryes(getTryes() - 1);
		return dice;
	}

	public void checkDice(int[] evilNums) {
		boolean isGood=true;
		for (int i=0;i<evilNums.length;i++) {
			if (dice==evilNums[i]) {
				endRound();
				isGood=false;
			}
		}
		if(isGood) {
			setTemporarlyScore(getTemporarlyScore() + dice);
			this.setScore(this.getScore() + dice);
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

	public int getTemporarlyScore() {
		return temporarlyScore;
	}

	public void setTemporarlyScore(int temporarlyScore) {
		this.temporarlyScore = temporarlyScore;
	}

	public int getPosition() {
		return position;
	}

	public void endRound() {
		this.setScore(this.getScore() - this.getTemporarlyScore());
		setTryes(0);
		setTemporarlyScore(0);
		
	}

}
