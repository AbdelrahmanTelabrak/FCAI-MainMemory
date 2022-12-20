package main;

public class Partition {

	public String name;
	public int size;
	public Process process;
	
	public Partition(String name, int size, Process process) {
		super();
		this.name = name;
		this.size = size;
		this.process = process;
	}

	@Override
	public String toString() {
		return "Partition [name=" + name + ", size=" + size + ", processName=" + process.toString() + "]";
	}
	
	
}
