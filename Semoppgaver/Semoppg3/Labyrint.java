package Semoppg3;

public class Labyrint {
	
	private int x;
	private int y;
	private int gull;
	private char[][] labyrint;
	
	public Labyrint(int x, int y, int gull) {
		this.x = x;
		this.y = y;
		this.gull = gull;
		labyrint = new char[this.y][this.x];
	}
	
	public void skrivUt () {
		for (int y = 0; y < this.y; y++) {
			for (int x = 0; x < this.x; x++) {
				System.out.print(this.labyrint[y][x]);
			}
			System.out.println();
		}
	}
	
	public boolean gyldigLabyrint() {
		if (this.x < 0 || this.y < 0) {
			return false;
		}
		return true;
	}
	
	public void settTegn (int x, int y, char tegn) {
		labyrint[y][x] = tegn;
	}
	
	public char tegnPaa (int x, int y) {
		return this.labyrint[y][x];
	}
	
	public int lengdeRad () {
		return this.y;
	}
	
	public int lengdeKol () {
		return this.x;
	}
	
}
