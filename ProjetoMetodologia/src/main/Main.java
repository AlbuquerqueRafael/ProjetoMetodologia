package main;

import quicksort.QuickSort;
import shellsort.ShellSort;
import mergesort.MergeSort;
import insertion.InsertionSort;
import generator.GenerateRandomDataSet;
import generator.SaveAndReadFiles;

public class Main {

	public static void main(String[] args) {
				
		GenerateRandomDataSet randomDataSet = new GenerateRandomDataSet(10000);
		
		String[] outputSet = {"Algoritmo utilizado", "Tipo do dataset", "Tamanho do dataset", "Dataset", "Tempo de resposta"};
		String algoritmo = "quick";
		double[] input = randomDataSet.generateAlmostSorted();
		String inputType = "quase ordenado";
				
		// args.len > 0
		try {
			algoritmo = args[0];
		} catch (Exception e) {}

		// args.len > 1
		try {
			if (args[1].equals("smallv")) {
				input = randomDataSet.generateRandomSetSmallVariation(10);
				inputType = "com range pequeno";
			} else if (args[1].equals("bigv")) {
				input = randomDataSet.generateRandomSetBigVariation(0, 9);
				inputType = "com range grande";
			} else if (args[1].equals("almost")) {
				input = randomDataSet.generateAlmostSorted();
				inputType = "quase ordenado";
			}
		} catch (Exception e) {}

		
		System.out.println("Ordenando com o algoritmo " + algoritmo + "sort");
		System.out.println("Um dataset " + inputType);

		long tempoInicial = 0, tempoFinal = 0;
		
		if (algoritmo.equals("insertion")) {
			tempoInicial = System.currentTimeMillis();
			InsertionSort sort = new InsertionSort();
			sort.insertionSort(input);
			tempoFinal = System.currentTimeMillis();
		} else if (algoritmo.equals("merge")) {
			tempoInicial = System.currentTimeMillis();
			MergeSort sort = new MergeSort();
			sort.mergeSort(input);
			tempoFinal = System.currentTimeMillis();
		} else if (algoritmo.equals("quick")) {
			tempoInicial = System.currentTimeMillis();
			QuickSort sort = new QuickSort();
			sort.quicksort(input, 0, 9);
			tempoFinal = System.currentTimeMillis();
		} else if (algoritmo.equals("shell")) {
			tempoInicial = System.currentTimeMillis();
			ShellSort sort = new ShellSort();
			sort.shellSort(input);
			tempoFinal = System.currentTimeMillis();
		}
		
		String formattedOutput = "";
		
		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				formattedOutput += "[";
			} else if (i != input.length - 1) {
				formattedOutput += input[i] + ", ";
			} else {
				formattedOutput += input[i] + "]";
			}
		}
		
		System.out.println();
		
		SaveAndReadFiles saver = new SaveAndReadFiles();
		
		outputSet[0] += ": " + algoritmo + "sort";
		outputSet[1] += ": " + inputType;
		outputSet[2] += ": " + input.length;
		outputSet[3] += ": " + formattedOutput;
		outputSet[4] += ": " + (tempoFinal - tempoInicial) / 1000d;

		saver.saveOutput(outputSet);
		
	}

}
