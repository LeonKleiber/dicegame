
public class Konto {
	double kontostand = 0;

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
