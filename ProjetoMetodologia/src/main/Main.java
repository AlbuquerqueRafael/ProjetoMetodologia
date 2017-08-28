package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import quicksort.QuickSort;
import shellsort.ShellSort;
import mergesort.MergeSort;
import insertion.InsertionSort;
import generator.GenerateRandomDataSet;
import generator.SaveAndReadFiles;

public class Main {

	public static void main(String[] args) {
		
		String[] algoritmos = {"quick", "merge", "insertion", "shell"}; 
		String[] tipos = {"ordenado", "parcialmente", "desordenado"};
		String[] tamanhos = {"grande", "medio", "pequeno"};
		int repeticoes = 10;
		
		GenerateRandomDataSet randomDataSet = null;
		double[] input = null;
		
		for (int i = 0; i < algoritmos.length; i++) {
			String algo = algoritmos[i];
			File file = new File(algo + ".csv");

			FileWriter fw = null;
			try {
	            fw = new FileWriter(file, true);
	    		BufferedWriter output = new BufferedWriter(fw);
	    		
	            output.append("algoritmo");output.append(',');output.append("tipo");output.append(',');
	            output.append("tamanho");output.append(',');output.append("tempo");output.append('\n');
	            output.flush();output.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for (int j = 0; j < tipos.length; j++) {
				String tipo = tipos[j];
				for (int j2 = 0; j2 < tamanhos.length; j2++) {

					String tamanho = tamanhos[j2];
										
					for (int k = 0; k < repeticoes; k++) {				
						long tempoInicial = 0, tempoFinal = 0;
						
						System.out.println(algo + ", " + tipo + ", " + tamanho + ", " + "repeticao " + k);

						if (tamanho.equals("grande")){
							randomDataSet = new GenerateRandomDataSet(1500000);
							input = randomDataSet.generateAlmostSorted();
						} else if (tamanho.equals("medio")){
							randomDataSet = new GenerateRandomDataSet(50000);
						} else if (tamanho.equals("pequeno")){
							randomDataSet = new GenerateRandomDataSet(100);
						}
						
						
						if (tipo.equals("ordenado")){
							input = randomDataSet.generateOrdered();
						} else if (tipo.equals("parcialmente")){
							input = randomDataSet.generateAlmostSorted();
						} else if (tipo.equals("desordenado")){
							input = randomDataSet.generateNotOrdered();
						}
						
						
						if (algo.equals("insertion")) {
							tempoInicial = System.currentTimeMillis();
							InsertionSort sort = new InsertionSort();
							sort.insertionSort(input);
							tempoFinal = System.currentTimeMillis();
						} else if (algo.equals("merge")) {
							tempoInicial = System.currentTimeMillis();
							MergeSort sort = new MergeSort();
							sort.mergeSort(input);
							tempoFinal = System.currentTimeMillis();
						} else if (algo.equals("quick")) {
							tempoInicial = System.currentTimeMillis();
							QuickSort sort = new QuickSort();
							sort.quicksort(input, 0, 9);
							tempoFinal = System.currentTimeMillis();
						} else if (algo.equals("shell")) {
							tempoInicial = System.currentTimeMillis();
							ShellSort sort = new ShellSort();
							sort.shellSort(input);
							tempoFinal = System.currentTimeMillis();
						}	
						
						SaveAndReadFiles saver = new SaveAndReadFiles();

						saver.saveOutput(file, algo + "sort", tipo, input.length, (tempoFinal - tempoInicial) / 1000d);
												
					}
				}
			}		
		}

		System.out.println("ACABOOOOOOU");

	}

}
