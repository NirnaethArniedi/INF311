import tc.TC;

public class Noeud {
    public Noeud gauche;
    public Noeud droit;
    public Entree contenu;
    
    public Noeud(Entree e) {
        gauche = null;
        droit = null;
        contenu = e;
    }
    
    public Noeud(Noeud g, Noeud d, Entree e) {
        gauche = g;
        droit = d;
        contenu = e;
    }
    
    public String toString( ) {
        // pour debugging
        String str = "";
        if(gauche != null)
            str += "(" + gauche + ")";
        else
            str += "*";
        str += " <- " + contenu + " -> ";
        if(droit != null)
            str += "(" + droit + ")";
        else
            str += "*";
        return str; 
    }
    
    
    public Entree trouver(String w) {
    	// L'entrée associée au mot w, si w se trouve dans l'arbre.
        // Sinon, null est renvoyé.
        
        // à compléter...
        return null;
    }
    
    public void ajouter(String w, int n) {
        // Si le mot w est contenu dans l'arbre, on ajoute le numéro de ligne n à l'entrée pour ce mot.
        // Si le mot w n'a pas encore d'entrée dans l'arbre, alors on crée une nouvelle entrée.
        
        // à compléter...
    }

    public ListeEntrees traverser( ) {
        // Une liste de toutes les entrées dans l'arbre, *en ordre croissant*.
        
        // à compléter...
    	return null;
    }
    
    public void traverserPourImprimer() {
        // Imprimer une liste de toutes les entrées dans l'arbre, *en ordre croissant*.        
        
    	// à compléter...    	    	
    }
    
    public boolean estOrdonne(String min, String max) {
        // Renvoie true si l'arbre enraciné dans ce noeud
        // répresente un arbre binaire de recherche correct.
        // Sinon, renvoie false.
        
        // à compléter...
    	
    	return true;
    }

}
