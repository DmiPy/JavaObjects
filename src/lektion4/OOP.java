package lektion4;

public class OOP {
	
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
			int first_num = first.getZahler();
			int first_den = first.getNenner();
			int sec_num = second.getZahler();
			int sec_den = second.getNenner();
			
			if (first_den == sec_den) {
				numerator = first_num + sec_num;
				denominator = first.getNenner();
				Bruch result = new Bruch(numerator,denominator);
				return result;
			}
			
			else {
				denominator = lcm(first_den, sec_den);
				int first_multiplicator = denominator / first_den;

				first_num = first_multiplicator * first_num;
				int second_multiplicator = denominator / sec_den;
				sec_num = second_multiplicator * sec_num;
				numerator = first_num + sec_num;
				Bruch result = new Bruch(numerator,denominator);
				return result;
			}
		}
		
		static Bruch substrahiere(Bruch first, Bruch second) {
			int numerator = 0;
			int denominator = 0;
			int first_den = first.getNenner();
			int sec_den = second.getNenner();
			int first_num = first.getZahler();
			int sec_num = second.getZahler();
			if (first_den == sec_den) {
				numerator = first_num - sec_num;
				denominator = first.getNenner();
				Bruch result = new Bruch(numerator,denominator);
				return result;
			}
			
			else {
				denominator = lcm(first_den, sec_den);
				int first_multiplicator = denominator / first_den;

				first_num = first_multiplicator * first_num;
				int second_multiplicator = denominator / sec_den;
				sec_num = second_multiplicator * sec_num;
				numerator = first_num - sec_num;
				Bruch result = new Bruch(numerator,denominator);
				
				return result;
			}
		}
		
		static Bruch multipliziere(Bruch first, Bruch second) {
			int first_den = first.getNenner();
			int sec_den = second.getNenner();
			int first_num = first.getZahler();
			int sec_num = second.getZahler();
			Bruch result = new Bruch(first_num * sec_num, first_den * sec_den);
			return result;
		}
		
		static Bruch dividiere(Bruch first, Bruch second) {
			int first_den = first.getNenner();
			int sec_den = second.getZahler();
			int first_num = first.getZahler();
			int sec_num = second.getNenner();
			Bruch result = new Bruch(first_num * sec_num, first_den * sec_den);
			return result;
		}
		
		public String toString() {
			String bruch = "(" + this.getZahler() + "/" + this.getNenner() + ")";
			return bruch;
		}
	}
	
	
	public static void main(String[] args) {
		Bruch bruch1 = new Bruch(1,3);
		Bruch bruch2 = new Bruch(4);
		Bruch bruch3 = new Bruch(2,3);
		
		Bruch result1 = Bruch.addiere(Bruch.substrahiere(bruch1,bruch2), bruch3);
		Bruch result2 = Bruch.multipliziere(Bruch.dividiere(result1, bruch2),bruch3);
		
		System.out.println(result1.toString());
		System.out.println(result2.toString());
	}

}
