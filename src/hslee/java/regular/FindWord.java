package hslee.java.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {
	public FindWord(String pInput, String pFind) {
		String pInputLowerCase = pInput.toLowerCase();
		String ptnString = "(.*)"+pFind+"(.*)";
		Pattern ptn=Pattern.compile(ptnString);
		Matcher matcher = ptn.matcher(pInputLowerCase);
		if(matcher.find()){
			System.out.println(matcher.group());
		}else{
			System.out.println("Not founded");
		}
	}

	public static void main(String[] args) {
		FindWord findWord = new FindWord("Wow,,Door is Closed!!", "close");

	}

}
