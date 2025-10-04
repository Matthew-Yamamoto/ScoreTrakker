//This clsss is a Student object that has a name and a score 

public class Student implements Comparable<Student>{
	private String name = null;
	private int score = 0;
	
	//This is the constuctor to initialize the name and score for this student
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	//compares the score and returns 1 if its higher and -1 if lower
	@Override
	public int compareTo(Student o) {
		if(score < o.score) {
			return 1;
		}
		return -1;
	}
	
	//name score format for printing the student
	@Override
	public String toString() {
		return (name + " " + score);
	}
}

