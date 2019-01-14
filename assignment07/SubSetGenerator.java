package assignment07;
import java.util.List;
import java.util.ArrayList;
public class SubSetGenerator {
	public static List<String> subSet(String base){
		List<String> subs = new ArrayList<String>();
		subs.add("");
		return subSetHelper(base, subs);
	}
	public static List<String> subSetHelper(String base, List<String> temp){
		if(base.length() <= 1 && !temp.contains(base)) {
			temp.add(base);
			return temp;
		}
		if(base.length() > 1) {
			String first = base.substring(0,1);
			temp.addAll(subSetHelper(base.substring(1), temp));
			int listSize = temp.size();
			for(int i = 0; i < listSize; i++){
				if(!temp.contains(first + temp.get(i)))
					temp.add(first + temp.get(i));
			}
		}
		List<String> retList = new ArrayList<String>();
		for(int i = 0; i < temp.size(); i++) {
			if(!retList.contains(temp.get(i))){
				retList.add(temp.get(i));
			}
		}
		return retList;
	}
}
