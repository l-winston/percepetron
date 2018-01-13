import java.awt.Color;
import java.util.Random;
import java.util.function.Function;

public class Point {
	//random for random coordinate generation
	static Random rand = new Random();
	//function used to define the line separating points
	static Function<Double, Double> funct = x -> 2*x;
	
	///TODO: function can only be linear, improve drawing/classification method

	//size of eclipse to be drawn
	static int diameter = 10;

	double x;
	double y;
	int label;

	public Point() {
		// generate random coordinates
		x = rand.nextDouble() * Main.X;
		y = rand.nextDouble() * Main.Y;
		
		double x1 = funct.apply(x);
		
		//generate label
		if (x1 > y) {
			label = 1;
		} else {
			label = -1;
		}
	}

	public void draw(Color c) {
		//draw the point at (x, y) with color c
		Main.g2d.setColor(c);
		if (label == 1)
			Main.g2d.drawOval((int) x, (int) y, diameter, diameter);
		else if (label == -1)
			Main.g2d.fillOval((int) x, (int) y, diameter, diameter);

	}
}
