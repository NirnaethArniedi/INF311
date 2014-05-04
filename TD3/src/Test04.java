import tc.TC;
public class Test04 {
	public static void main(String[] args) {
		TC.println("-- test constructeur Banque(String,int)");
		Banque b = new Banque("Credit_du_Tigre", 100);
		TC.println("-- test toString : attend BANQUE Credit_du_Tigre");
		TC.println(b);	
	}
}
