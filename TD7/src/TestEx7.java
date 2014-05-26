import tc.TC;                                                                                                                                       

public class TestEx7 {                                                                                                                    

	public static void main(String[] args) {       
		
		ListeCandidats bourgogne = new ListeCandidats("candidatsBourgogne.txt");                                                            
		TC.println(bourgogne);                                                                                                                          
		TC.println();

		ListeCandidats picardie = new ListeCandidats("candidatsPicardie.txt");                                                              
		TC.println(picardie);       
		TC.println();

		TC.println("concatenation :");
		bourgogne.concatener(picardie);
		TC.println(bourgogne);
		TC.println();

		// bourgogne.filtrerAdmissibles(9);
		// TC.println(bourgogne);
		// TC.println(picardie);
		
		// picardie.filtrerAdmissibles(13);
		// TC.println(bourgogne);
		// TC.println(picardie);
		
        }
}
