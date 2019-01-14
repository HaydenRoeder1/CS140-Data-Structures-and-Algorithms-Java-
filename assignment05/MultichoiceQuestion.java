package assignment05;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class MultichoiceQuestion extends Question{
	ArrayList<String> choices = new ArrayList<String>();
	ArrayList<Integer> correctChoices = new ArrayList<Integer>();
	public MultichoiceQuestion(String qText) {
		super(qText, "");
	}
	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct) {
			correctChoices.add(choices.size());
		}
	}
	public void display() {
		// Display the question text
		super.display();
		// Display the answer choices
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i+1) + ": " + choices.get(i));     
		}
	}
	public void presentQuestion() {
		display();
		System.out.print("Your answers (if more than one, separate answers by spaces): ");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		System.out.println(checkAnswer(response));
	}
	public boolean checkAnswer(String response) {
		int correctCounter = 0;
		int wrongCounter = 0;
		Set<Integer> answers = new HashSet<>();
		try(Scanner scan = new Scanner(response)) {
			while(scan.hasNextInt()) {
				int ans = scan.nextInt();
				answers.add(ans);
			}
		}
		for(Integer i : answers) {
			if(correctChoices.contains(i)) {
				correctCounter++;
			}
			else {
				wrongCounter++;
			}
		}
		boolean retVal = false;
		if(correctChoices.size() == correctCounter && wrongCounter == 0) {
			retVal = true;
		}
		if(retVal == false) {
			System.out.println("Correct: " + correctCounter + ", Incorrect: " + wrongCounter);
		}
		return retVal;
	}

}
