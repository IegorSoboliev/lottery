package lottery;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		System.out.println("Введіть три числа від 0 до 9, відділяючи їх пробілами: ");
		Scanner scanner = new Scanner(System.in);
		String chosenDigits = scanner.nextLine();
		scanner.close();
		String[] digits = chosenDigits.split(" ");

		int[] happyDigits = new int[3];
		Random random = new Random();
		int counter = 0;
		System.out.print("Виграшні числа: ");
		while (counter < happyDigits.length) {
			boolean present = false;
			int digit = random.nextInt(10);
			for (int d : happyDigits) {
				if (d == digit) {
					present = true;
					break;
				}
			}
			if (present == false) {
				happyDigits[counter] = digit;
				System.out.print(happyDigits[counter] + " ");
				counter++;
			}
		}
		
		int scores = 0;
		for (String s : digits) {
			int chosenDigit = Integer.parseInt(s);
			for (int happyDigit : happyDigits) {
				if (chosenDigit == happyDigit) {
					scores++;
				}
			}
		}
		if (scores == 0) {
			System.out.print(":((( На жаль, Ви не вгадали жодного числа");
		}
		if (scores == 1) {
			System.out.print("! Вітаємо! Ви вгадали одне число");
		}
		if (scores > 1) {
			System.out.print("!!! Вітаємо! Ви вгадали аж " + scores + " рази:)");
		}
	}
}
