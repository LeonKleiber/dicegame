package accountapplication;

public class Konto {
	public double kontostand;
	
	public void einzahlen(double betrag) {
		kontostand += betrag;
	}
	public void abheben(double betrag) {
		kontostand -= betrag;
	}
	public double getKontostand() {
		return kontostand;
	}
}
