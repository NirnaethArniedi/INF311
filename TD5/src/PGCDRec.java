import java.math.BigInteger;

import tc.TC;

public class PGCDRec {
	public static int pgcd(int a, int b) {
		if(b==0)
			return a;
		return pgcd(b,a%b);
	}
	
	public static BigInteger pgcd(BigInteger a, BigInteger b){
		if(b.equals(BigInteger.ZERO))
			return a;
		return pgcd(b,a.mod(b));
	}
	public static void traiter(){
		String ligne1 = TC.lireLigne();
		int n = Integer.parseInt(ligne1);
		for(int i=0; i<2*n;i+=2){
			BigInteger a = new BigInteger(TC.lireLigne());
			BigInteger b = new BigInteger(TC.lireLigne());
			TC.println("pgcd : "+pgcd(a,b));
		}
		// __COMPLETER__ (Exo 1c: entrainement Pale Machine)
	}
}
