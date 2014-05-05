import tc.TC;
public class Test05 implements Quotidien {

	int x;
	
	public void minuit() {
		TC.println("minuit ici : " + x);
	}

	public Test05(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		TC.println("-- new Horloge(5)");
		Horloge h = new Horloge(5);
		TC.println("-- test inscrire [0..4]");
		int i = 0;
		for(i = 0; i < 5; i++) {
			h.inscrire(new Test05(i));
		}
		TC.println("-- test inscrire [5..13] (devrait agrandir)");
		while(i < 13) {
			h.inscrire(new Test05(i++));
		}
		TC.println("-- test rappeler( ) : attend 'minuit ici : i', 0 <= i < 13");
		h.rappeler( );
	}

	
}
