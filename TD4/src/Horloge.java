
public class Horloge {
	
	private Quotidien[] rappels;
	private int nbelt;
	
	public Horloge(int n){
		this.rappels=new Quotidien[n];
		this.nbelt=0;
	}
	
	private void aggrandir(int n){
		Quotidien[] nRappel=new Quotidien[this.rappels.length+n];
		for(int i=0;i<this.rappels.length;i++){
			nRappel[i]=this.rappels[i];
		}
		this.rappels=nRappel;
	}
	
	public void inscrire(Quotidien q){
		if(this.nbelt==this.rappels.length){
			int n=this.rappels.length;
			aggrandir(n);
			this.rappels[n]=q;
			this.nbelt+=1;
			return;
		}
		this.rappels[nbelt]=q;
		this.nbelt+=1;
		return;
	}
	
	/**public void inscrire(Quotidien q){
		int i=0;
		while(i<this.rappels.length&&rappels[i]!=null)
			i+=1;
		if(i==this.rappels.length){
			aggrandir(this.rappels.length);
			this.rappels[i]=q;
		}
		else{
			this.rappels[i]=q;
		}
	}**/
	
	public void rappeler(){
		for(int i=0; i<this.rappels.length;i++)
			if(this.rappels[i]!=null)
				this.rappels[i].minuit();
	}
}
