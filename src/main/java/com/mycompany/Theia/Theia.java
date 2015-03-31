package com.mycompany.Theia;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;



public class Theia{
	public static void main( String[] args ){
        	System.out.println( "Welcome to Theia" );
		genXORData("xorData.csv", 10);
		data myData = new data("xorData.csv");
		myData.showData();
		}

	public static void genXORData(String filename, int size){

		try{
			FileWriter out = null;
			out = new FileWriter(filename);
			out.append("2,1\n");	//2 input, one output
			Random random = new Random();
			int a, b, c;
			String tempString;
			for(int i = 0; i < size; i++){
				a = random.nextInt(2);
				b = random.nextInt(2);
				c = a^b;
				tempString = a + "," + b + "," + c + "\n";
				out.append(tempString);
				}
			out.close();
			}
		catch(IOException ex){
			System.out.println("something went wrong");
			}

		}

	}
	

