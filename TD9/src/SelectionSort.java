public class SelectionSort implements SortingAlgorithm {

	final ElementComparator c; // comparator defining a total order
	final Element[] t; // array of elements to sort

	//Draw d = new Draw("SelectionSort", 1000, 200); // utile pour les dessins

	public SelectionSort(Element[] t, ElementComparator c) {
		this.t = t;
		this.c = c;
		//d.draw(t);
	}

	public void swap(int i, int j) {
		Element temp = this.t[i];
		this.t[i] = this.t[j];
		this.t[j] = temp;
	}

	public void run() {
		int i=0;
		//d.draw(t);
		while(i<t.length-1){
			int indiceMin=i;
			for(int k=i+1; k<t.length; k++){
				if(t[k].isSmaller(t[indiceMin],c)){
					indiceMin=k;
				}
			}
			//d.drawRed(i, t[i]);
			//d.blink(indiceMin, t[indiceMin]);
			//d.drawSwap(i, t[i],indiceMin, t[indiceMin]);
			swap(i,indiceMin);
			i+=1;
		}
	}
	
}
