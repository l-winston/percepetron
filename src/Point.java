import java.awt.Color;
import java.util.Random;
import java.util.function.Function;

public class Point {
	static Random rand = new Random();
	static Function<Double, Double> funct = x -> x;
	static Function<Double, Double> inv = x -> x;

	static int diameter = 10;

	double x;
	double y;
	int label;

	public Point() {
		x = rand.nextDouble() * Main.X;
		y = rand.nextDouble() * Main.Y;
		double x1 = funct.apply(x);
		// System.out.println((int) x + " " + y + " " + (int) x1);
		if (x1 > y) {
			label = 1;
		} else {
			label = -1;
		}
	}

	public void draw(Color c) {
		Main.g2d.setColor(c);
		if (label == 1)
			Main.g2d.drawOval((int) x, (int) y, diameter, diameter);
		else if (label == -1)
			Main.g2d.fillOval((int) x, (int) y, diameter, diameter);


	}
}
