package packet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		ArrayList<String> gradovi = readFile();
		writeFile(gradovi);
	}
	
	private static void writeFile(ArrayList<String> cities)
	{
		String fileName = "serbia_cities.txt";
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < cities.size(); i++)
			{
				pw.println(cities.get(i));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static ArrayList<String> readFile()
	{
		ArrayList<String> cities = new ArrayList<String>();
		String fileName = "cities.txt";
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				String data[] = line.split("\\s+");
				cities.add(data[0]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cities;
	}
}
