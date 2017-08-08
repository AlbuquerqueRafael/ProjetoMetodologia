package insertion;

public class InsertionSort {
	
	public void insertionSort(double[] array) {
		for (int i = 1; i < array.length; i++){
			double key = array[i];
			int j = i;
			
			while ((j > 0) && (array[j-1] > key)){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = key;
		}

	}
}
