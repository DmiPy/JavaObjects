package lektion4;

import java.util.Scanner;

public class OOP {
	
	public static Scanner input = new Scanner(System.in);
	
	
	public static class Bruch{
		private static class Zahler {
			private int zahler;
			public Zahler(int x) {
				zahler = x;
			}
			public int getZahler() {
				return zahler;
			}
		}
	
		public static class Nenner{
			private int nenner;
			public Nenner(int y) {
				if (y == 0) {
					System.out.println("Nenner darf nicht null sein!");
					System.out.println("Das Programm ist beendet.");
					System.exit(0);
				}
				nenner = y;
				
			}
			
			public int getNenner() {
				return nenner;
			}
		}


		private Zahler numerator;
		private Nenner denominator;
		
		public Bruch(int zahler, int nenner) {
			this.numerator = new Zahler(zahler);
			this.denominator = new Nenner(nenner);
		}
		
		public Bruch(int ganzeZahl) {
			this.numerator = new Zahler(ganzeZahl);
			this.denominator = new Nenner(1);
		}
		
		public int getZahler() {
			return numerator.getZahler();
		}
		
		public int getNenner() {
			return denominator.getNenner();
		}
		
		public String toString() {
			String bruch = "( " + this.getZahler() + "/" + this.getNenner() + ")";
			return bruch;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Geben Sie zwei Zahlen (Zahler) und (Nenner) ein!");
		
		System.out.println("Die erste: ");
		int x = input.nextInt();
		
		System.out.println("Die zweite: ");
		int y = input.nextInt();
		
		Bruch fraction = new Bruch(x,y);
		System.out.println(fraction.toString());
		
	}

}
