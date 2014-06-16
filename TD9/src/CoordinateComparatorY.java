/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * An implementation of a comparator for point coordinates (y coordinates, in increasing order)
 */
public class CoordinateComparatorY implements ElementComparator {

	public int compare(Element p, Element q) {
		Point2D u=(Point2D)p;
		Point2D v=(Point2D)q;
		if(u.getY()<v.getY()) return SMALLER;
		else if(u.getY()==v.getY()) return EQUAL;
		else return LARGER;
	}

}
