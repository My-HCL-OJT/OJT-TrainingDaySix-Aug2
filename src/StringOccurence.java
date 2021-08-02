import java.util.HashMap;
import java.util.Map;

public class StringOccurence {

	public static void main(String[] args) {

		String input="Ram is good and Ram is innocent";
		Map<String,Integer> map=new HashMap<>();
		String[] strArr=input.split(" ");
		String str="";
		for(String word:strArr) {
			if(!str.isEmpty()) {
				str=str+" ";
			}
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
				str=str+word+map.get(word);
			}
			else {
				map.put(word, 1);
				str=str+word;
			}
		}
		
		System.out.println("output is "+str);
	}

}
