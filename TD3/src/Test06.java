import tc.TC;
public class Test06 {
	public static void main(String[] args) {
		String s = "187162369.05";
		TC.println("-- test constructeur Argent(String) : attend 187162369.05");
		Argent a = new Argent(s);
		assert(a.euros( ) == 187162369 && a.centimes( ) == 5);
		TC.println(a);
	}

}
