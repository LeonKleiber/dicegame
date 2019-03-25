package projekt;

public class RoundManager {

	private int numOfPlayer;
	private int finnishedRoundCount;
	private int iRound;
	private PlayerManager pm;
	private int rounds;

	public RoundManager(int numOfPlayer, int totalRounds, PlayerManager pm, int iRounds) {
		this.pm = pm;
		this.numOfPlayer = numOfPlayer;
		this.iRound=iRounds;
		this.rounds=totalRounds;
	}

	public void checkRounds() {
		finnishedRoundCount++;
		if(finnishedRoundCount>=numOfPlayer) {
			iRound++;
			pm.startRound();
			if (iRound==rounds) {
				pm.startResult();
			}
		}
	}
	public int setFinnishedRoundCount(int frc) {
		finnishedRoundCount=frc;
		return iRound;
	}
}
