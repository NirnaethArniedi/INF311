import tc.TC;

public class Index {
    public final String nom;
    public Noeud racine;
    private Noeud racineFiltre;
    
    public Index(String nom) {
        this.nom = nom;
        this.racine = null; // aucune entrée au début.
        this.racineFiltre = null;
    }
    
    public String toString( ) {
        return "Index de " + nom + ": " + racine;
    }
    
    public void dessiner( ) {
        new Fenetre(this.racine);
    }
    
    public void ajouterMot(String w, int n) {
        // Ajouter un mot w de ligne n à l'index.
        if(!(racineFiltre!=null  &&  racineFiltre.filtrer(w)))
    		if(racine == null) // première entrée!
    			racine = new Noeud(new Entree(w,n));
    		else
    			racine.ajouter(w,n);
    }
    
    public void ajouterTexte( ) {
        // Ajouter tous les mots trouvés dans un fichier (ou console), 
        // chacun avec le numéro de sa ligne.  
        // Lecture via TC, enlévant la ponctuation.
        
		int nligne = 1;
		while(!TC.finEntree( )) {
			for(String mot: TC.lireLigne( ).split("[ .,:;!?()\\[\\]\"]+"))
				ajouterMot(mot,nligne);
			nligne++;
		}
    }
    public void creerFiltre(String w) {
        // On cree l'arbre filtre a partir d'un fichier idoine
		TC.lectureDansFichier(w);
		while(!TC.finEntree( )) {
			for(String mot: TC.lireLigne( ).split("[ .,:;!?()\\[\\]\"]+"))
				ajouterFiltre(mot);
		}
    }
    public boolean estOrdonne() {
    	// Renvoie true si l'arbre enraciné dans le noeud this.racine
        // répresente un arbre binaire de recherche correct.
        // Sinon, renvoie false.
    	if(racine == null)
    		return true;
    	else
    		return racine.estOrdonne(null,null);
    }
    
    public ListeEntiers lignesDe(String w) {
        // La liste de tous les numéros de ligne où le mot w apparaît.
        if(racine == null) // => l'index est vide 
        {
        	return new ListeEntiers();
        }
        
        Entree e = racine.trouver(w);
        if(e == null) // le mot w n'est pas dans l'index
        {
        	return new ListeEntiers();
        }
        
        return e.occurrences;
    }
    
    public ListeEntrees toList() {
    	return racine.traverser();
    }
    
    public void imprimer( ) {
        // Écrire l'index dans un nouveau fichier avec le nom NNN.index,
        // où NNN est remplacé par this.nom .
        // Une entrée par ligne, de manière suivante:
        //     ampoule: 3, 31
        //     banane: 1, 13, 15
        //     chat: 1, 2, 5, 17, 18
        TC.ecritureDansNouveauFichier(this.nom + ".index");
        this.racine.traverserPourImprimer();
    }

    public void ajouterFiltre(String w) {
        // Ajouter un filtrage contre le mot w:
        // Desormais, le mot w sera ignoré et ne plus ajouté à l'index.
    	
    	if(racineFiltre == null) // première entrée!
            racineFiltre = new Noeud(new Entree(w));
        else
            racineFiltre.ajouterFiltre(w);
        // à compléter...
    }
    
}
