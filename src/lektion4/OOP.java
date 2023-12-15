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
	// Nenner klasse sollte privat sein
		public static class Nenner{
			private int nenner;
			public Nenner(int y) {
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
	}
	
	
	public static void main(String[] args) {
		Bruch fraction = new Bruch(2,3);
		System.out.println(fraction.getZahler());

	}

}
