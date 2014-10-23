package barChart;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChartPanel extends JPanel {

	private double[] values;

	private String[] names;

	private String title;

	public ChartPanel(double[] v, String[] n, String t) {

		// Bubblesort values and sort names to correspond
		double holdValue;
		String holdName;
		Boolean notSorted = true;

		while (notSorted) {

			notSorted = false;

			for (int i = 0; i < v.length - 1; i++) {

				if (v[i + 1] > v[i]) {
					holdValue = v[i];
					holdName = n[i];
					v[i] = v[i + 1];
					n[i] = n[i + 1];
					v[i + 1] = holdValue;
					n[i + 1] = holdName;

					notSorted = true;
				}
			}
		}

		values = v;
		names = n;
		title = t;
	}

	private void drawBarsAxisLabelsandTitle(Graphics g) {
		// TODO Auto-generated method stub

		int maxBarHeight = (int) (getSize().height * 0.8);
		int titleSpaceHeight = (int) (getSize().height * 0.1);
		int labelSpaceHeight = (int) (getSize().height * 0.1);
		int barXSpacing = (int) (getSize().width * 0.05);
		int barWidth = (int) (getSize().width * 0.22);
		int originX = (int) (getSize().width * 0.05);
		int originY = titleSpaceHeight + maxBarHeight;

		int horAxisYCoord = (int) (getSize().height * 0.05);
		int[] rectXCoords = { originX + barXSpacing,
				originX + 2 * barXSpacing + barWidth,
				originX + 3 * barXSpacing + 2 * barWidth };

		int barHeight;

		// draw bars

		for (int i = 0; i < values.length; i++) {
			barHeight = (int) (maxBarHeight * (values[i] / values[0]));
			horAxisYCoord = originY - barHeight;
			switch (i) {
			case 0:
				g.setColor(Color.BLUE);
				break;
			case 1:
				g.setColor(Color.RED);
				break;
			case 2:
				g.setColor(Color.GREEN);
				break;

			default:
				break;
			}
			g.fillRect(rectXCoords[i], horAxisYCoord, barWidth,
					(int) ((values[i] / values[0]) * getSize().height * 0.8));
			g.setColor(Color.black);
		}

		// draw x-axis
		g.drawLine(originX, originY, originX + (3 * (barWidth + barXSpacing)),
				originY);
		// draw y-axis
		g.drawLine(originX, originY, originX,
				originY - maxBarHeight);
		
		//draw labels
		for (int i = 0; i < names.length; i++) {
			g.drawString(names[i], rectXCoords[i], (int) (maxBarHeight+titleSpaceHeight+(labelSpaceHeight*0.8)));
		}
		
		//draw title
		g.drawString(title, (int) (0.45*getWidth()), (int) (titleSpaceHeight*0.8));

	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawBarsAxisLabelsandTitle(g);

	}

}
