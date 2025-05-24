package SpeedChaser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.text.DecimalFormat;

public class PanelSC extends JPanel {
  private int w, h;
  // Road line graphics variables
  private int lny;
  // Player graphics variables
  private int px, py, pw, ph;
  // Player movement variables
  private int vX, vY;
  private int XSPEED = 8;
  private boolean left, right, throttle, moving;
  private double YSPEED = 0.0;
  // Timer
  private Timer t;
  private Timer s;

  public PanelSC(int w, int h) {
    this.w = w;
    this.h = h;
    this.setPreferredSize(new Dimension(w, h));
    this.setBackground(Color.blue);

    // Physiscs variables
    moving = false;
    // Road line variables
    lny = -35;
    vY = 0;
    // Player variables
    vX = 0;
    pw = 200;
    ph = 75;
    px = 300;
    py = 325;
    // Obstacle variables

    this.addKeyListener(new KL());
    this.setFocusable(true);

    t = new Timer(20, new AL());
    t.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(new Font("Arial", Font.PLAIN, 15));
    g.setColor(Color.white);
    g.drawString("v0.00.1", 5, 15); // UPDATE VERSION WHEN MODIFYING
    g.setFont(new Font("Arial", Font.ITALIC, 25));
    g.drawString(new DecimalFormat("#000.00#").format(YSPEED * 5) + " MPH", w - 150, 25);
    // ground
    g.setColor(Color.green);
    g.fillRect(0, 225, w, 225);
    // road
    g.setColor(Color.darkGray);
    int[] rxp = { 200, 600, 700, 100 };
    int[] ryp = { 225, 225, 450, 450 };
    g.fillPolygon(rxp, ryp, rxp.length);
    // lines
    for (int i = 0; i < 10; i++) {
      g.setColor(Color.white);
      g.fillRect(390, lny + 50 * i, 20, 35);
    }
    // line cover
    g.setColor(Color.blue);
    g.fillRect(390, 0, 20, 225);

    // Player
    new Car().drawRed(g, px, py, pw, ph);
    // Obstacle 1

  }

  public class AL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (lny > 240)
        lny = 0;
      // System.out.println(lny);
      /*
       * else if (lny < 195)
       * lny = 225;
       */

      update();
    }
  }

  public void update() {
    vX = 0;
    vY = 0;
    vY = (int) YSPEED;

    moving = YSPEED != 0;

    if (throttle) {
      YSPEED += 0.05;
      if (YSPEED >= 45) {
        YSPEED = 45;
      }
    } else {
      if (YSPEED > 0) {
        YSPEED -= 0.02;
      } else {
        YSPEED = 0;
      }
    }
    if (moving) {
      if (left)
        vX = -XSPEED;
      if (right)
        vX = XSPEED;
    }
    px += vX;
    lny += vY;

    // System.out.println(YSPEED);

    repaint();
  }

  public class KL implements KeyListener {
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_W) {
        throttle = true;
        moving = true;
      }
      if (moving && e.getKeyCode() == KeyEvent.VK_A)
        left = true;
      if (moving && e.getKeyCode() == KeyEvent.VK_D)
        right = true;
    }

    public void keyReleased(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_W)
        throttle = false;
      if (e.getKeyCode() == KeyEvent.VK_A)
        left = false;
      if (e.getKeyCode() == KeyEvent.VK_D)
        right = false;
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        System.exit(0);
    }

    public void keyTyped(KeyEvent e) {
    }
  }
}
