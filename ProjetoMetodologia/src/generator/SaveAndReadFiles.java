package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveAndReadFiles {
	
	public void saveOutput(String algoritmo, String inputType, int length, double d) {
		FileWriter fw = null;
		try {
            fw = new FileWriter("output.csv", true);
    		BufferedWriter output = new BufferedWriter(fw);
    		
            output.append(algoritmo);
            output.append(',');
            output.append(inputType);
            output.append(',');
            output.append(""+length);
            output.append(',');
            output.append(""+d);
            output.append('\n');
            output.flush();  
            output.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    
	}
	
	public void saveFile(double[] dataSet) {
		String fileName = "temp.txt";

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter output = new BufferedWriter(fw);
            int size = dataSet.length;
            
            for (int i = 0; i < size; i++) {
            	output.write(dataSet[i]+"");
            	output.newLine();
            }
            
            output.flush();  
            output.close();  
        } catch(Exception e) {
        	System.out.println("erro"); 
            System.out.println(e.getMessage());                
        }
    
	}
	
	
	@SuppressWarnings("resource")
	public double[] readFile(double[] dataSet)  {
		double[] auxSeries = new double[dataSet.length];
		String fileName = "temp.txt";
		String line;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
			if (!reader.ready()) {
				throw new IOException();
			}
			
			int i = 0;
			
			while ((line = reader.readLine())  != null) {
				auxSeries[i++] = Double.parseDouble(line);
			}

			reader.close(); 
		 } catch(Exception e) {
	        System.out.println("erro"); 
	        System.out.println(e.getMessage());                
		 }
		
		return auxSeries;
	            
	}

}
