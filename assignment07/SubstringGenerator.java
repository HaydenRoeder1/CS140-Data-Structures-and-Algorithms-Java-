package assignment07;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
public class SubstringGenerator {
	public static Set<String> subStrings(String base){

		Set<String> subs = new TreeSet<String>();
		subs.add("");
		if(base.length() > 0) {
			subs.add(base);
			subs.addAll(subStrings(base.substring(1, base.length())));
			subs.addAll(subStrings(base.substring(0, base.length() - 1)));
		}
		return subs;
	}
	public static List<String> subStrings1(String base){
		List<String> subs = new ArrayList<String>();
		subs.add("");
		return subStringsHelper(base, subs);
	}
	public static List<String> subStringsHelper(String base, List<String> temp){
		if(base.length() == 1) {
			temp.add(base);
			return temp;
		}
		for(int i = 1; i <= base.length(); i++) {
			temp.add(base.substring(0, i));
		}
		return subStringsHelper(base.substring(1), temp);
		
	}
}
