import java.util.Scanner;

public class Converter {
	public void dialog() {
		Scanner sc = new Scanner(System.in);
		DegreesConverter Convert = new DegreesConverter();
		int i = 0;
		int wahl = 0;
		double temp = 0;
		int weiter;
		while (i == 0) {
			try {
				System.out
						.println("Möchten Sie (1) Fahrenheit nach Celsius oder (2) Celsius nach Fahrenheit umrechnen?");
				System.out.print("Bitte geben Sie ihre Wahl, 1 oder 2, ein: ");
				wahl = sc.nextInt();
				System.out.print("Bitte geben Sie eine Temperatur ein: ");
				temp = sc.nextDouble();
				if (wahl == 1) {
					temp = Convert.toCelsius(temp);

				} else if (wahl == 2) {
					temp = Convert.toFahrenheit(temp);
				} else {
					break;
				}
				System.out.println("Die Temparatur beträgt: " + temp);
				System.out.print("Möchten Sie noch eine Temperatur umrechnen?(1)Ja (0)Nein:  ");
				weiter = sc.nextInt();
				if (weiter == 0) {
					i++;
				}
			} catch (Exception error) {
				break;
			}
		}

		sc.close();
	}
}
