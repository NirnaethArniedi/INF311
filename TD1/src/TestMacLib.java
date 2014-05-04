import maclib.GrafPort;
import maclib.Point;

public class TestMacLib {

  public static void main(String[] args) {
    GrafPort g = new GrafPort();
    g.foreColor(GrafPort.RED_COLOR);
    g.textSize(24);
    g.textFace(GrafPort.BOLD);
    g.moveTo(30, 50);
    g.drawString("Bonjour");
    g.textSize(12);
    g.textFace(GrafPort.PLAIN);
    g.moveTo(10, 180);
    g.foreColor(GrafPort.BLACK_COLOR);
    g.drawString("cliquer");
    while (true) {
      Point p = g.getClick();
      for (int i = 0; i < 15; ++i)
        g.invertCircle(p.h, p.v, 10 * i);
    }
  }

}
