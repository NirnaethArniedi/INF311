import java.util.*;
/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * Class for representing a 2D point with real coordinates (double precision)
 */
public class Point2D implements Element {
	
	double x, y;
	
	public Point2D(double x, double y) { this.x=x; this.y=y; }
	
	public double getX() { return x; }
	public double getY() { return y; }
	
    /**
     * Check whether the current point is smaller than e, with respect to a given order
     */
	public boolean isSmaller(Element e, ElementComparator c) {
		return c.compare(this, e)==-1;
	}

    /**
     * Check whether the current element is equal to e
     */
	public boolean equals(Element e) {
		Point2D q=(Point2D)e;
		return (x==q.getX() && y==q.getY());
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	/**
     * Paint the point in a graphic frame
     */
    public void paint(Draw d, int i) {
    	d.g.paintCircle((int) this.getX(), (int) this.getY(), 4);
    }
	
	public double distanceFrom(Point2D q) {
		return Math.sqrt((x-q.x)*(x-q.x)+(y-q.y)*(y-q.y));
	}
	
	public static Point2D[] randomPointsInSquare(int n, int size) {
		Point2D[] result=new Point2D[n];
		for(int i=0;i<n;i++) {
			double precision=100.;
			double px=((int)(Math.random()*size*precision))/precision;
			double py=((int)(Math.random()*size*precision))/precision;
			result[i]=new Point2D(px, py);
		}
		return result;
	}
	
	public static Point2D[] randomPointsInSquare(int n, int size, int seed) {
		Point2D[] result=new Point2D[n];
		Random rnd=new Random(seed);
		for(int i=0;i<n;i++) {
			double precision=100.;
			double px=((int)(rnd.nextDouble()*size*precision))/precision;
			double py=((int)(rnd.nextDouble()*size*precision))/precision;
			result[i]=new Point2D(px, py);
		}
		return result;
	}
	
	/**
	 * Return an array of size (j-i), containing all elements in the interval [i,j) of array t
	 * We assume i<j.
	 * Return null if t is not defined or has length 0.
	 */
	public static Point2D[] extractInterval(Point2D[] t, int i, int j) {
		if(t==null || t.length==0 || i>=j) return null;
		Point2D[] result=new Point2D[j-i];
		for(int k=i;k<j;k++)
			result[k-i]=t[k];
		return result;
	}
	
	public static void printPoints(Point2D[] points) {
		for(int i=0;i<points.length;i++)
			System.out.println(points[i]);
	}

}
