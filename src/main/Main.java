package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		IAlgorithm algo = new FirstFit();
		ArrayList<Partition> partitions = new ArrayList<>();
		partitions.add(new Partition("Partition0", 90, null));
		partitions.add(new Partition("Partition1", 20, null));
		partitions.add(new Partition("Partition2", 5, null));
		partitions.add(new Partition("Partition3", 30, null));
		partitions.add(new Partition("Partition4", 120, null));
		partitions.add(new Partition("Partition5", 80, null));
		
		ArrayList<Process> processList = new ArrayList<>();
		
		processList.add(new Process("P1", 15));
		processList.add(new Process("P2", 90));
		processList.add(new Process("P3", 30));
		processList.add(new Process("P4", 100));

		algo.run(partitions, processList);
	}
	
	
}
