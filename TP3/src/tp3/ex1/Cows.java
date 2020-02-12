package tp3.ex1;

public class Cows implements Comparable<Cows> {
	int gallons;
	int deadline;
	
	public Cows(int gallons, int deadline) {
		this.gallons = gallons;
		this.deadline = deadline;
	}

	public int compareTo(Cows cow) {
		if(this.deadline < cow.deadline) {
			return 1;
		}
		if((this.deadline == cow.deadline)&&(this.gallons < cow.gallons)) {
			return 1;
		}
		if((this.deadline == cow.deadline)&&(this.gallons == cow.gallons)) {
			return 0;
		}
		return -1;
	}
	
	public String toString() {
		return "Gallons : " + gallons + ", Deadline : " + deadline;
	}
}
