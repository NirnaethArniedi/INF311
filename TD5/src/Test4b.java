import tc.TC;

public class Test4b {

	public static void main(String[] args) {
		Labyrinthe laby = new Labyrinthe("labyrinthe2.txt");
		//double p=0.42; Labyrinthe laby = new Labyrinthe(25, 20, p);
		// Labyrinthe laby = new Labyrinthe(25, 20);

		Explorateur explo = new Explorateur(laby);

		laby.afficher();
		TC.println(explo.explorePourSortir());
	}

}
