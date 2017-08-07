package testes;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import quicksort.QuickSort;

public class TestQuick {

	private double[] vetor1;  
	private double[] vetor2; 
	private double[] vetor3; 
	private double[] vetor4; 
	private double[] vetor5; 
	private double[] vetor6; 
	private double[] vetor7; 
	private QuickSort implementation;
	
	@Before
	public void setUp() throws Exception {
		implementation = new QuickSort();
		this.vetor1 = criaVetor1();
		this.vetor2 = criaVetor2();
		this.vetor3 = criaVetor3();
		this.vetor4 = criaVetor4();
		this.vetor5 = criaVetor5();
		this.vetor6 = criaVetor6();
		this.vetor7 = criaVetor7();
	}
	
	// array ordenado de forma decrescente
	private double[] criaVetor1(){
		double[] vetor = new double[20];
		for (int i = vetor.length; i > 0; i--) {
			vetor[vetor.length - i] = i;
		}
		return vetor;
	}
	
	// array com n�meros em posi��es variadas
	private double[] criaVetor2(){
		double[] vetor = {20, 1, 30, 5, 2, 4, 10, 9, 12, 19, 13, 0};
		return vetor;
	}
	
	// array com valores positivos e negativos
	private double[] criaVetor3(){
		double[] vetor = {5, -2, 7, -4, 8, -1, 0, 6, 9, -5, -10, 1};
		return vetor;
	}
	
	// array sem elementos
	private double[] criaVetor4(){
		double[] vetor = {};
		return vetor;
	}
	
	// array com um elemento
	private double[] criaVetor5(){
		double[] vetor = {10};
		return vetor;
	}
	
	// array com n�meros repetidos
	private double[] criaVetor6(){
		double[] vetor = {2, 3, 1, 3, 5, 0, 3, 2, 8, 7};
		return vetor;
	}
	
	// array com todos os valores iguais
	private double[] criaVetor7(){
		double[] vetor = {4, 4, 4, 4, 4, 4, 4, 4};
		return vetor;
	}


	@Test
	public void testQuickSortTC01() {
		double[] copy1 = Arrays.copyOf(vetor1,vetor1.length);
		implementation.quicksort(vetor1,0,vetor1.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor1, 0);
	}
	
	@Test
	public void testQuickSortTC02() {
		double[] copy1 = Arrays.copyOf(vetor2,vetor2.length);
		implementation.quicksort(vetor2,0,vetor2.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor2, 0);
	}
	
	@Test
	public void testQuickSortTC03() {
		double[] copy1 = Arrays.copyOf(vetor3,vetor3.length);
		implementation.quicksort(vetor3,0,vetor3.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor3, 0);
	}
	
	@Test
	public void testQuickSortTC04() {
		double[] copy1 = Arrays.copyOf(vetor4,vetor4.length);
		implementation.quicksort(vetor4,0,vetor4.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor4, 0);
	}
	
	@Test
	public void testQuickSortTC05() {
		double[] copy1 = Arrays.copyOf(vetor5,vetor5.length);
		implementation.quicksort(vetor5,0,vetor5.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor5, 0);
	}
	
	@Test
	public void testQuickSortTC06() {
		double[] copy1 = Arrays.copyOf(vetor6,vetor6.length);
		implementation.quicksort(vetor6,0,vetor6.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor6, 0);
	}
	
	@Test
	public void testQuickSortTC07() {
		double[] copy1 = Arrays.copyOf(vetor7,vetor7.length);
		implementation.quicksort(vetor7,0,vetor7.length-1);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1,vetor7, 0);
	}
	
	@Test
	public void testWithRandomNumbers() {
		
		for (int i = 0; i < 10; i++) {
			double[] array = createArrayRandomNumber();
			double[] copy1 = Arrays.copyOf(array,array.length);
			Arrays.sort(copy1);
			implementation.quicksort(array,0,array.length-1);
			Assert.assertArrayEquals(copy1,array, 0);

		}
		

	}
	
	@Test
	public void testWithRandomNumbers2() {
		
		for (int i = 0; i < 20; i++) {
			double[] array = createArrayRandomNumber2();
			double[] copy1 = Arrays.copyOf(array,array.length);
			Arrays.sort(copy1);
			implementation.quicksort(array,0,array.length-1);			
			Assert.assertArrayEquals(copy1,array, 0);

		}
		

	}
	
	private double[] createArrayRandomNumber () {
		double[] array = new double[1500000];
		Random random = new Random();
		
		for(int i = 0; i < 1500000; i++) {
			array[i] = random.nextDouble();
		}
		
		return array;
	}
	
	private double[] createArrayRandomNumber2() {
		double[] array = new double[1500000];
		Random random = new Random();
		
		for(int i = 0; i < 1500000; i++) {
			array[i] = random.nextInt();
		}
		
		return array;
	}

}
