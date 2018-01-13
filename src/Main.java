import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.*;

public class Main {
	public static JFrame frame;
	public static BufferedImage image;
	public static Graphics2D g2d;
	public static final int X = 500;
	public static final int Y = 500;

	public static void main(String[] args) {
		// frame setup
		initFrame();

		// create percepetron
		Percepetron p = new Percepetron();
		
		int epochs = 100;
		for (int j = 0; j < epochs; j++) {
			for (int i = 0; i < 10000; i++) {
				// create random point
				Point point = new Point();

				// train the percepetron with the point
				p.train(point);
			}
		}
		int correct = 0;
		int numTests = 1000;
		for (int i = 0; i < numTests; i++) {
			// create random point
			Point point = new Point();

			// train the percepetron with the point
			int out = p.train(point);

			// if the output is correct draw it green, else draw red
			if (out == point.label) {
				point.draw(Color.green);
				System.out.println(correct++ + 1 + "\t/\t" + numTests);
			} else {
				point.draw(Color.red);
			}
		}

		// show the weights after training
		System.out.println(Arrays.toString(p.weights));
		System.out.println(Arrays.toString(p.biases));
	}

	// frame setup
	private static void initFrame() {
		frame = new JFrame("frame");
		image = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);
		g2d = image.createGraphics();
		g2d.setBackground(Color.white);
		g2d.fillRect(0, 0, X, Y);
		g2d.setStroke(new BasicStroke(1));

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));

		frame.pack();

		g2d.setColor(Color.black);
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				if ((int) Math.round(Point.funct.apply(i * 1.0)) == j) {
					image.setRGB(i, j, Color.black.getRGB());
				}
			}
		}
	}
}
