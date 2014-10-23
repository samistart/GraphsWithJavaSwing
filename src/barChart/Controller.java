package barChart;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Controller {

	public static void createAndShowGUI() {

		double[] values = new double[3];

		String[] names = new String[3];
		String title = "Title";

		values[0] = 1;
		names[0] = "Item 1";

		values[1] = 2;
		names[1] = "Item 2";

		values[2] = 4;
		names[2] = "Item 3";

		JFrame frame = new JFrame();
		frame.setSize(400, 300);

		frame.getContentPane().add(new ChartPanel(values, names, title));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
