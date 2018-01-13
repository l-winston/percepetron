
public class Percepetron {
	// learning rate affects how big each learning step is
	static double learningRate = 10;

	/*
	 * Structure:
	 * 
	 * input 1 (x) O \ --- (out) a number either 1 or -1 representing whether
	 * the point is over or under the line / input 2 (y) O
	 * 
	 */
	double[] weights = new double[2];
	double[] biases = new double[1];

	// random initialization for weights
	public Percepetron() {
		weights[0] = Math.random() - 0.5;
		weights[1] = Math.random() - 0.5;
		biases[0] = Math.random() - 0.5;
	}

	// trains & returns the output given a point
	public int train(Point p) {
		int out = activate(weights[0] * p.x + weights[1] * p.y + biases[0]);
		weights[0] -= learningRate * p.x * (out - p.label);
		weights[1] -= learningRate * p.y * (out - p.label);
		biases[0] -= learningRate * (out - p.label);
		return out;
	}

	// returns the output given a point
	public int test(Point p) {
		return activate(weights[0] * p.x + weights[1] * p.y + biases[0]);
	}

	// takes sign of number, activation function
	private int activate(double d) {
		if (d >= 0) {
			return 1;
		}
		return -1;
	}
}
