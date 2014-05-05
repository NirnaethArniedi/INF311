
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
		int i=0;
		while(i<this.rappels.length&&rappels[i]!=null)
			i+=1;
		if(i==this.rappels.length){
			aggrandir(1);
			this.rappels[i]=q;
		}
		else{
			this.rappels[i]=q;
		}
	}
	
	public void rappeler(){
		for(int i=0; i<this.rappels.length;i++)
			if(this.rappels[i]!=null)
				this.rappels[i].minuit();
	}
}
