package accountapplication;

import java.util.Scanner;

public class User {

	public void dialog() {
		Konto mykonto = new Konto();
		System.out.println("Welcome to the account application");
		double amount = 0;
		String command = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please enter the amount, 0 (zero) to terminate");
			try {
				amount = sc.nextDouble();
			} catch(Exception error){
				System.out.println("This is not a number");
			}
			if (amount != 0) {
				System.out.println("To deposit, press +, to withdraw press -");
				command = sc.next();
				if (command.equals("+")) {
					mykonto.einzahlen(amount);
				} else if (command.equals("-")) {
					mykonto.abheben(amount);
				}
			}
		} while (amount != 0);
		sc.close();
		System.out.println("Final balance: " + mykonto.getKontostand());
	}

}
