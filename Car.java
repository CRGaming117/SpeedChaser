package SpeedChaser;

import java.awt.*;

public class Car {
  public Car() {

  }

  public void drawRed(Graphics g, int px, int py, int pw, int ph) {
    // wheels
    g.setColor(Color.BLACK);
    g.fillRect(px + 5, py + ph, 45, 10);
    g.fillRect(px + pw - 50, py + ph, 45, 10);
    // rearviews
    g.setColor(Color.CYAN);
    g.fillOval(px + 10, py - 12, 24, 12);
    g.fillOval(px + pw - 34, py - 12, 24, 12);
    g.setColor(new Color(200, 30, 30));
    g.drawOval(px + 10, py - 12, 24, 12);
    g.drawOval(px + pw - 34, py - 12, 24, 12);
    // body
    g.fillRect(px, py, pw, ph);
    // roof
    int[] rc1xp = { px + 50, px + pw - 50, px + pw - 25, px + 25 };
    int[] rc1yp = { py - 25, py - 25, py, py };
    g.fillPolygon(rc1xp, rc1yp, rc1xp.length);
    // rear window
    g.setColor(Color.CYAN);
    int[] wc1xp = { px + 50, px + pw - 50, px + pw - 30, px + 30 };
    int[] wc1yp = { py - 20, py - 20, py, py };
    g.fillPolygon(wc1xp, wc1yp, wc1xp.length);
    g.setColor(Color.BLACK);
    g.drawPolygon(wc1xp, wc1yp, wc1xp.length);
    // tailights
    g.fillRect(px + 10, py + 10, 180, 25);
    g.setColor(Color.RED);
    g.fillRect(px + 10, py + 10, 50, 25);
    g.fillRect(px + pw - 60, py + 10, 50, 25);
    g.setColor(Color.BLACK);
    g.drawRect(px + 10, py + 10, 180, 25);
    // exhaust
    g.setColor(Color.DARK_GRAY);
    g.fillRect(px + 15, py + ph - 20, 40, 18);
    g.fillRect(px + pw - 55, py + ph - 20, 40, 18);
    g.setColor(Color.BLACK);
    g.drawRect(px + 15, py + ph - 20, 40, 18);
    g.drawRect(px + pw - 55, py + ph - 20, 40, 18);
    g.fillOval(px + 27, py + ph - 19, 16, 16);
    g.fillOval(px + pw - 43, py + ph - 19, 16, 16);
    g.setColor(Color.LIGHT_GRAY);
    g.drawOval(px + 27, py + ph - 19, 16, 16);
    g.drawOval(px + pw - 43, py + ph - 19, 16, 16);
    // plate
    g.setColor(Color.WHITE);
    g.fillRect(px + (pw / 2) - 20, py + 50, 40, 20);
    g.setColor(Color.BLACK);
    g.drawRect(px + (pw / 2) - 20, py + 50, 40, 20);
  }
}
