/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * An implementation of the brute force (quadratic time) algorithm for computing the closest pair
 */
public class BruteForceClosestPair implements ClosestPair {

	public Point2D[] computeClosestPair(Point2D[] points) {
			if(points.length<2) throw new Error("Error: too few points");
			
			Point2D[] result=new Point2D[] {points[0], points[1]};
			double distance=result[0].distanceFrom(result[1]);
			for(int i=0;i<points.length;i++) {
				for(int j=i+1;j<points.length;j++) {
					double pairDistance=points[i].distanceFrom(points[j]);
					Point2D[] pair=new Point2D[] {points[i], points[j]};
					if(pairDistance<distance) {
						result=pair;
						distance=pairDistance;
					}
				}
			}
			return result;			
	}
	
	public double computeMinDistance(Point2D[] points) {
		Point2D[] cp=computeClosestPair(points);
		return cp[0].distanceFrom(cp[1]);
	}
	
}
