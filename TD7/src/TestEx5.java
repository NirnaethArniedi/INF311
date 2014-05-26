import tc.TC;

public class TestEx5 {

	public static void test(ListeCandidats l, String nom, String prenom) {
		if (l.retirer(nom, prenom))
			TC.println("suppression reussie; nouvelle liste : ");
		else TC.println("echec, " + prenom + " " + nom + " ne se trouve pas dans la liste :");
		TC.println(l);
	}
	
	public static void main(String[] args) {
		ListeCandidats bourgogne = new ListeCandidats("candidatsBourgogne.txt");
		TC.println(bourgogne);
		TC.println();
		test(bourgogne, "BEGIZ", "KENZA");
		TC.println();
		test(bourgogne, "CHESNEVARIN", "UGO");
		TC.println();
		test(bourgogne, "THOULIER", "SARAH");
		TC.println();
		test(bourgogne, "LEROI","LUC");
		TC.println();
		test(bourgogne, "RABODOU", "CLEMENT");
		TC.println();
		test(bourgogne, "ALLUIRE", "GERALDINE");
		TC.println();
		test(bourgogne, "RABODOU", "CLEMENT");
	}

}
