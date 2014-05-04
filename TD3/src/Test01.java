import tc.TC;
public class Test01 {
	public static void main(String[] args) {
		long e = 123456789L;
		int c = 89;
		Argent a = new Argent( e, c );
		
		TC.println("-- test euros( ) : attend " + e);
		long res1 = a.euros( );
		TC.println( res1 );
		
		TC.println("-- test centimes( ) : attend " + c);
		long res2 = a.centimes( );
		TC.println( res2 );
	}
}
