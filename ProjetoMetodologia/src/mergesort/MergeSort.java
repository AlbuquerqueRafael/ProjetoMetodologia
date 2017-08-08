package mergesort;

import java.util.Arrays;

public class MergeSort {
	

	public void mergeSort(double[] array) {
		double[] esquerda;
		double[] direita;
		double[] completo;
		
		if(array.length>1){

			esquerda = Arrays.copyOfRange(array, 0, array.length/2);
			direita = Arrays.copyOfRange(array, array.length/2, array.length);

			mergeSort(esquerda);
			mergeSort(direita);
			completo = merge(esquerda,direita);

			for(int i=0; i< completo.length; i++){
				array[i]=completo[i];
			}
		}

	}
	
	private double[] merge(double[] array1, double[] array2) {

		double[] result = null;
		result = new double[array1.length+array2.length];
		int index = 0;
		int i = 0;
		int j = 0;

		while(array1.length > i && array2.length>j){
			if(array1[i]<=array2[j]){
				result[index]=array1[i];
				index++;
				i++;			
			}else{
				result[index]=array2[j];
				index++;
				j++;				
			}
		}

		if(array1.length>i){
			while(array1.length>i){
				result[index]=array1[i];
				index++;
				i++;
			}
		}else if (array2.length>j){
			while(array2.length>j){
				result[index]=array2[j];
				index++;
				j++;
			}
		}

		return result;
	}

}
