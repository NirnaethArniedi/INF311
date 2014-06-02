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
    	int op = this.contenu.comparer(w);
    	if(op==0){
    		return this.contenu;
    	}
    	else if(op<0){
    		if(this.droit!=null)
    			return this.droit.trouver(w);
    		else return null;
    	}
    	else if(this.gauche!=null){
    		return this.gauche.trouver(w);
    	}
    	else{
    		return null;
    	}
    }
    
    public void ajouter(String w, int n) {
        // Si le mot w est contenu dans l'arbre, on ajoute le numéro de ligne n à l'entrée pour ce mot.
        // Si le mot w n'a pas encore d'entrée dans l'arbre, alors on crée une nouvelle entrée.
        
        int compare = this.contenu.comparer(w);
        if(compare == 0){
         	this.contenu.ajouter(n);
         	return;
        }
        else if(compare < 0){	
        	if(this.droit == null){
        		this.droit = new Noeud(new Entree(w,n));
        		return;
        	}
        	else{
        		this.droit.ajouter(w, n);
        		return;
        	}
        }
        else
        	if(this.gauche == null){
        		this.gauche = new Noeud(new Entree(w,n) );
        		return;
        	}
        	else{
        		this.gauche.ajouter(w, n);
        		return;
        	}
    }

    public ListeEntrees traverser( ) {
        // Une liste de toutes les entrées dans l'arbre, *en ordre croissant*.
        ListeEntrees liste;
    	if(this.gauche == null){
        	liste = new ListeEntrees();
        }
        else{
        	liste = this.gauche.traverser();
        }
        liste.ajouterEnQueue(this.contenu);
        if(this.droit != null){
        	ListeEntrees liste2 = this.droit.traverser();
        	liste.concatener(liste2);
        }
        return liste;
    }
    
    public void traverserPourImprimer() {
        // Imprimer une liste de toutes les entrées dans l'arbre, *en ordre croissant*.        
        if(this.gauche != null)
        	this.gauche.traverserPourImprimer();
        TC.println(this.contenu);
        if(this.droit != null)
        	this.droit.traverserPourImprimer();
        return;
    }
    
    public boolean estOrdonne(String min, String max) {
        // Renvoie true si l'arbre enraciné dans ce noeud
        // répresente un arbre binaire de recherche correct.
        // Sinon, renvoie false.
        
        // à compléter...
    	
    	return true;
    }

}
