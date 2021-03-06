/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * An implementation of a comparator for point coordinates (x coordinates, in increasing order)
 */
public class CoordinateComparatorX implements ElementComparator {

	public int compare(Element p, Element q) {
		Point2D u=(Point2D)p;
		Point2D v=(Point2D)q;
		if (u.getX()<v.getX()) return SMALLER;
		else if(u.getX()==v.getX()) return EQUAL;
		else return LARGER;
	}
}
