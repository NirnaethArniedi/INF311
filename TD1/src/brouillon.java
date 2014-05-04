
import tc.TC;

public class brouillon {
	// définition de constantes
	// connues de toute la classe
	public final static int M = 16, N = 100;
	public static void main(String[] args){
	int[] t = new int[N];
	for(int i = 0; i < N; i++)
	// conversion explicite
	t[i] = (int)(Math.random()*M);
	for( int i=0; i<N; i++)
		TC.print(t[i]+"|");
	TC.println();
	TC.print(t);
	return;
	
	}
	}