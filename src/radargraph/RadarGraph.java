package radargraph;

import java.awt.Color;
import java.awt.Dimension;//use to resolve X and Y to Dimension type
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Method;

import javax.swing.JPanel;

public class RadarGraph extends JPanel {	
	
	double[][] randomNumbers = new double[3][5];
	
	public RadarGraph() {
		setBackground(Color.white);
		populateArray();
	}

	@Override
	public void paintComponent(Graphics g) {
		// clear the screen
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawWeb(g2d);
		System.out.println("redraw \n");
	}

	private void drawWeb(Graphics2D g2d) {
		// TODO Auto-generated method stub
		int centreX = getSize().width / 2;
		int centreY = getSize().height / 2;
		int armLength = (int) (getSize().height * 0.45);// length of an axis
		double angleBetweenArms = (2 * (Math.PI)) / 5;
		// for loop to draw axis

		drawAxis(centreX, centreY, armLength, angleBetweenArms, g2d);

		// make an array to hold random numbers as a basis for the plots
		

		// draw the 5 plots
		plotResultsPolygons(centreX, centreY, armLength, angleBetweenArms,
				randomNumbers, g2d);

		drawAxisLabels(centreX, centreY, armLength, angleBetweenArms, g2d);
	}
	
	public void populateArray() {
		// TODO Auto-generated method stub
		for (int i = 0; i < randomNumbers.length; i++) {
			for (int j = 0; j < randomNumbers[i].length; j++) {
				randomNumbers[i][j] = Math.random();
			}
		}
	}

	private void drawAxis(int centreX, int centreY, int armLength,
			double angleBetweenArms, Graphics2D g2d) {
		for (int i = 0; i < 5; i++) {
			g2d.drawLine(centreX, centreY, (int) (centreX + (armLength * Math
					.sin(i * angleBetweenArms))), (int) (centreY - armLength
					* Math.cos(i * angleBetweenArms)));
		}
	}

	private void plotResults(int centreX, int centreY, int armLength,
			double angleBetweenArms, double[][] randomNumbers, Graphics2D g2d) {
		for (int i = 0; i < randomNumbers.length; i++) {
			for (int j = 0; j < randomNumbers[i].length; j++) {
				int j2 = (j + 1) % randomNumbers[i].length;// number that points
															// to the part of
															// the array that is
															// one higher than
															// the starting
															// point and wraps
															// around to the
															// start after it's
															// finished
				g2d.drawLine(
						(int) (centreX + (randomNumbers[i][j] * armLength * Math
								.sin(j * angleBetweenArms))),
						(int) (centreY - (randomNumbers[i][j] * armLength * Math
								.cos(j * angleBetweenArms))),
						(int) (centreX + (randomNumbers[i][j2] * armLength * Math
								.sin((j2) * angleBetweenArms))),
						(int) (centreY - (randomNumbers[i][j2] * armLength * Math
								.cos((j2) * angleBetweenArms))));

			}
		}
	}

	private void plotResultsPolygons(int centreX, int centreY, int armLength,
			double angleBetweenArms, double[][] randomNumbers, Graphics2D g2d) {

		Polygon[] polygons = { new Polygon(), new Polygon(), new Polygon() };

		for (int i = 0; i < polygons.length; i++) {
			for (int j = 0; j < randomNumbers[i].length; j++) {
				polygons[i]
						.addPoint(
								(int) (centreX + (randomNumbers[i][j]
										* armLength * Math.sin(j
										* angleBetweenArms))),
								(int) (centreY - (randomNumbers[i][j]
										* armLength * Math.cos(j
										* angleBetweenArms))));

				
				Color myColor;
				
				switch (i) {
				case 0:
					myColor = new Color(255, 0, 0, 150);
					break;
				case 1:
					myColor = new Color(0, 255, 0, 150);
					break;
				case 2:
					myColor = new Color(0, 0, 255, 150);
					break;
				default:
					myColor = new Color(0, 0, 0, 150);

					break;
				}
				g2d.setColor(myColor);

				g2d.fillPolygon(polygons[i]);
			}
		}

		// draw all three polygons in the array
		for (int i = 0; i < polygons.length; i++) {
			g2d.drawPolygon(polygons[i]);
		}
	}

	private void drawAxisLabels(int centreX, int centreY, int armLength,
			double angleBetweenArms, Graphics2D g2d) {
		String[] labels = { "availability", "cost", "features",
				"server_requirements", "usability" };
		for (int i = 0; i < labels.length; i++) {
			g2d.drawString(
					labels[i],
					(int) (centreX + (armLength * Math
							.sin(i * angleBetweenArms))),
					(int) (centreY - armLength * Math.cos(i * angleBetweenArms)));

		}
	}

}
