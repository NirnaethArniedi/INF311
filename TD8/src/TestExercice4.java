import tc.TC;

public class TestExercice4 {
    public static void main(String[] args) {
	    Index b = new Index("grec");
	    TC.lectureDansFichier("grec.txt");
	    b.ajouterTexte( );
    	b.imprimer( );
    	
    	TC.ecritureSortieStandard( );
    	TC.println("COMPARER grec.index et grec.index.ref" );
    }
}
