import java.math.BigInteger;
import tc.TC;

public class TestPGCDRec {
	
	public static void testInt() {
		TC.println("Test du pgcd euclidien (sur des int)");
		int a=1794;
		int b=2014;
		TC.println("pgcd("+a+','+b+")="+PGCDRec.pgcd(a,b));
		TC.println("pgcd("+b+','+a+")="+PGCDRec.pgcd(b,a));
		TC.println("pgcd("+a+','+a+")="+PGCDRec.pgcd(a,a));
		a=31175;
		b=76923689;
		TC.println("pgcd("+a+","+b+") : "+PGCDRec.pgcd(a,b));
	}
	
	public static void testBigInt() {
		if(PGCDRec.pgcd(BigInteger.ONE, BigInteger.ONE)==BigInteger.ZERO) // pgcdRec est a' completer
			return;
		TC.println("Test du pgcd euclidien (entiers de grande taille)");
		BigInteger a=new BigInteger("1794");
		BigInteger b=new BigInteger("2014");
		BigInteger aModb=PGCDRec.pgcd(a,b);
		BigInteger bModa=PGCDRec.pgcd(b,a);
		BigInteger aModa=PGCDRec.pgcd(a,a);
		TC.println("pgcd("+a+','+b+")="+aModb);
		TC.println("pgcd("+b+','+a+")="+bModa);
		if(aModb.equals(bModa)==false)
			TC.println("Erreur: "+ "pgcd("+a+','+b+") !="+" pgcd("+b+','+a+")");
		TC.println("pgcd("+a+','+a+")="+aModa);
		if(aModa.equals(a)==false)
			TC.println("Erreur: "+ "pgcd("+a+','+a+") != "+a);
		if(a.mod(aModb).equals(BigInteger.ZERO)==false || b.mod(aModb).equals(BigInteger.ZERO)==false)
			TC.println("Erreur: "+ "pgcd("+a+','+a+") n'est pas un diviseur de "+a+" et "+b);
		a=new BigInteger("7866784298331896182823447103457168173160834433872412843806690517");
		b=new BigInteger("437774118140441763391042217968619990303018712110465657658812113465");
		TC.println("a="+a+'\n'+"b="+b+'\n'+"pgcd : "+PGCDRec.pgcd(a,b));
	}
	
	public static void main(String[] args) {
		testInt( );
		TC.println( );
		testBigInt( );
	}
}
