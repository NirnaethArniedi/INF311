import tc.TC;
public class Test06 {
	public static void main(String[] args) {
		Liquide vingt = new Liquide(new Argent(20,00));
		Liquide dix = new Liquide(new Argent(10,00));

		TC.lectureDansFichier("banque-eponge.txt");
		Horloge h = new Horloge(5);
		TC.println("-- lireBanque(Horloge)");
		Banque b = Banque.lireBanque(h);
		TC.println("-- distributeurs : ");
		Distributeur d1 = new Distributeur(h,b,"Distributeur 0",1010101010,vingt.fois(500)); 
		TC.println(d1);
		Distributeur d2 = new Distributeur(h,b,"Distributeur 1",1010101011,dix.fois(1000)); 
		TC.println(d2);
		
		long nClient = 312398740;
		TC.println(d1.consulter(nClient));
		TC.println("-- imposer limite quotidien de 300.00 euros sur compte #" + nClient);
		b.setLimite(nClient, new Argent(300,00));
		TC.println("-- test d1.retirer("+ nClient + ",200.00) : attend 10x 20 euros");
		Retrait res = d1.retirer(nClient, new Argent(200,00));
		TC.println(res);
		TC.println("-- test d2.retirer(" + nClient + ",90.00) : attend 9x 10 euros");
		res = d2.retirer(nClient,new Argent(90,00));
		TC.println(res);
		TC.println("-- test d1.retirer(" + nClient + ",20.00) : attend depassage de limite, pas de liquide");
		res = d1.retirer(nClient, new Argent(20,00));
		TC.println(res);
		
		TC.println("-- distributeurs : ");
		TC.println(d1);
		TC.println(d2);
		
		TC.println("-- minuit : test rappeler( )");
		h.rappeler( );
		TC.println("-- distributeurs : ");
		TC.println(d1);
		TC.println(d2);
		TC.println("-- test d1.retirer(" + nClient + ",20.00) : attend 1x 20 euros");
		res = d1.retirer(nClient, new Argent(20,00));
		TC.println(res);
	}
}
