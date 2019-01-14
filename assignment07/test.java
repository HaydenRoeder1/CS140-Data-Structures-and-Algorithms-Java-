package assignment07;
import java.util.ArrayList;
import java.util.List;

import assignment08.Question3_Textbook;
import assignment08.Question3_Typo;

import java.util.Arrays;
public class test {

	public static void main(String[] args) {
		System.out.println(SubstringGenerator.subStrings1("rum"));
		System.out.println(SubSetGenerator.subSet("rum"));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		System.out.println(Question3_Typo.windowSubLists(list));
		System.out.println(Question3_Textbook.subLists(list));
	}

}
