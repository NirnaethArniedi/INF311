import tc.TC;

public class PageWeb {
	
	private final String url;
	private final String titre;
	private final int visites;
	private int pagerank; 
	
	private PageWeb[] liens;
	private String[] mots;
	
	private int iliens;
	private int imots;
	
	public PageWeb(String url, String titre, int visites){
		this.url=url;
		this.titre=titre;
		this.visites=visites;
		this.pagerank=-1;
	}
	
	public void ajouteMot(String mot){
		if(mots==null || imots==mots.length) 
			agranditMots();
		mots[imots++]=mot;
	}
	
	public void ajouteLien(PageWeb p){
		if(liens==null || iliens==liens.length) 
			agranditLiens();
		liens[iliens++]=p;
	}
	
	private void agranditLiens(){
		if(liens==null)
			liens=new PageWeb[10];
		else{
			PageWeb[] tmp=new PageWeb[2*liens.length];
			for(int i=0; i<iliens; i++)
				tmp[i]=liens[i];
			liens=tmp;
		}	
	}
	
	public int score(String mot){
		String[] motspages = this.getMots();
		String[] motstitre = TC.motsDeChaine(this.getTitre());
		int visite = this.getVisites();
		int estdanspage = chercheMot(mot, motspages);
		int estdanstitre = 5 * chercheMot(mot, motstitre);
		int somme = estdanspage + estdanstitre;
		int sortie = this.pagerank + visite;
		return (somme * sortie);
	}
	
	public int getNombreLiens(){
		return iliens;
	}
	
	public PageWeb getLien(int i){
		return liens[i];
	}
	
	private void agranditMots(){
		if(mots==null)
			mots=new String[10];
		else{
			String[] tmp=new String[2*mots.length];
			for(int i=0; i<imots; i++)
				tmp[i]=mots[i];
			mots=tmp;
		}			
	}

	
	public String toString(){
		String s="URL="+url+"\n  TITRE="+titre+"\n  VISITES="+visites+"\n  MOTS=[";
		for(int k=0; k<imots; k++) s+=(k==0?"":" ")+mots[k];
		s+="]\n  LIENS=[";
		for(int k=0; k<iliens; k++) s+=(k==0?"":" ")+liens[k].url;
		return s+"]";
	}
	
	public String[] getMots(){
		String[] res=new String[imots];
		for(int i=0; i<imots; i++) res[i]=mots[i];
		return res;
	}
	
	public PageWeb[] getLiens(){
		PageWeb[] res=new PageWeb[imots];
		for(int i=0; i<iliens; i++) res[i]=liens[i];
		return res;
	}
	
	public void setPageRank(int p){
		pagerank=p;
	}
	
	public int getPageRank(){
		if(pagerank==-1) System.err.println("Erreur : Le pagerank de la page web "+url+" n'a pas encore été défini!");
		return pagerank;
	}
	
	public String getTitre(){
		return titre;
	}
	
	public int getVisites(){
		return visites;
	}
	
	public String getUrl(){
		return url;
	}
	
	private int chercheMot(String mot, String[] phrase){
		int k=0;
		while(k<phrase.length&&!(mot.equals(phrase[k])))
			k+=1;
		if(k==phrase.length)
			return 0;
		else
			return 1;
	}
	
}
