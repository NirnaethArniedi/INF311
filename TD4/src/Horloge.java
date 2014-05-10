
public class Horloge {
	
	private Quotidien[] rappels;
	
	public Horloge(int n){
		this.rappels=new Quotidien[n];
	}
	
	private void aggrandir(int n){
		Quotidien[] nRappel=new Quotidien[this.rappels.length+n];
		for(int i=0;i<this.rappels.length;i++){
			nRappel[i]=rappels[i];
		}
		this.rappels=nRappel;
	}
	
	public void inscrire(Quotidien q){
		for(int i=0; i<this.rappels.length; i++){
			if(this.rappels[i]==null){
				this.rappels[i]=q;
				return;
			}
		}
		int n=this.rappels.length;
		aggrandir(n);
		this.rappels[n]=q;
	}
	
	public void rappeler(){
		for(int i=0; i<this.rappels.length;i++)
			if(this.rappels[i]!=null)
				this.rappels[i].minuit();
	}
}
