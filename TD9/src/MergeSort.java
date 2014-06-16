/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014) 
 * This class provides an implementation of the merge sorting algorithm (in place version)
 * Element comparisons are performed by the ElementComparator interface
 */
public class MergeSort implements SortingAlgorithm {

	final ElementComparator c; // the comparator defining a total order
	final Element[] t; // array storing elements to sort
	//Draw d1 = new Draw("Merge sort", 1000, 200);
	//Draw d2 = new Draw("Merge sort", 200, 200);

	public MergeSort(Element[] t, ElementComparator c) {
		this.t = t;
		this.c = c;
		//d1.draw(t);
	}

	/**
	 * Copy the input element e at position k in the array this.t
	 */
	public void replace(int k, Element e) {
		//d1.erase(k, t[k]); // add comments for benchmarks
		t[k] = e; // recopie finale
		//d1.blink(k, t[k]); // add comments for benchmarks
	}
	
	public void run() {
		runRec(0,t.length);
	}

	public void runRec(int g, int d) {
		if(d-g<=1) return;
		if(d-g!=1){
			int m=(d-g)/2+g;
			runRec(g,m);
			runRec(m,d);
			merge(g,m,d);
			return;
		}
			
	}

	public void merge(int g, int m, int d) {
		int parcoursG=0, parcoursD=0;
		Element[] f = new Element[d-g];
		for(int k = 0; k< d-g; k++){
			
			if(parcoursG >= m-g){
				f[k] = t[m+parcoursD];
				parcoursD++;
			}
			else if(parcoursD >= d-m){
				f[k] = t[g + parcoursG];
				parcoursG++;
			}
			else
				if(t[g+parcoursG].isSmaller(t[m+parcoursD], c)){
					f[k] = t[g+parcoursG];
					parcoursG++;
				}
				else{
					f[k] = t[m+parcoursD];
					parcoursD++;
				}
		}
		for(int k = 0; k < f.length; k++){
			replace(k+g,f[k]);
		}
		
	}

}
