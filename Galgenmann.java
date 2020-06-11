// Autor: Stefan Gerecke
// Datum: 06.01.2020

import java.util.Random;
import java.util.Scanner;
public class Galgenmann {
	static Scanner scanner = new Scanner(System.in);
	static char worte[][] = { { 'z', 'a', 'u', 'd', 'e', 'r', 'n' }, { 'e', 'r', 'r', 'a', 't', 'e', 'n' },
			{ 'g', 'l', 'a', 'u', 'b', 'e', 'n' }, { 'l', 'a', 'c', 'h', 'e', 'n' },
			{ 'e', 'r', 's', 'c', 'h', 'e', 'i', 'n', 'e', 'n' }, {'v','e','r','l','i','e','r','e','n'} };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Galgenmann - ein lustiges Ratespiel fuer die ganze Familie");

		boolean lebt = true;

		while (lebt) {

			menue();
		}

	}

	public static void menue() {

		System.out.println("\n\n (S)pielen oder (B)eenden\n\n");
		String menu = scanner.next();
		switch (menu.toLowerCase()) {

		case "s": {
			raten();
			break;

		}

		case "b": {

			scanner.close();
			System.exit(1);
		}

		default: {
			System.out.println("Falsche Taste!");
		}

		}
	}

	public static void raten() {
		int i = 0;
		int g = 1;
		int c = 0;
		Random zufall = new Random();

		int w = zufall.nextInt(5);
		
		char zwsp[] = new char[worte[w].length];
		char speicher[] = new char[worte[w].length];
		boolean nochmal = true;
		boolean b = true;
		while (nochmal) {
			boolean a = true;

			while (b) {
				for (int x = 0; x < worte[w].length; x++) {
					zwsp[x] = '_';
					System.out.print(zwsp[x] + " ");
				}
				b = false;
			}

			System.out.println("\n\nGib einen Buchstaben ein: \n");
			char buchstabe = (scanner.next().charAt(0));
			g++;

			for (i = 0; i < worte[w].length; i++) {

				if (buchstabe != worte[w][i] && zwsp[i] == '_') {

					zwsp[i] = '_';

					speicher[i] = zwsp[i];

				}

				if (buchstabe == worte[w][i]) {
					c++;
					zwsp[i] = buchstabe;
					speicher[i] = zwsp[i];

					while (a) {
						g--;

						a = false;
					}
				}


				
				System.out.print(speicher[i] + " ");
				
				
					
				if(c==worte[w].length) {
					System.out.println("\n\nGewonnen");
					nochmal=false;
				}
					
				
				
				
			}
			if (g > 1 && g != worte[w].length) {
				System.out.println("\n\n");
				galgen(g);
				
				if(g==12) {
					System.out.println("\n\nVerloren");
					nochmal=false;
				}
				
				System.out.println("\n\n");
					
			}
			
	
		}
	}

	static void galgen(int y) {

		
		String galgen[] =

				{"|                 |","___________________", "          |", "          |", "          |",
						"          |", "          |        / " + (char) 92, "          |         |",
						"          |        /|" + (char) 92, "          |         0 ", "          |         |",
						"          ___________" };
		
		for (int x = y; x > 0; x--) {

			System.out.println(galgen[x - 1] );

		}

	}

}
