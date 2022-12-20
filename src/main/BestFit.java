package main;

import java.util.ArrayList;
import java.util.Scanner;

public class BestFit implements IAlgorithm{

	@Override
	public void run(ArrayList<Partition> partitions, ArrayList<Process> processList) {
		// TODO Auto-generated method stub
		boolean status = false;
		ArrayList<Process> unusedProcess = new ArrayList<>();
		
		
		for(Process process: processList) {
			status = false;
			int min=Integer.MAX_VALUE;
			int index=0;
			for(Partition partition: partitions) {
				if(partition.size>= process.size && partition.process == null) {
					if(partition.size<min) {
						min = partition.size;
						index=partitions.indexOf(partition);
					}	
					
					status = true;
				}
				

			}
			if(min!=Integer.MAX_VALUE)
				partitions.get(index).process= process;
			if(partitions.get(index).size-process.size>0) {
				partitions = updatePartitions(partitions, index, process.size);
			}
			if(!status) {
				System.out.println(process.name+" cannot be allocated");
				unusedProcess.add(process);
			}
		}
		
		for(Partition partition: partitions) {
			if(partition.process==null) {
				System.out.println(partition.name+"("+partition.size+")kb -> External fragment");
			}
			else {
				System.out.println(partition.name+"("+partition.process.size+")kb -> "+partition.process.name);
			}
		}
		
		System.out.println("Do you want to compact? 1.yes 2.no");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int option = Integer.valueOf(input);
		if(option == 1) {
			compact(partitions, unusedProcess);
		}
		
	}
	public ArrayList<Partition> updatePartitions(ArrayList<Partition> partitions, int index, int processSize) {
		ArrayList<Partition> newPartitions = new ArrayList<>();
		for(int i=0; i<partitions.size();i++) {
			newPartitions.add(partitions.get(i));
			if(i==index) {
				newPartitions.add(new Partition(("Partition"+partitions.size()), partitions.get(i).size - processSize, null));
			}
		}
		return newPartitions;
		
	}

	@Override
	public void compact(ArrayList<Partition> partitions, ArrayList<Process> processList) {
		// TODO Auto-generated method stub
		Partition newPartition = new Partition(("Partition"+partitions.size()), 0, null);
		ArrayList<Partition> compactPartitions = new ArrayList<>();
		for(Partition partition: partitions) {
			if(partition.process==null) {
				newPartition.size += partition.size;
			}
			else
				compactPartitions.add(partition);
		}
		
		compactPartitions.add(newPartition);
		
		
		
		for(Process process: processList) {
//			status = false;
			int min=Integer.MAX_VALUE;
			int index=0;
			for(Partition partition: compactPartitions) {
				if(partition.size>= process.size && partition.process == null) {
					if(partition.size<min) {
						min = partition.size;
						index=compactPartitions.indexOf(partition);
					}	
					
//					status = true;
				}
				

			}
			if(min!=Integer.MAX_VALUE)
				compactPartitions.get(index).process= process;
			if(compactPartitions.get(index).size-process.size>0) {
				compactPartitions = updatePartitions(compactPartitions, index, process.size);
			}
//			if(!status) {
//				System.out.println(process.name+" cannot be allocated");
//				unusedProcess.add(process);
//			}
		}
		
		for(Partition partition: compactPartitions) {
			if(partition.process==null) {
				System.out.println(partition.name+"("+partition.size+")kb -> External fragment");
			}
			else {
				System.out.println(partition.name+"("+partition.process.size+")kb -> "+partition.process.name);
			}
		}
	}


}
