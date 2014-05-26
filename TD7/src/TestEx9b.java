import tc.TC;

public class TestEx9b {

	public static void main(String[] args) {
		
		ListeCandidats bourgogne = new ListeCandidats("candidatsBourgogne.txt");
		TC.println(bourgogne);
		ListeCandidats bourgogne_triee = ListeCandidats.trier(bourgogne);
		TC.println("\nListe bourgogne_triee:");
		TC.println(bourgogne_triee);
		
	}

}
