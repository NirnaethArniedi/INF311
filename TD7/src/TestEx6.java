import tc.TC;

public class TestEx6 {

	public static void main(String[] args) {
		ListeCandidats bourgogne = new ListeCandidats("candidatsBourgogne.txt");
		TC.println(bourgogne);
		TC.println("filtre avec seuil = 13");
		bourgogne.filtrerAdmissibles(13);
		TC.println(bourgogne);
		TC.println();
		
		ListeCandidats centre = new ListeCandidats("candidatsCentre.txt");
		TC.println(centre);
		TC.println("filtre avec seuil = 20");
		centre.filtrerAdmissibles(20);
		TC.println(centre);
		TC.println();
		
		ListeCandidats limousin = new ListeCandidats("candidatsLimousin.txt");
		TC.println(limousin);
		TC.println("filtre avec seuil = 0");
		limousin.filtrerAdmissibles(0);
		TC.println(limousin);
		//limousin.filtrerAdmissibles(20);
		//TC.println(limousin);
		//limousin.filtrerAdmissibles(0);
		//TC.println(limousin);
	}

}
