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
					throw new IllegalArgumentException("Nenner darf nicht null sein!");
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
		
		static int gcd(int a, int b) {
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			return a;
		}
		
		static int lcm(int a, int b) {
			return a / gcd(a,b) * b;
		}
		
		
		static Bruch addiere(Bruch first, Bruch second) {
			int numerator = 0;
			int denominator = 0;
			if (first.getNenner() == second.getNenner()) {
				numerator = first.getZahler() + second.getZahler();
				denominator = first.getNenner();
				Bruch result = new Bruch(numerator,denominator);
				return result;
			}
			
			else {
				int first_num = first.getZahler();
				int first_den = first.getNenner();
				int sec_num = second.getZahler();
				int sec_den = second.getNenner();
				System.out.println("НОК чисел " + first_den + " и " + sec_den + " = "+ lcm(first_den, sec_den));
				return second;
			}
		}
		
		public String toString() {
			String bruch = "(" + this.getZahler() + "/" + this.getNenner() + ")";
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
		Bruch fraction2 = new Bruch(5,7);
//		System.out.println(fraction.toString());
		
		System.out.println(Bruch.addiere(fraction,fraction2));
		
	}

}
