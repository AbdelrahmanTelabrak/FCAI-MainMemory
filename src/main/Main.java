package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		IAlgorithm algo ;
		ArrayList<Partition> partitions = new ArrayList<>();
		
		
		System.out.print("Enter number of partition: ");
		int no_of_partitions = in.nextInt();
		for(int i=0;i<no_of_partitions;i++) {
			System.out.print("Enter Partition size: ");
			int  s = in.nextInt();
			
			partitions.add(new Partition("Partition"+i, s, null));
		}
		
		ArrayList<Process> processList = new ArrayList<>();
		System.out.print("Enter number of process: ");
		int no_of_processes = in.nextInt();
		
		for(int i=0;i<no_of_processes;i++) {
			System.out.print("Process name and its size: ");
			String name = str.nextLine();
			int s= in.nextInt();
			processList.add(new Process(name, s));
		}
		

		System.out.println("Select the policy you want to apply:");
		System.out.println("1. First fit");
		System.out.println("1. Worst fit");
		System.out.println("1. Best fit");
		System.out.print("option:");
		int option= in.nextInt();
		if(option==1) {
			algo = new FirstFit();
			algo.run(partitions, processList);
		}else if(option==2) {
			algo = new WorstFit();
			algo.run(partitions, processList);
		}else if(option==3) {
			algo = new BestFit();
			algo.run(partitions, processList);
		}
	}
	
	
}
