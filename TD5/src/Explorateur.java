//import tc.TC;

public class Explorateur {

	public Labyrinthe laby;

	public Explorateur(Labyrinthe laby) {
		this.laby = laby;
	}

	public void exploreCase(Case c) {
		c.marqueVue();
		Case[] tab;
		tab=c.voisines();
		for(int i=0;i<tab.length;i++){
			if(tab[i].estCouloir()){
				if(tab[i].estInconnue()){
					exploreCase(tab[i]);
				}
			}
		}
		// A COMPLETER
	}

	public void explore() {
		exploreCase(laby.entree());
	}

	public boolean exploreCasePourSortir(Case c) {
		if(c.estSortie()){
			c.marqueChemin();
			return true;
		}
		Case[] tab;
		tab=c.voisines();
		c.marqueVue();
		for(int i = 0; i < tab.length; i++){
			if(tab[i].estCouloir()){
				if(tab[i].estInconnue()){
					if(exploreCasePourSortir(tab[i])){
						c.marqueChemin();
						return true;
					}
				}
			}
		}
		c.marqueImpasse();
		return false;
	}

	public boolean explorePourSortir() {
		return exploreCasePourSortir(laby.entree());
	}


}
