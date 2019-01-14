package assignment08;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Question3_Typo {
	public static ArrayList<ArrayList<ArrayList<Integer>>> windowSubLists(ArrayList<Integer> list){
		ArrayList<ArrayList<ArrayList<Integer>>> subLists = new ArrayList<>();
		return windowSubListsHelper(list, subLists, 0, list.size());
	}
	public static ArrayList<ArrayList<ArrayList<Integer>>> windowSubListsHelper(ArrayList<Integer> origList, ArrayList<ArrayList<ArrayList<Integer>>> subLists, int beginIndex, int endIndex){
		if(beginIndex == endIndex) {
			ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
			for(int i = 0; i < origList.size(); i++) {
				newList.add(new ArrayList<Integer>(origList.subList(i, i + 1)));
			}
			subLists.add(newList);
			return subLists;
		}
		ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
		for(int i = 0; i < beginIndex; i ++) {
			newList.add(new ArrayList<Integer>(Arrays.asList(subLists.get(0).get(0).get(i))));
		}
		newList.add(new ArrayList<Integer>(origList.subList(beginIndex, endIndex)));
		for(int i = endIndex; i < origList.size(); i ++) {
			newList.add(new ArrayList<Integer>(Arrays.asList(subLists.get(0).get(0).get(i))));
		}
		subLists.add(newList);
		windowSubListsHelper(origList, subLists, beginIndex, endIndex - 1);
		windowSubListsHelper(origList, subLists, beginIndex+1, origList.size());
		ArrayList<ArrayList<ArrayList<Integer>>> newSubLists = new ArrayList<>();
		for(int i = 0; i < subLists.size(); i++) {
			if(!newSubLists.contains(subLists.get(i))) {
				newSubLists.add(subLists.get(i));
			}
		}
		return newSubLists;
	}
}

