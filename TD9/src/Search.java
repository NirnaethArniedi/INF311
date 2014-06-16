/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014)
 * A class providing methods for performing binary search.
 */
public class Search {
	
	ElementComparator c;
	
	public Search(ElementComparator c) {
		this.c=c;
	}
	
	/**
	 * Perform dichotomic search in the interval [left..right) of a sorted array
	 * Return the index of e, if e belongs to the array. Otherwise, return -1
	 */
	public int binarySearch(Element[] t, Element e, int left, int right) {
		if(right==left) return -1;
		if(right-left==1){
			if (t[left].equals(e)) return left;
			else return -1;
		};
		//if(e.isSmaller(t[left], c) && t[right-1].isSmaller(e, c)){
		//	return -1;
		//}
		int m = (right-left)/2+left;
		if(e.isSmaller(t[m], c)){
			return binarySearch(t,e,left,m);
		}
		else return binarySearch(t,e,m,right);
		//throw new Error("A completer");
	}
	
	/**
	 * Return the index of the smallest element f such that f>=e
	 */
	public int rangeSearch(Element[] t, Element e, int left, int right) {
		if(right==left) return left;
		if(right-left<=1){
			return left+1;
		}
		//if(e.isSmaller(t[left], c)) return left;
		//if(t[right-1].isSmaller(e, c)) return right;
		int m = (right-left)/2+left;
		if(e.isSmaller(t[m], c)){
			return rangeSearch(t,e,left,m);
		}
		else return rangeSearch(t,e,m,right);
		//throw new Error("A completer");
	}

	
	/**
	 * Compute the index of an element, by performing a linear scan in an array (already sorted)
	 * Return -1 if e does not appear in t.
	 */
	public int linearSearch(Element[] t, Element e, int left, int right) {
		for(int i=left;i<right;i++)
			if(c.compare(t[i], e)==ElementComparator.EQUAL)
				return i;
		
		return -1;
	}
	
}
