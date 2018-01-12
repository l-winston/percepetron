
public class Percepetron {
	static double learningRate = 1;
	
	double[] weights = new double[2];
	
	public Percepetron(){
		weights[0] = Math.random()-0.5;
		weights[1] = Math.random()-0.5;
	}
	
	
	public int train(Point p){
		int out = activate(weights[0]*p.x + weights[1]*p.y);
		weights[0] -= learningRate * p.x * (out - p.label);
		weights[1] -= learningRate * p.y * (out - p.label);
		return out;
	}
	
	public int test(Point p){
		return activate(weights[0]*p.x + weights[1]*p.y);
	}
	
	private int activate(double d){
		if(d >= 0){
			return 1;
		}
		return -1;
	}
}
