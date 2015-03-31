package com.mycompany.Theia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;

public class data{

	private Vector<Vector<Double> > m_input;
	private Vector<Vector<Double> > m_label;


	data(String filename){
		//change this later to accept other filetypes
		//but for right now work with .csv	

		loadCSV(filename);

		}

	private void loadCSV(String filename){

		int numInputs = 0;
		int numLabels = 0;
		String line;
		BufferedReader fileReader = null;
		Vector<Double> tempInput = new Vector<Double>();
		Vector<Double> tempLabel = new Vector<Double>();
		m_input = new Vector<Vector<Double> >();
		m_label = new Vector<Vector<Double> >();

		try{
			fileReader = new BufferedReader(new FileReader(filename));
			String header = fileReader.readLine();
			String[] tokens = header.split(",");
			//probably add some error stuff here
			numInputs = Integer.parseInt(tokens[0]);
			numLabels = Integer.parseInt(tokens[1]);

			while((line = fileReader.readLine()) != null){
				tokens = line.split(",");
				tempInput.clear();
				tempLabel.clear();
				for(int i = 0; i < numInputs; i++){
					tempInput.addElement(Double.parseDouble(tokens[i]));				
					}
				for(int i = numInputs; i < (numInputs+numLabels); i++){
					tempLabel.addElement(Double.parseDouble(tokens[i]));				
					}
				m_input.addElement(tempInput);
				m_label.addElement(tempLabel);
				}
			}
		catch(IOException ex){
			System.out.println("Something bad happened\n");
			}

		}

	public void showData(){
		System.out.println("Size of m_input = " + m_input.size());
		for(int i = 0; i < m_input.size(); i++){
			for(int j = 0; j < m_input.get(i).size(); j++){
				System.out.print(m_input.get(i).get(j)+" ");
				}
			for(int j = 0; j < m_label.get(i).size(); j++){
				System.out.print(m_label.get(i).get(j)+" ");
				}
			System.out.println("");
			}
		}

	}


