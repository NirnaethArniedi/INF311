import tc.TC;

public class TestExercice3 {
    public static void main(String[] args) {
	    Index T3 = new Index("test-3");
	
		TC.lectureDansFichier("grec.txt");
		T3.ajouterTexte( );

    	ListeEntrees entrees = T3.toList( );
    	TC.println("Entrées en ordre alphabétique :");
    	TC.println(entrees);
    }
}