package homework5;

import java.util.List;

import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DataPopulation {
	public List<MonitoredData> monitoredData = new ArrayList<MonitoredData>();
	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String deafultPath = "D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework5\\Activities.txt";
	
	/**
	 * @param path
	 * @return an int containing the nr of lines of text found in text file under "path"
	 * @throws IOException
	 */
	int readLines(String path) throws IOException
	{
		int nrOfLines = 0;

		FileReader fr = new FileReader(path);
		BufferedReader br =  new BufferedReader(fr);
		
		@SuppressWarnings("unused")
		String line;
		while((line = br.readLine()) != null)
		{
			nrOfLines++;
		}
		
		br.close();
		
		return nrOfLines;
	}
	
	/**
	 * @param path
	 * @return an array of String containing lines of text data found in the text file under "path"
	 * @throws IOException
	 */
	public String[] readFile(String path) throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader =  new BufferedReader(fr);
		
		int nrOfLines = readLines(path);
		String[] textData = new String[nrOfLines];
		
		for(int i = 0; i < nrOfLines; i++)
		{
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		return textData;
	}
	
	/**
	 * @param dataLine
	 * @return a MonitoredData object containing the data from the param "dataLine"
	 */
	public MonitoredData textToMD(String dataLine)
	{
		LocalDateTime startTime;
		LocalDateTime endTime;
		String activityLabel;
		MonitoredData local = null;
		
		String[] parts = dataLine.split("\\s{2,}");

		startTime = LocalDateTime.parse(parts[0], format);
		endTime = LocalDateTime.parse(parts[1], format);
		activityLabel = parts[2].trim();
		local = new MonitoredData(startTime, endTime, activityLabel);

		return local;
	}
	
	/**
	 * @param path
	 * @return an integer which is equal to the number of rows added to the MonitoredData List, or -1 in case the text file given in path is empty or an error happened
	 */
	public int populateDataList(String path)
	{
		int nrOfLines = 0;
		try {
			nrOfLines = readLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] textData = null;
		try {
			textData = readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if((textData == null) || (nrOfLines == 0))
		{
			System.out.println("ERROR: textData or nrOfLines is null");
			return -1;
		}
		
		int nrAdded = 0;
		for(int i = 0; i < nrOfLines; i++)
		{
			MonitoredData loc = textToMD(textData[i]);
			monitoredData.add(loc);
			nrAdded++;
		}
		
		return nrAdded;
	}

	public void printList()
	{
		int size = this.monitoredData.size();
		for(int i = 0; i < size; i++)
		{
			System.out.println(this.monitoredData.get(i).toString());
		}
	}
}