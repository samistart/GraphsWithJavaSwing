package radargraph;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Controller {
	public static void main(String[] args) throws Exception {
	//run asynchronously
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			createAndShowGUI();
		}
	});
		
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(640, 480));
		frame.add(new RadarGraph());
		frame.pack();
		frame.setVisible(true);
	}

}
