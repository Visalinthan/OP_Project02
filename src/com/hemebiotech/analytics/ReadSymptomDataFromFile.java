package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}


	/**
	 * This method getSymptoms() return a arraylist of all symptoms line by line with the duplicate
	 * its execute when filepath contain something
	 */
	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * countSymptoms is a method public
	 * @param nbSymptom contain a list of Symptom
	 * @return a Map with the name of symptom and the number of symptoms
	 */
	@Override
	public Map<String,Integer> countSymptoms(List<String> nbSymptom) {
		Map<String,Integer> myMap = new HashMap<>();
		for(int i = 0 ; i < nbSymptom.size(); i++){
			String symptom = nbSymptom.get(i);
			if(myMap.containsKey(symptom)){
				myMap.put(symptom,myMap.get(symptom)+1);
			}else {
				myMap.put(symptom,1);
			}
		}
		return myMap;
	}

	/**
	 * writerSymptoms is a method public which write the result of MyMap in file result.out
	 * @param myMap contain a map with key= name of symptom and values = number of symptom
	 * @throws IOException
	 */
	@Override
	public void writerSymptoms(Map<String, Integer> myMap) throws IOException {
		FileWriter writer = new FileWriter ("result.out");

		for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
			writer.write(entry.getKey() +'='+ entry.getValue() + "\n");
			System.out.println(entry.getKey() +'='+ entry.getValue());
		}
		writer.close();
	}

}
