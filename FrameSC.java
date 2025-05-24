package SpeedChaser;
import javax.swing.JFrame;
public class FrameSC {
	public static void main(String[] args) {
		int w = 800;
		int h = 450;
		JFrame frame = new JFrame("SPEED CHASER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PanelSC(w,h));
		frame.pack();
		frame.setVisible(true);
	}
}

//Acceleration Equation: (a*x)/(x+1)