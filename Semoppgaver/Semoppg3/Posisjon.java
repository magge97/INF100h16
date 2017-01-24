package Semoppg3;

public class Posisjon {

	private int x;
	private int y;
	private int gull;

	public Posisjon(int x, int y) {
		this.x = x;
		this.y = y;
		gull = 0;
	}

	public int hentGull () {
		return gull;
	}
	
	public int hentX () {
		return x;
	}
	
	public int hentY () {
		return y;
	}
	
	public void plukkGull (char tegn) {
		if (tegn == 'g') {
			gull++;
		}
	}
	
	public boolean kanGaaTil(String retning, char[][] tabell) {
		if (retning.equals("nord")) {
			if (tabell[y - 1][x] == '*')
				return false;
		}
		if (retning.equals("soer")) {
			if (tabell[y + 1][x] == '*')
				return false;
		}
		if (retning.equals("vest")) {
			if (tabell[y][x - 1] == '*')
				return false;
		}
		if (retning.equals("oest")) {
			if (tabell[y][x + 1] == '*')
				return false;
		}
		if (retning.equals("avslutt")) {
			return false;
		}
		return true;
	}
	
	public void gaaTil(String retning, char[][] tabell, char tegn) {
		tabell[y][x] = ' ';
		
		if (retning.equals("nord")) {
			plukkGull(tabell[y - 1][x]);
			tabell[--y][x] = tegn;
		}
		if (retning.equals("soer")) {
			plukkGull(tabell[y + 1][x]);
			tabell[++y][x] = tegn;
		}
		if (retning.equals("vest")) {
			plukkGull(tabell[y][x - 1]);
			tabell[y][--x] = tegn;
		}
		if (retning.equals("oest")) {
			plukkGull(tabell[y][x + 1]);
			tabell[y][++x] = tegn;
		}
	}

	
}
