import tc.TC;

public class TestArithmetique {

	public static void main(String[] args) {
		TC.lectureDansFichier("expressions_correctes.txt");
		int i=1;
		while(!TC.finEntree()){
			TC.println("L'expression "+i+" s'evalue a : "+Arithmetique.eval());
			TC.lireLigne();
			i++;
		}
			
	}
}
