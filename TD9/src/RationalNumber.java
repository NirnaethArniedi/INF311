import java.util.*;
import maclib.*;

/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * Class for representing a positive rational number (in reduced form)
 */
public class RationalNumber implements Element {

    int p;   // the numerator
    int q;   // the denominator

    /**
     * Create a rational number with a given numerator and denominator
     */
    public RationalNumber(int numerator, int denominator) {
        int g = gcd(numerator, denominator);
        this.p = numerator   / g;
        this.q = denominator / g;
    }
    
    /**
     * Check whether the current rational number is smaller than e
     */
	public boolean isSmaller(Element e, ElementComparator c) {
		return c.compare(this, e)==-1;
	}

    /**
     * Check whether the current rational number is equal to e
     */
	public boolean equals(Element e) {
		RationalNumber r=(RationalNumber)e;
		return (p*r.getDen()==q*r.getNum());
	}
    /**
     * Return the numerator
     */
    public int getNum()   { return p; }

    /**
     * Return the denominator
     */
    public int getDen() { return q; }

    /**
     * Return the value of the rational number (as floating point number)
     */
    public double toDouble() {
        return (double) p / q;
    }

    /**
     * Return a String representation of the rational number
     */
    public String toString() { 
        if (q == 1) return p + "";
        else          return p + "/" + q;
    }

	/**
     * Paint the rational number as a rectangle
     */
    public void paint(Draw d, int i) {
    	int height=d.height;
        Rect rect=new Rect(i, height-(int)this.toDouble(), (i+1), height);
        d.g.paintRect(rect);
    }

    /**
     * Compute gcd (for reduced form)
     */
    private static int gcd(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }
    
    /**
     * Return an array of n rational numbers, belonging to the interval [0.. size)
     */
	public static RationalNumber[] randomNumbersInInterval(int n, int size) {
		RationalNumber[] result=new RationalNumber[n];
		for(int i=0;i<n;i++) {
			double r=(Math.random()*size); // random real point in the interval [0..size)
			int precision=1000; // size of the denominator
			int p=(int)(r*precision);
			int q=precision;
			result[i]=new RationalNumber(p, q);
		}
		return result;
	}
	
    /**
     * Return an array of n rational numbers, belonging to the interval [0.. size)
     */
	public static RationalNumber[] randomNumbersInInterval(int n, int size, int seed) {
		RationalNumber[] result=new RationalNumber[n];
		Random random1=new Random(seed);
		for(int i=0;i<n;i++) {
			double r=(random1.nextDouble()*size); // random real point in the interval [0..size)
			int precision=1000; // size of the denominator
			int p=(int)(r*precision);
			int q=precision;
			result[i]=new RationalNumber(p, q);
		}
		return result;
	}

	
    /**
     * Print an array of rational numbers
     */
	public static void printNumbers(RationalNumber[] numbers) {
		for(int i=0;i<numbers.length;i++)
			System.out.println(numbers[i]);
	}


}
