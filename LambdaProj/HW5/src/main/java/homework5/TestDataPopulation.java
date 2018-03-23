package homework5;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TestDataPopulation {

	public static void main(String[] args) throws IOException {
		DataPopulation loc = new DataPopulation();
		loc.populateDataList(loc.deafultPath);

		loc.printList();
		
		String path = "D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework5\\Data.txt";
		boolean append_to_file = false;
		FileWriter write = new FileWriter( path , append_to_file);
		PrintWriter print_line = new PrintWriter( write );
		
		
		long nrOfDistinctDays = 0;
		nrOfDistinctDays = loc.monitoredData.stream().map(c ->c.getStartTime().toLocalDate().getDayOfYear()).distinct().count();
		
		System.out.println("nrOfDistinctDays = " + nrOfDistinctDays);
		
		print_line.printf("%s" + "%n", "nrOfDistinctDays = " + nrOfDistinctDays);
		
		Map<String, Long> actionOccur = loc.monitoredData.stream().collect(Collectors.groupingBy(c ->c.getActivityLabel(), Collectors.counting()));
		
//		actionOccur.forEach(System.out::println);

/////////		actionOccur.entrySet().stream().forEach(System.out::println);
	//	actionOccur.entrySet().stream().forEach(print_line.printf);
//		Files.write(Paths.get("D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework5\\Data.txt"), actionOccur);
		
		for (Map.Entry<String, Long> entry : actionOccur.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
			print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
		}
		
//        Iterator<Entry<Object, Long>> iter = actionOccur.entrySet().iterator();
//        while (iter.hasNext()) {
//    		StringBuilder sb = new StringBuilder();
//            Entry<Object, Long> entry = iter.next();
//            sb.append(entry.getKey());
//            sb.append('=').append('"');
//            sb.append(entry.getValue());
//            sb.append('"');
//            if (iter.hasNext()) {
//                sb.append(',').append(' ');
//            }
//            System.out.println(sb.toString());
//        }
		
      Map<Object, Map<Object, Long>> actionOccurPerDay = 
		loc.monitoredData.stream().collect(Collectors.groupingBy(c->c.getStartTime().toLocalDate().getDayOfYear(), Collectors.groupingBy(c ->c.getActivityLabel(), Collectors.counting())));
//		(Collectors.groupingBy(c ->c.getStartTime().toLocalDate().getDayOfYear(), (c ->c.getActivityLabel()), Collectors.counting());

	////////	actionOccurPerDay.entrySet().stream().forEach(System.out::println);

		for (Map.Entry<Object, Map<Object, Long>> entry : actionOccurPerDay.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
			print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
		}
		
//		Duration dur = Duration.between(loc.monitoredData.get(0).getStartTime(), loc.monitoredData.get(0).getEndTime());
//		System.out.println(dur.toHours() + ":" + (dur.toMinutes()-dur.toHours()*60) + ":" + (dur.getSeconds() - dur.toMinutes()*60));
//		dur = dur.plus(dur);
//		System.out.println(dur.toHours() + ":" + (dur.toMinutes()-dur.toHours()*60) + ":" + (dur.getSeconds() - dur.toMinutes()*60));

		Map<String, Long> totalDur = loc.monitoredData.stream().collect(Collectors.groupingBy(c->c.getActivityLabel(), Collectors.summingLong(d->d.getDuration().toMillis()/1000)));
//		totalDur = loc.monitoredData.stream().collect(toMap(MonitoredData::getActivity, MonitoredData::getDuration, Duration::plus));
		//////////totalDur = loc.monitoredData.stream().collect(Collectors.groupingBy(c->c));
		
		Map<String, Long> filteredTotalDur = (Map<String, Long>) totalDur.entrySet().stream().filter(map -> map.getValue()>36000).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
//		Map<String, Duration> totalDur;
//		for (MonitoredData m: loc.monitoredData) {
//			totalDur.merge(m.getActivityLabel(), m.getDuration(), Duration::plus);
//		}
		
		filteredTotalDur.entrySet().stream().forEach(System.out::println);
		for (Map.Entry<String, Long> entry : filteredTotalDur.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
			print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
		}
		
//		Map<String, Long> shortActions = loc.monitoredData.stream().collect(Collectors.groupingBy(c->c.getActivityLabel(), Collectors.summingLong(d->d.getDuration().toMillis()/1000)));

//		Map<String, Long> actionOccur = loc.monitoredData.stream().collect(Collectors.groupingBy(c ->c.getActivityLabel(), Collectors.counting()));

//		Map<String, Long> filteredActionOccur = loc.monitoredData.stream().collect(Collectors.groupingBy(c ->c.getActivityLabel(), Collectors.counting()));
		
	//	Map<String, Long> filteredActionOccur2 = loc.monitoredData.stream().collect(Collectors.groupingBy(c ->c.getActivityLabel(), Collectors.mapping(, MonitoredData::getDuration)));
	//	filteredActionOccur = filteredActionOccur.entrySet().stream().filter(c->c.getValue())
		Map<String, Long> shortActionOccur = loc.monitoredData.stream().filter(c->c.getDuration().toMillis()/1000<300).collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
	 
//		for (Map.Entry<String, Long> entry : actionOccur.entrySet()) {
//		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
//			//print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
//		}
//		System.out.println();
//		
//	//	shortActionOccur.entrySet().stream().forEach(System.out::println);
//		for (Entry<String, Long> entry : shortActionOccur.entrySet()) {
//		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
//			print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
//		}   
//		System.out.println();
		
		Map<String, Float> actionDurPercent = new HashMap<String, Float>();
		for (Entry<String, Long> entry1 : actionOccur.entrySet()) {
			for (Entry<String, Long> entry2 : shortActionOccur.entrySet()) {
			    if(entry1.getKey() == entry2.getKey())
			    {

					//System.out.println("putting" + entry2.getKey());
			    	actionDurPercent.put(entry2.getKey(), (float) (entry2.getValue().floatValue()/entry1.getValue().floatValue()));
			    }
			}  
		}   
		
		List<String> shortActions = actionDurPercent.entrySet().stream().filter(c->c.getValue() >= 0.9).map(x->x.getKey()).collect(Collectors.toList());
		
//	    Map<String, Double> shortActionsPercent = null ;//= loc.monitoredData.stream().collect(Collectors.groupingBy(MonitoredData::getActivityLabel, 
	    		//Collectors.mapping(MonitoredData::getDuration, Collectors. (d->{ if(d.getDuration().toMillis() < 300000) return 1; else return 0;}))));
	//    actionDurPercent.entrySet().stream().forEach(System.out::println);
//		for (Entry<String, Float> entry : actionDurPercent.entrySet()) {
//		    System.out.println(entry.getKey() + " = " + entry.getValue().toString());
//			print_line.printf("%s" + "%n", entry.getKey() + " = " + entry.getValue().toString());
//		}     		
		
		for (String activity : shortActions) {
		    System.out.println(activity);
			print_line.printf("%s" + "%n", activity);
		}             		
//	    Collectors.averagingLong(d->{ if(d.getDuration().toMillis() < 300000)})
	                                //Collectors.mapping(Job::getSuccess, Collectors.averagingDouble(success -> {
	                                  //  return "YES".equals(success) ? 1 : 0;
	                                //}))));
		
		
		print_line.close();
        
	}

}
