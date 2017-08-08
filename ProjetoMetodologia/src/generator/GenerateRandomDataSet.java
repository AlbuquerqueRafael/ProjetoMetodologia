package generator;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomDataSet {
	private double[] series;
	private int length;
	private Random rand;
	
	public GenerateRandomDataSet(int length) {
		this.length = length;
	}
	
	public double[] generateRandomSetSmallVariation (int variation) {
		series = new double[length];
		rand = new Random();
		
		for(int i = 0; i < length; i++) {
			series[i] = rand.nextInt(variation) + 1;
		}
		
		return series;
	}
	
	public double[] generateRandomSetBigVariation (int start, int end) {
		series = new double[length];
		rand = new Random();
		double result;
		
		for(int i = 0; i < length; i++) {
			result = randomInRange(start, end, rand);
			series[i] = result;
		}
		
		return series;
	}
	
	public double[] generateAlmostSorted () {
		series = new double[length];
		rand = new Random();
		double result;

		for(int i = 0; i < length; i++) {
			result = rand.nextInt(100) + 1;
			series[i] = result;
		}
		
		Arrays.sort(series);
		int init = rand.nextInt((int) Math.floor(length - 0.11 * length));
		
		int end = (10 * length + 100 * init) / 100;
		
		for(int i = init; i < end; i++) {
			result = rand.nextInt(100) + 1;
			series[i] = result;
		}

		return series;
	}
	
	private double randomInRange(double min, double max, Random random) {
	  double range = max - min;
	  double scaled = random.nextDouble() * range;
	  double shifted = scaled + min;
	  return shifted; 
	} 
}
