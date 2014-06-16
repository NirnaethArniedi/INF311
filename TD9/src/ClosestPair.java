/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * An interface defining methods for computing the closest pair of a set of points in the plane
 */
public interface ClosestPair {

	public Point2D[] computeClosestPair(Point2D[] points);
	public double computeMinDistance(Point2D[] points);
	
}
