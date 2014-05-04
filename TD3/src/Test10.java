import tc.TC;
public class Test10 {
	public static void main(String[] args) {
		Argent a1 = new Argent(100,73);
		Argent a2 = new Argent(23,15);
		
		TC.println("-- test a1.plus(a2) : attend 123.88");
		Argent a3 = a1.plus(a2);
		TC.println(a3);
		TC.println("-- test a1.plus(a1) : attend 201.46");
		Argent a4 = a1.plus(a1);
		TC.println(a4);
		
        Argent a5 = new Argent(123,45);
        Argent a6 = new Argent(67,89);
        TC.println("-- test a5.moins(a6) : attend 55.56");
        Argent a7 = a5.moins(a6);
        TC.println(a7);
        

        Argent a8 = new Argent(256,45);
        Argent a9 = new Argent(256,44);
        
        TC.println("-- test " + a8 + " > " + a9 + " : attend true");
        boolean ok = a8.estPlusGrandQue(a9);
        TC.println(ok);
        TC.println("-- test " + a8 + " > " + a8 + " : attend false");
        ok = a8.estPlusGrandQue(a8);
        TC.println(ok);
        TC.println("-- test " + a9 + " > " + a8 + " : attend false");
        ok = a9.estPlusGrandQue(a8);
        TC.println(ok);
	}
}
