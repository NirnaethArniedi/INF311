import tc.TC;
public class Test02 {
	public static void main(String[] args) {
        Argent a1 = new Argent(0,15);
		Argent a2 = new Argent(0,15);
		
		TC.println("-- test == : attend false");
		TC.println(a1==a2);
		TC.println("-- test equals : attend true");
		boolean res = a1.equals(a2);
		TC.println(res);
        TC.println("-- test equals(null) : attend false");
        res = a1.equals(null);
        TC.println(res);
		
        TC.println("-- test toString : attend 0.15");
        String s1 = a1.toString( );
        TC.println(s1);
        
        TC.println("-- test toString : attend 174.01");
        TC.println(new Argent(174,01));
	}
}
