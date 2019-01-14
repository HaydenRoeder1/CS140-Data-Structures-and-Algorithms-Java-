package assignment08;
import java.util.List;
import java.util.stream.*;
public class Assignment8 {
	public static List<String> selectFrom(List<String> lst,char letter){
		return lst.stream().filter(e -> e.charAt(0) == letter || e.toLowerCase().charAt(0) == letter).collect(Collectors.toList());
	}
}
