
public class Disk implements Comparable<Disk>{
	
	private int radius;
	
	public Disk(int radius) {
		this.radius = radius;
	}

	@Override
	public int compareTo(Disk disk) {
		if (this.radius > disk.radius) {
			return 1;
		}
		if (this.radius == disk.radius) {
			return 0;
		}
		return -1;
	}
	
	public int getRadius() {
		return radius;
	}

}
