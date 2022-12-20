package main;

public class Process {
	
	public String name;
	public int size;
	
	public Process(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", size=" + size + "]";
	}
	
	
}
