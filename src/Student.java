import java.util.*;

public class Student implements Comparable<Student>{

	private String name = null;
	private int score = 0;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student o) {
		if(score > o.score) {
			return 1;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return (name + " " + score);
	}
}
