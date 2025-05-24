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

public class PanelSC extends JPanel
{
	private int w, h;
	//Road line graphics variables
	private int lny;
	//Player graphics variables
	private int px,py,pw,ph;
	//Player movement variables
	private int vX,vY;
	private int XSPEED = 8;
	private int YSPEED = 10;
	private boolean left, right,space,moving;
	
	//Timer
	private Timer t;
	private Timer s;

	public PanelSC(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		this.setBackground(Color.blue);
		
		//Physiscs variables
		moving=false;
		//Road line variables
		lny=225;
		vY=0;
		//Player variables
		vX=0;
		pw=200;
		ph=75;
		px=300;
		py=325;
		//Obstacle variables
		
		
		this.addKeyListener(new KL());
		this.setFocusable(true);
		
		t = new Timer(20, new AL());
		t.start();
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		g.setColor(Color.white);
	    g.drawString("v0.00.1", 5, 15); //UPDATE VERSION WHEN MODIFYING 
		//ground
		g.setColor(Color.green);
		g.fillRect(0, 225, w, 225);
		//road
		g.setColor(Color.darkGray);
		int[] rxp= {200,600,700,100};
		int[] ryp= {225,225,450,450};
		g.fillPolygon(rxp, ryp, rxp.length);
		//lines
		for(int i=0;i<6;i++) {
			g.setColor(Color.white);
			g.fillRect(390, lny+50*i, 20, 35);
		}
		g.setColor(Color.blue);
		g.fillRect(390, 0, 20, 225);
		
		//Player
		//wheels
		g.setColor(Color.BLACK);
		g.fillRect(px+5, py+ph, 45, 10);
		g.fillRect(px+pw-50, py+ph, 45, 10);
		//rearviews
		g.setColor(Color.CYAN);
		g.fillOval(px+10, py-12, 24, 12);
		g.fillOval(px+pw-34, py-12, 24, 12);
		g.setColor(new Color(200, 30, 30));
		g.drawOval(px+10, py-12, 24, 12);
		g.drawOval(px+pw-34, py-12, 24, 12);
		//body
		g.fillRect(px, py, pw, ph);
		//roof
		int[] rc1xp = {px+50, px+pw-50, px+pw-25, px+25};
		int[] rc1yp = {py-25, py-25, py, py};
		g.fillPolygon(rc1xp, rc1yp, rc1xp.length);
		//rear window
		g.setColor(Color.CYAN);
		int[] wc1xp = {px+50, px+pw-50, px+pw-30, px+30};
		int[] wc1yp = {py-20, py-20, py, py};
		g.fillPolygon(wc1xp, wc1yp, wc1xp.length);
		g.setColor(Color.BLACK);
		g.drawPolygon(wc1xp, wc1yp, wc1xp.length);
		//tailights
		g.fillRect(px+10, py+10, 180, 25);
		g.setColor(Color.RED);
		g.fillRect(px+10, py+10, 50, 25);
		g.fillRect(px+pw-60, py+10, 50, 25);
		g.setColor(Color.BLACK);
		g.drawRect(px+10, py+10, 180, 25);
		//exhaust
		g.setColor(Color.DARK_GRAY);
		g.fillRect(px+15, py+ph-20, 40, 18);
		g.fillRect(px+pw-55, py+ph-20, 40, 18);
		g.setColor(Color.BLACK);
		g.drawRect(px+15, py+ph-20, 40, 18);
		g.drawRect(px+pw-55, py+ph-20, 40, 18);
		g.fillOval(px+27, py+ph-19, 16, 16);
		g.fillOval(px+pw-43, py+ph-19, 16, 16);
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(px+27, py+ph-19, 16, 16);
		g.drawOval(px+pw-43, py+ph-19, 16, 16);
		//plate
		g.setColor(Color.WHITE);
		g.fillRect(px+(pw/2)-20, py+50, 40, 20);
		g.setColor(Color.BLACK);
		g.drawRect(px+(pw/2)-20, py+50, 40, 20);
		
		//Obstacle 1
		
	}
	
	public class AL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(lny>240)
				lny=190;
			//System.out.println(lny);
			else if(lny<195)
				lny=225;
			
			
			
			update();
		}
	}
	
	public void update() {
		vX = 0;
		vY = 0;
		if(space) 
			vY = YSPEED;
			//YSPEED--;
		if(left) 
		  	vX = -XSPEED;
		if(right) 
		  	vX = XSPEED;			
		
		px+=vX;
		lny+=vY;
		 
		if(moving) {
			
		}
		
		repaint();
	}
	
	public class KL implements KeyListener{
		public void keyPressed(KeyEvent e) {			
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				space = true; 
				moving=true;
		}	
			if(moving&&e.getKeyCode() == KeyEvent.VK_LEFT)
				left = true;
			if(moving&&e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = true;
		}

		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
				space = false; 
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				left = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = false;
		}
		public void keyTyped(KeyEvent e) {}
	}
}
