//This class is the scoretrakker class where we load data files and print all of students and their scores


import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	
	private String[] files = {"scores.txt", "badscores.txt", "nofile.txt" };
	
	//Loads the given file and reads throws an error if the file doesnt exist
	//adds all the students in the file to an arrayList
	public void loadDataFile(String file) throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			String score = in.nextLine();
			
			try {
				int intScore = Integer.parseInt(score);
				
				students.add(new Student(name,intScore));
				
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + name + " not a valid score: " + score);
				
			}
			
		}
		in.close();
	}
	
	// prints all the students in order based on their score
	public void printInOrder() {
		System.out.println("Student Score List");
		Collections.sort(students);
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
	
	//takes the array of files and calls loadDataFile on each file
	public void processFiles() {
		for (int i = 0; i < files.length; i++) {
			String file = files[i];
			try {
				loadDataFile(file);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Cant open file: " + file);
			}
			students.clear();
		}
		
	}
	
	//main function to make a scoreTrakker object and call processfiles on it.
	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}
