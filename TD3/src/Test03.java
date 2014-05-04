import tc.TC;
public class Test03 {
	public static void main(String[] args) {
        Compte c1 = new Compte("Alice_Truite",121386,new Argent(1213,05));
        
        TC.println("-- test toString( ) : attend 121386 1213.05 Alice_Truite");
        String s1 = c1.toString( );
        TC.println(s1);  
	}
}
