import java.awt.Color;

import maclib.*;

/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013) A class for
 *         painting generic elements in a graphic frame
 */
public class Draw {

	GrafPort g;
	int width;
	int height;

	static int sleepTime = 20;
	static int framePosition = 100; // x coordinate of the frame

	public Draw(String title, int width, int height) {
		this.g = new GrafPort(title, width, height);
		this.g.getPanel().getParent().setLocation(framePosition, 50);
		this.width = width;
		this.height = height;
		framePosition = framePosition + width + 20;
	}

	public void reset() {
		g.foreColor(Color.white);
		g.paintRect(new Rect(0, 0, height, height));
		g.foreColor(Color.black);
	}

	/**
	 * Paint a set of elements in a graphic frame
	 */
	public void draw(Element[] elements) {
		if (elements == null)
			return;
		reset();
		for (int i=0; i< elements.length; i++) 
			draw(i, elements[i]);
		pause();
	}

	public void draw(int i, Element e) {
		e.paint(this, i);
	}

	public void drawRed(int i, Element e) {
		g.foreColor(Color.RED);
		draw(i, e);
		g.foreColor(Color.BLACK);
	}

	public void erase(int i, Element e) {
		g.foreColor(Color.WHITE);
		draw(i, e);
		g.foreColor(Color.BLACK);
	}

	public void blink(int i, Element e) {
		g.foreColor(Color.GREEN);
		draw(i, e);
		pause();
		g.foreColor(Color.BLACK);
		draw(i, e);
	}
	
	public void pause() {
		try {
			Thread.sleep(sleepTime);
		} catch (Exception ex) {
			// System.out.println(e);
		}
	}

	public void drawComp(int i, Element e, int j, Element f) {
		g.foreColor(Color.GREEN);
		draw(i, e);
		draw(j, f);
		pause();
		g.foreColor(Color.BLACK);
		draw(i, e);
		draw(j, f);
	}

	public void drawSwap(int i, Element e, int j, Element f) {
		erase(i, e);
		erase(j, f);
		draw(j, e);
		draw(i, f);
		pause();
	}

	public void drawPolyline(Point2D[] points, Color color) {
		g.foreColor(color);
		for (int i = 1; i < points.length; i++) {
			g.drawLine((int) points[i - 1].getX(), (int) points[i - 1].getY(),
					(int) points[i].getX(), (int) points[i].getY());
		}
	}

}
