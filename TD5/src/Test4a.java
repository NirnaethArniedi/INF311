
public class Test4a {

	public static void main(String[] args) {
		Labyrinthe laby = new Labyrinthe("labyrinthe1.txt");
		//double p=0.42; Labyrinthe laby = new Labyrinthe(25, 20, p);
		// Labyrinthe laby = new Labyrinthe(25, 20);

		Explorateur explo = new Explorateur(laby);

		laby.afficher();
		explo.explore();
	}

}
