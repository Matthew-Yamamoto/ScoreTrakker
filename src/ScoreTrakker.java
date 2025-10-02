import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;




public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void loadDataFile(String file) throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			String score = in.nextLine();
			int intScore = Integer.parseInt(score);
			
			students.add(new Student(name,intScore));
		}

	}
	
	public void printInOrder() {
		for(Student student : students) {
			System.out.println(student);
			student.compareTo(student);
		}
	}
	
	public void processFiles() {
		String file = "scores.txt";
		try {
			loadDataFile(file);
		} catch (FileNotFoundException e) {
			System.out.println("Cant open file: " + file);
		}
		printInOrder();
	}
	
	
	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}
