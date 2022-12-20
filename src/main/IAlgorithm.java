package main;

import java.util.ArrayList;

public interface IAlgorithm {

	public void run(ArrayList<Partition> partitions, ArrayList<Process> processList);
	public void compact(ArrayList<Partition> partitions, ArrayList<Process> processList);
}
