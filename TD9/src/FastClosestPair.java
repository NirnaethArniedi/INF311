/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * A fast Divide and Conquer algorithm for computing closest pair, based on binary recursion
 */
public class FastClosestPair implements ClosestPair {

	Point2D[] points;
	ElementComparator cX=new CoordinateComparatorX(); // the comparator for the x coordinates
	ElementComparator cY=new CoordinateComparatorY(); // comparator for y coordinates
	Search searchX=new Search(cX); // for searching in the x direction
	Search searchY=new Search(cY); // for searching in the y direction
	
	public FastClosestPair(Point2D[] inputPoints) {
		this.points=inputPoints;
		SortingAlgorithm algo=new MergeSort(points, cX);
		algo.run(); // sort points along x axis (performed only once, as preprocessing step)
		Point2D.printPoints(points);
	}

	/**
	 * Compute and return the closest pair of a set of points
	 */
	public Point2D[] computeClosestPair(Point2D[] t) {
		if(t.length<4) {
			ClosestPair cp=new BruteForceClosestPair();
			return cp.computeClosestPair(t);
		}
		Point2D[][] s=splitWithMedian(t);
		Point2D[] s1=s[0]; // lower subset
		Point2D[] s2=s[1]; // upper subset
		Point2D median=s2[0];
		System.out.println("t: "+t.length+", median "+median);
		
		Point2D[] pair1=computeClosestPair(s1);
		Point2D[] pair2=computeClosestPair(s2);
		double delta1=pair1[0].distanceFrom(pair1[1]);
		double delta2=pair2[0].distanceFrom(pair2[1]);
		double delta=Math.min(delta1, delta2);

		throw new Error("A completer");

	}
	
	/**
	 * Find the closest point to q, among the points stored in t (with a linear search)
	 */
	public Point2D closestPointTo(Point2D[] t, Point2D p) {
		if(p==null || t==null || t.length==0) return null;
		double distance=p.distanceFrom(t[0]);
		int index=0;
		for(int i=1;i<t.length;i++) {
			double dist=p.distanceFrom(t[i]);
			if(dist<distance) {
				distance=dist;
				index=i;
			}
		}
		return t[index];
	}
	
	/**
	 * Return the distance of the closest pair of points
	 */
	public double computeMinDistance(Point2D[] t) {
		Point2D[] cp=computeClosestPair(t);
		return cp[0].distanceFrom(cp[1]);
	}

}
