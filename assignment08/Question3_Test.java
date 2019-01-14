package assignment08;
import java.util.ArrayList;

import assignment08.Question3_Textbook;
import assignment08.Question3_Typo;

import java.util.Arrays;
public class Question3_Test{

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		System.out.println(Question3_Typo.windowSubLists(list));
		System.out.println(Question3_Textbook.subLists(list));
	}

}
