package quicksort;

public class QuickSort {
	
	
	public void quicksort(double[] array, int left, int right) {
		if(left < right) {
			int m = partition(array,left,right);
			quicksort(array,left,m-1);
			quicksort(array,m+1,right);
		}
		
	}
	
	private int partition(double[] array, int esquerda, int direita) {
		int index = esquerda-1;
		double pivot = array[direita];
		
		for (int j = esquerda; j < direita; j++) {
			if (array[j] <= pivot ) {
				index += 1;
				swap(array, index, j);
			}
		}
		
		swap(array, index+1, direita);
		return index+1;
	}
	
	private void swap(double[] array, int position, int auxPosition) {
		double auxValue = array[position];
		array[position] = array[auxPosition];
		array[auxPosition] = auxValue;
		
	}
}
